package gRPCServices;

import entities.Ride;
import entities.RideOfferEntity;
import entities.RideRequestEntity;
import generated.Point;
import generated.RideOffer;
import generated.RideRequest;
import generated.ServerCommunicationGrpc;
import io.grpc.stub.StreamObserver;
import org.apache.zookeeper.KeeperException;
import services.RidesService;
import zk.ZKConnection;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;


public class GRPCService extends ServerCommunicationGrpc.ServerCommunicationImplBase{
    private final ConcurrentMap<Integer, Ride> rides;
    private final ConcurrentHashMap<Integer, RideOfferEntity> rideOffers;
    private ZKConnection zooKeeper;

    public GRPCService(ConcurrentMap<Integer, Ride> rides, ConcurrentHashMap<Integer, RideOfferEntity> rideOffers, ZKConnection zooKeeper) {
        this.rides = rides;
        this.rideOffers = rideOffers;
        this.zooKeeper = zooKeeper;
    }

    @Override
    public void hasCompatibleRide(RideRequest rideRequest, StreamObserver<RideOffer> responseObserver){
        for(Ride currentRide : rides.values()){
            if(currentRide.doesRideMatch(rideRequest)){
                RideRequestEntity rideRequestEntity = new RideRequestEntity(rideRequest);
                try {
                    rideRequestEntity.setRequestId(zooKeeper.supplyID());
                    zooKeeper.assign(currentRide.getRide_id(), rideRequestEntity.toRideRequest());
                } catch (KeeperException|InterruptedException e) {
                    e.printStackTrace();
                    System.out.println("hasCompatibleRide - supplyID failed (somehow)");
                }
                RideOfferEntity offer = rideOffers.get(rideRequestEntity.getRequestId());
                //RideOffer offer = assignRide(rides, ride.getRide_id());
                if(offer.isSatisfied()){
                    responseObserver.onNext(currentRide.toRideOffer());
                    break;
                }
                /*
                if(RidesService.assignRide(rides, currentRide.getRide_id()) != null){
                    responseObserver.onNext(currentRide.toRideOffer());
                    break;
                }*/
            }
        }
        responseObserver.onCompleted();
    }
}
