package gRPCServices;

import generated.RideOffer;
import generated.RideRequest;
import generated.ServerCommunicationGrpc;
import io.grpc.stub.StreamObserver;


public class ServerCommunicationService extends ServerCommunicationGrpc.ServerCommunicationImplBase{
    public ServerCommunicationService() {}

    @Override
    public void hasCompatibleRide(RideRequest rideRequest, StreamObserver<RideOffer> responseObserver){

    }
}
