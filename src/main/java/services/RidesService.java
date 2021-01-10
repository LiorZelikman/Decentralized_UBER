package services;

import entities.Ride;
import org.springframework.stereotype.Component;

import java.awt.geom.Point2D;
import java.util.*;

@Component
public class RidesService {
    private final HashMap<Point2D.Double, ArrayList<Ride>> rides;

    public RidesService() {

        rides = new HashMap<>();
        Ride firstRide = new Ride(Integer.toUnsignedLong(1), "vladimir", "vladimiravich", 123456789, new Point2D.Double(0,0), new Point2D.Double(1,1), new Date(), 4);
        ArrayList<Ride> firstRideArray = new ArrayList<>();
        firstRideArray.add(firstRide);
        rides.put(firstRide.getStarting_pos(), firstRideArray);
    }

    public Map<Point2D.Double, ArrayList<Ride>> getAllRides(){
        return rides;
    }

    public Ride save(Ride newRide) {
        Point2D.Double key = newRide.getStarting_pos();
        ArrayList<Ride> ridesFromCity = rides.get(key);
        if (ridesFromCity == null){
            ridesFromCity = new ArrayList<>();
        }
        ridesFromCity.add(newRide);
        rides.put(key, ridesFromCity);
        return newRide;
    }
}
