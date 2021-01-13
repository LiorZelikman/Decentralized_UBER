package host.controllers;


import entities.Ride;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.context.ServletWebServerInitializedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;
import services.RidesService;

import javax.persistence.criteria.CriteriaBuilder;
import java.awt.geom.Point2D;
import java.util.ArrayList;
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
        service.updatePort(myPort);
    }

    @GetMapping(path = "/rides")
    ArrayList<Ride> getAllRides(){
        return service.getAllRides();
    }


    @PostMapping(path = "/rides")
    Ride newRide(@RequestBody Ride newRide){
        return service.save(newRide);
    }


}
