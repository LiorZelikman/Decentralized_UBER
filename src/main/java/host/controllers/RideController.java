package host.controllers;


import entities.PathRequest;
import entities.Ride;
import entities.RideOfferEntity;
import entities.RideRequestEntity;
import host.Server;
import org.apache.zookeeper.KeeperException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.context.ServletWebServerInitializedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.util.Pair;
import org.springframework.web.bind.annotation.*;
import services.RidesService;

import javax.persistence.criteria.CriteriaBuilder;
import java.awt.geom.Point2D;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
public class RideController implements ApplicationListener<ServletWebServerInitializedEvent> {

    @Value("${server.port}")
    private Integer myPort;
    private final RidesService service;


    public RideController(){
        this.service = new RidesService();
    }

    @Override
    public void onApplicationEvent(ServletWebServerInitializedEvent event) {
        myPort = event.getWebServer().getPort();
        try {
            service.setPort(myPort);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @PostMapping(path  = "/rideRequest")
    RideOfferEntity requestRide(@RequestBody RideRequestEntity req) throws KeeperException, InterruptedException {
        return service.requestRide(req, true).getSecond();
    }

    @GetMapping(path = "/rides")
    Collection<Ride> getAllRides(){
        return service.getAllRides();
    }

    @GetMapping(path = "/test")
    String test(){
        return service.test();
    }

    @PostMapping(path = "/rides/")
    Ride newRides(@RequestBody Ride newRide) throws KeeperException, InterruptedException {
        return service.save(newRide);
    }

    @GetMapping(path = "/snapshot")
    Pair<ArrayList<Ride>, ArrayList<RideOfferEntity>> getSnapshot(){return service.getSnapshot();};

    @PostMapping(path = "/path/")
    List<RideOfferEntity> pathPlanning(@RequestBody List<RideRequestEntity> pathRequest) throws KeeperException, InterruptedException { return service.planPath(pathRequest); }

    @DeleteMapping(path = "/zk")
    boolean killZKServers(){
        for (Process pr : Server.zkServers) {
            pr.destroy();
        }
        return true;
    }

}
