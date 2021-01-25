package gRPCServices;

import entities.Ride;
import entities.RideOfferEntity;
import generated.*;
import io.grpc.Channel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import org.springframework.data.util.Pair;

import java.awt.geom.Point2D;
import java.net.ConnectException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class GRPCClient {
    public static Map<Point2D.Double, ArrayList<Integer>> city_to_grpc_port;


    public GRPCClient(){ }


    public Pair<Integer, RideOffer> hasCompatibleRide(RideRequest req){

        for(Map.Entry<Point2D.Double, ArrayList<Integer>> entry : city_to_grpc_port.entrySet()){
            for(Integer port : entry.getValue()){
                Channel newChannel = ManagedChannelBuilder.
                        forAddress("127.0.0.1", port)
                        .usePlaintext().build();
                ServerCommunicationGrpc.ServerCommunicationBlockingStub newStub = ServerCommunicationGrpc.newBlockingStub(newChannel);
                try {
                    RideOffer offer = newStub.hasCompatibleRide(req);
                    if (!offer.getSatisfied()) {
                        break;
                    } else {
                        return Pair.of(port, offer);
                    }
                } catch(Exception e){
                    System.out.println("hasCompatibleRide - exception");
                }
            }

        }
        return null;
    }


    public ArrayList<Ride> getRides(){
        ArrayList<Ride> allRides = new ArrayList<>();
        for(Map.Entry<Point2D.Double, ArrayList<Integer>> entry : city_to_grpc_port.entrySet()) {
            for (Integer port : entry.getValue()) {
                Channel newChannel = ManagedChannelBuilder.
                        forAddress("127.0.0.1", port)
                        .usePlaintext().build();
                ServerCommunicationGrpc.ServerCommunicationBlockingStub newStub = ServerCommunicationGrpc.newBlockingStub(newChannel);
                try {
                    Iterator<RideSnapshot> rides = newStub.getRides(null);
                    while (rides.hasNext()) {
                        allRides.add(new Ride(rides.next().getDescription()));
                    }
                    break;
                } catch (Exception e) {
                }
            }
        }
        return allRides;
    }

    public ArrayList<RideOfferEntity> getRideOffers(){
        ArrayList<RideOfferEntity> allRideOffers = new ArrayList<>();
        for(Map.Entry<Point2D.Double, ArrayList<Integer>> entry : city_to_grpc_port.entrySet()) {
            for (Integer port : entry.getValue()) {
                Channel newChannel = ManagedChannelBuilder.
                        forAddress("127.0.0.1", port)
                        .usePlaintext().build();
                ServerCommunicationGrpc.ServerCommunicationBlockingStub newStub = ServerCommunicationGrpc.newBlockingStub(newChannel);
                try {
                    Iterator<RideOfferSnapshot> rideOffers = newStub.getRideOffers(null);
                    while (rideOffers.hasNext()) {
                        allRideOffers.add(new RideOfferEntity(rideOffers.next().getDescription()));
                    }
                    break;
                } catch (Exception e) {
                }
            }
        }
        return allRideOffers;
    }

    public void unassign(Integer port, Integer requestId){
        for (Integer currPort : getPortsByPort(port)) {
            Channel newChannel = ManagedChannelBuilder.
                    forAddress("127.0.0.1", currPort)
                    .usePlaintext().build();
            ServerCommunicationGrpc.ServerCommunicationBlockingStub newStub = ServerCommunicationGrpc.newBlockingStub(newChannel);
            try {
                newStub.unassign(RideRequest.newBuilder().setId(requestId).build());
                break;
            } catch (Exception e) {
            }
        }
    }

    private ArrayList<Integer> getPortsByPort(Integer port){
        for(ArrayList<Integer> ports : city_to_grpc_port.values()){
            if(ports.contains(port)){
                return ports;
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        result.add(port);
        return result;
    }

}
