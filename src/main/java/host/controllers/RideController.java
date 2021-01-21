package host.controllers;


import entities.PathRequest;
import entities.Ride;
import entities.RideOfferEntity;
import entities.RideRequestEntity;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.context.ServletWebServerInitializedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
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
    RideOfferEntity requestRide(@RequestBody RideRequestEntity req){
        return service.requestRide(req);
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
    Ride newRides(@RequestBody Ride newRide){
        return service.save(newRide);
    }

    @PostMapping(path = "/path/")
    List<RideOfferEntity> pathPlanning(@RequestBody PathRequest pathRequest){ return service.planPath(pathRequest); }

}
