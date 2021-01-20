package gRPCServices;

import generated.Point;
import generated.RideOffer;
import generated.RideRequest;
import generated.ServerCommunicationGrpc;
import io.grpc.Channel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

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


    public RideOffer hasCompatibleRide(RideRequest req){

        for(Map.Entry<Point2D.Double, ArrayList<Integer>> entry : city_to_grpc_port.entrySet()){
            for(Integer port : entry.getValue()){
                Channel newChannel = ManagedChannelBuilder.
                        forAddress("127.0.0.1", port)
                        .usePlaintext().build();
                ServerCommunicationGrpc.ServerCommunicationBlockingStub newStub = ServerCommunicationGrpc.newBlockingStub(newChannel);
                try {
                    RideOffer offer = newStub.hasCompatibleRide(req);
                    if (offer.getPhone().equals("")) {
                        break;
                    } else {
                        return offer;
                    }
                } catch(Exception e){ }
            }
            /*entry.getValue().hasCompatibleRide(req, new StreamObserver<RideOffer>() {

                @Override
                public void onNext(RideOffer value) {
                    finalOffer.putIfAbsent(2, value);
                }

                @Override
                public void onError(Throwable t) {
                    currentServers.put(entry.getKey(), currentServers.get(entry.getKey()) + 1);
                    Channel newChannel = ManagedChannelBuilder.
                            forAddress("127.0.0.1", city_to_grpc_port.get(entry.getKey()).get(currentServers.get(entry.getKey())))
                            .usePlaintext().build();
                    ServerCommunicationGrpc.ServerCommunicationStub newStub = ServerCommunicationGrpc.newStub(newChannel);
                    newStub.hasCompatibleRide(req, this);
                }

                @Override
                public void onCompleted() {
                    isFinished.put(entry.getKey(), true);
                }
            });*/
        }
        return null;
    }

    public void occupyRide(Integer rideID) {

    }

}
