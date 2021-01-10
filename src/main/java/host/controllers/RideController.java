package host.controllers;


import entities.Ride;
import org.springframework.web.bind.annotation.*;
import services.RidesService;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Map;

@RestController
public class RideController {


    private final RidesService service;


    public RideController(){
        this.service = new RidesService();
    }


    @GetMapping(path = "/rides")
    Map<Point2D.Double, ArrayList<Ride>> getAllRides(){
        return service.getAllRides();
    }


    @PostMapping(path = "/rides")
    Ride newRide(@RequestBody Ride newRide){
        return service.save(newRide);
    }
}
