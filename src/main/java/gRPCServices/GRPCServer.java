package gRPCServices;

import entities.Ride;
import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.awt.geom.Point2D;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class GRPCServer {
    private static final Logger logger = Logger.getLogger(GRPCService.class.getName());

    private final int port;
    private final Server server;

    public GRPCServer(int port, ConcurrentMap<Integer, Ride> rides) throws IOException {
        this(ServerBuilder.forPort(port), port, rides);
    }

    /**
     * Create a RouteGuide server using serverBuilder as a base and features as data.
     */
    public GRPCServer(ServerBuilder<?> serverBuilder, int port, ConcurrentMap<Integer, Ride> rides) {
        this.port = port;
        server = serverBuilder.addService(new GRPCService(rides))
                .build();
    }

    /**
     * Start serving requests.
     */
    public void start() throws IOException {
        try {
            server.start();
        }catch (Exception e){
            e.printStackTrace();
        }
        logger.info("Server started, listening on " + port);
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                // Use stderr here since the logger may have been reset by its JVM shutdown hook.
                System.err.println("*** shutting down gRPC server since JVM is shutting down");
                try {
                    GRPCServer.this.stop();
                } catch (InterruptedException e) {
                    e.printStackTrace(System.err);
                }
                System.err.println("*** server shut down");
            }
        });
    }

    /**
     * Stop serving requests and shutdown resources.
     */
    public void stop() throws InterruptedException {
        if (server != null) {
            server.shutdown().awaitTermination(30, TimeUnit.SECONDS);
        }
    }

    /**
     * Await termination on the main thread since the grpc library uses daemon threads.
     */
    public void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }
}
