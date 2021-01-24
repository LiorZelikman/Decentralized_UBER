package services;

import entities.PathRequest;
import entities.Ride;
import entities.RideOfferEntity;
import entities.RideRequestEntity;
import gRPCServices.GRPCClient;
import gRPCServices.GRPCServer;
import gRPCServices.GRPCService;
import generated.RideOffer;
import generated.RideRequest;
import generated.ServerCommunicationGrpc;
import io.grpc.Channel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import org.apache.zookeeper.AddWatchMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;
import org.springframework.stereotype.Component;
import zk.ZKConnection;
import zk.ZookeeperWatcher;

import java.awt.geom.Point2D;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;


//{"ride_id":1,"first_name":"Israel","last_name":"Israeli","phone_number":123456789,"starting_pos":{"x":0.0,"y":0.0},"ending_pos":{"x":1.0,"y":1.0},"departure_Date":"2021-01-11","vacancies":4}
@Component
public class RidesService{

    private final ConcurrentHashMap<Integer, Ride> rides;
    private final ConcurrentHashMap<Integer, RideOfferEntity> rideOffers;

    private Point2D.Double myCity;
//    private ZooKeeper zkClient;
//    private ZookeeperWatcher zkWatcher;

    private ZKConnection zooKeeper;

    private Integer myHttpPort;
    private Integer myGrpcPort;

    private static final Map<Point2D.Double, ArrayList<Integer>> city_to_http_port;

    private static final Map<Point2D.Double, ArrayList<Integer>> city_to_grpc_port;

    public static final Integer servers_per_city = 3;
    public static final Integer number_of_cities = 3;

    //private static final Map<Point2D.Double, ArrayList<ServerCommunicationGrpc.ServerCommunicationBlockingStub>> blockingStubs;

    //private static final ServerCommunicationGrpc.ServerCommunicationStub hastub;

    private GRPCServer grpcServer;
    private GRPCClient grpcClient;

    static {
        city_to_http_port = Map.of(
                new Point2D.Double(0.0,0.0), new ArrayList<Integer>(List.of(10001, 10002, 10003)), //Haifa
                new Point2D.Double(35.0,96.0), new ArrayList<Integer>(List.of(20001, 20002, 20003)), //Saratov
                new Point2D.Double(72.0,15.0), new ArrayList<Integer>(List.of(30001, 30002, 30003)) //Afula
        );

        city_to_grpc_port = Map.of(
                new Point2D.Double(0.0,0.0), new ArrayList<Integer>(List.of(11001, 11002, 11003)), //Haifa
                new Point2D.Double(35.0,96.0), new ArrayList<Integer>(List.of(21001, 21002, 21003)), //Saratov
                new Point2D.Double(72.0,15.0), new ArrayList<Integer>(List.of(31001, 31002, 31003)) //Afula
        );

        GRPCClient.city_to_grpc_port = city_to_grpc_port;
    }

    public RidesService(){
        grpcClient = new GRPCClient();
        rides = new ConcurrentHashMap<>();
        rideOffers = new ConcurrentHashMap<>();
        rides.put(0, new Ride(0, "Jhony", "Walker", "0550770077",
                new Point2D.Double(0.0, 0.0), new Point2D.Double(2.0, 2.0),
                LocalDate.now(), 2, 2.0));
    }

    public void setPort(Integer port) throws IOException {
        //Setting my city based on my port
        myHttpPort = port;
        myGrpcPort = port + 1000;
        for (Map.Entry<Point2D.Double, ArrayList<Integer>> city: city_to_http_port.entrySet()) {
            ArrayList<Integer> city_ports = city.getValue();
            if(city_ports.contains(myHttpPort)){
                myCity = city.getKey();
                System.out.println(myCity);
                break;
            }
        }

        //starting the zookeeper client that corresponds to this port
        try{
            this.zooKeeper = new ZKConnection(myHttpPort, rides, rideOffers);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

        //Starting the gRPC server that corresponds to this port
        grpcServer = new GRPCServer(myGrpcPort, rides, rideOffers, zooKeeper);
        grpcServer.start();


    }
/*
    public static RideOffer assignRide(ConcurrentMap<Integer, Ride> rides, Integer rideID){
        Ride ride = rides.get(rideID);
        if(ride == null){
            return null;
        }
        Ride newRide = new Ride(ride);
        int vacancies = newRide.getVacancies() - 1;
        if (vacancies == 0){
            if(!(rides.remove(rideID, ride))){
                return null;
            }
        } else {
            newRide.setVacancies(vacancies);

            if(!(rides.replace(rideID, ride, newRide))){
                return null;
            }
        }
        return newRide.toRideOffer();
    }
*/

    public void addToRides(Ride newRide) {
        zooKeeper.addRide(newRide);
        //rides.put(newRide.getRide_id(), newRide);
    }


    public RideOfferEntity requestRide(RideRequestEntity reqEntity) throws KeeperException, InterruptedException {
        reqEntity.setRequestId(zooKeeper.supplyID());
        RideRequest req = reqEntity.toRideRequest();
        //rideOffers.put(reqEntity.getRequestId(), new RideOfferEntity(req));
        for(Ride ride : rides.values()){
            if(ride.doesRideMatch(req)){
                zooKeeper.assign(ride.getRide_id(), req);
                RideOfferEntity offer = rideOffers.get(reqEntity.getRequestId());

                //RideOffer offer = assignRide(rides, ride.getRide_id());
                if(offer.isSatisfied()){
                    return offer;
                }
            }
        }
        RideOffer grpcRideOffer = grpcClient.hasCompatibleRide(req);
        if(grpcRideOffer == null){
            zooKeeper.assign(-1, req);
            return new RideOfferEntity(req);
        }

        return new RideOfferEntity(grpcRideOffer, req);
    }


    public List<RideOfferEntity> planPath(PathRequest pathRequest){
        List<RideOfferEntity> offers = new ArrayList<>();
        return offers;
    }

    public String test(){
        /*RideRequest req = RideRequest.newBuilder().setSrcPoint(Point.newBuilder().setX(3.0).setY(5.7).build())
                .setDstPoint(Point.newBuilder().setX(9.4).setX(-4.2).build())
                .setDate("today").build();

        ServerCommunicationGrpc.ServerCommunicationBlockingStub stub =  blockingStubs.get(new Point2D.Double(35.0,96.0)).get(0);
        Iterator<RideOffer> rideIter = stub.hasCompatibleRide(req);
        RideOffer ride = rideIter.next();*/
        //return ride.getId();
//
//        Channel testChannel = ManagedChannelBuilder.
//                forAddress("127.0.0.1", 21001).usePlaintext().build();
//                RideOffer res = grpcClient.hasCompatibleRide(testChannel, new Point2D.Double(1.0,1.2), new Point2D.Double(1.0,100.0), LocalDate.now());
//        return (res.getFirstName() + "\n" + res.getLastName() + "\n" + res.getPhone());
        return "Test is currently unavailable";
    }

    public Collection<Ride> getAllRides(){
        return rides.values();
    }

    public Ride save(Ride newRide) throws KeeperException, InterruptedException {
        newRide.setRide_id(zooKeeper.supplyID());
        newRide.setOrig_vacancies(newRide.getVacancies());
        addToRides(newRide);
        return newRide;
    }


    /*public Integer getCompatibleRide(Point2D.Double srcPoint, Point2D.Double dstPoint, Date departureDate){
        if(srcPoint != myCity)
        for (ride : rides.get()) {

        }
    }*/

}
