package gRPCServices;

import entities.Ride;
import generated.Point;
import generated.RideOffer;
import generated.RideRequest;
import generated.ServerCommunicationGrpc;
import io.grpc.stub.StreamObserver;
import services.RidesService;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentMap;


public class GRPCService extends ServerCommunicationGrpc.ServerCommunicationImplBase{
    private final ConcurrentMap<Integer, Ride> rides;

    public GRPCService(ConcurrentMap<Integer, Ride> rides) {
        this.rides = rides;
    }

    @Override
    public void hasCompatibleRide(RideRequest rideRequest, StreamObserver<RideOffer> responseObserver){
        for(Ride currentRide : rides.values()){
            if(currentRide.doesRideMatch(rideRequest)){
                if(RidesService.assignRide(rides, currentRide.getRide_id()) != null){
                    responseObserver.onNext(currentRide.toRideOffer());
                    break;
                }
            }
        }
        responseObserver.onCompleted();
    }



    @Override
    public void occupyRide(RideOffer request, StreamObserver<RideOffer> responseObserver) {
        responseObserver.onNext(RidesService.assignRide(rides, request.getId()));
        responseObserver.onCompleted();
    }
}
