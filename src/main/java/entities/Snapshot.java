//package entities;
//
//
//import javax.persistence.Entity;
//import javax.persistence.Id;
//import java.util.ArrayList;
//
//@Entity
//public class Snapshot {
//    @Id
//    private Integer id;
//
//    private ArrayList<Ride> rides;
//    private ArrayList<RideOfferEntity> rideOffers;
//
//    public Snapshot(){
//        this.rides = new ArrayList<>();
//        this.rideOffers = new ArrayList<>();
//    }
//
//    public Snapshot(ArrayList<Ride> rides, ArrayList<RideOfferEntity> rideOffers){
//        this.rides = rides;
//        this.rideOffers = rideOffers;
//    }
//
//    public ArrayList<Ride> getRides() {
//        return rides;
//    }
//
//    public void setRides(ArrayList<Ride> rides) {
//        this.rides = rides;
//    }
//
//    public ArrayList<RideOfferEntity> getRideOffers() {
//        return rideOffers;
//    }
//
//    public void setRideOffers(ArrayList<RideOfferEntity> rideOffers) {
//        this.rideOffers = rideOffers;
//    }
//}
