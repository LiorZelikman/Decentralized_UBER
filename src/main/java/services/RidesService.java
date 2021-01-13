package services;

import entities.Ride;
import generated.Point;
import generated.RideOffer;
import generated.RideRequest;
import generated.ServerCommunicationGrpc;
import io.grpc.stub.StreamObserver;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.web.servlet.context.ServletWebServerInitializedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.awt.geom.Point2D;
import java.time.LocalDate;
import java.util.*;


//{"ride_id":1,"first_name":"Israel","last_name":"Israeli","phone_number":123456789,"starting_pos":{"x":0.0,"y":0.0},"ending_pos":{"x":1.0,"y":1.0},"departure_Date":"2021-01-11","vacancies":4}
@Component
public class RidesService extends ServerCommunicationGrpc.ServerCommunicationImplBase {

    //@Autowired
    //Environment environment;

    //@Autowired
    //private ServerProperties serverProperties;

    private final ArrayList<Ride> rides;
    private Integer id;

    private Point2D.Double myCity;

    @Value("${server.port}")
    private String strPort;

    private Integer myPort;


    private static final Map<Point2D.Double, ArrayList<Integer>> city_to_port;
    static {
        city_to_port = Map.of(
                new Point2D.Double(0.0,0.0), new ArrayList<Integer>(List.of(10001, 10002, 10003)), //Haifa
                new Point2D.Double(35.0,96.0), new ArrayList<Integer>(List.of(20001, 20002, 20003)), //Saratov
                new Point2D.Double(72.0,15.0), new ArrayList<Integer>(List.of(30001, 30002, 30003)) //Afula
        );
    }

    public RidesService(){
        System.out.println("how did I get here");
        rides = new ArrayList<>();
        id = 1;

        /*Ride firstRide = new Ride(id, "vladimir", "vladimiravich" + Math.random(), 123456789, new Point2D.Double(0,0), new Point2D.Double(1,1), LocalDate.now(), 4);
        ArrayList<Ride> firstRideArray = new ArrayList<>();
        firstRideArray.add(firstRide);
        rides.put(utils.Utils.parsePoint2D(firstRide.getStarting_pos()), firstRideArray);
        */
    }

    /*
    public RidesService(Integer port) {
        myPort = port;
        for (Map.Entry<Point2D.Double, ArrayList<Integer>> city: city_to_port.entrySet()) {
            ArrayList<Integer> city_ports = city.getValue();
            if(city_ports.contains(myPort)){
                myCity = city.getKey();
                System.out.println(myCity);
                break;
            }
        }
        rides = new ArrayList<>();
        id = 1;
    }*/

    public void updatePort(Integer port){
        myPort = port;
        for (Map.Entry<Point2D.Double, ArrayList<Integer>> city: city_to_port.entrySet()) {
            ArrayList<Integer> city_ports = city.getValue();
            if(city_ports.contains(myPort)){
                myCity = city.getKey();
                System.out.println(myCity);
                break;
            }
        }
    }

    public ArrayList<Ride> getAllRides(){
        return rides;
    }

    public Ride save(Ride newRide) {
        newRide.setRide_id(id);
        id++;
        rides.add(newRide);
        return newRide;
    }


    /*public Integer getCompatibleRide(Point2D.Double srcPoint, Point2D.Double dstPoint, Date departureDate){
        if(srcPoint != myCity)
        for (ride : rides.get()) {

        }
    }*/

}
