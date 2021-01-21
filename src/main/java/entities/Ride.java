package entities;

import generated.Point;
import generated.RideOffer;
import generated.RideRequest;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.awt.geom.Point2D;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Ride {
    @Id
    private Integer ride_id;

    private String first_name;
    private String last_name;
    private String phone_number;
    private Point2D.Double starting_pos;
    private Point2D.Double ending_pos;
    private LocalDate departure_Date;
    private Integer vacancies;
    private Double PD;

    protected Ride(){}

    public Ride(Ride ride){
        this.ride_id = ride.ride_id;
        this.first_name = ride.first_name;
        this.last_name = ride.last_name;
        this.phone_number = ride.phone_number;
        this.starting_pos = ride.starting_pos;
        this.ending_pos = ride.ending_pos;
        this.departure_Date = ride.departure_Date;
        this.vacancies = ride.vacancies;
        this.PD = ride.PD;
    }

    public Ride(Integer ride_id, String first_name, String last_name, String phone_number, Point2D.Double starting_pos, Point2D.Double ending_pos, LocalDate departure_Date, Integer vacancies, Double PD) {
        this.ride_id = ride_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.phone_number = phone_number;
        this.starting_pos = starting_pos;
        this.ending_pos = ending_pos;
        this.departure_Date = departure_Date;
        this.vacancies = vacancies;
        this.PD = PD;
    }

    public Integer getRide_id() {
        return ride_id;
    }

    public void setRide_id(Integer ride_id) {
        this.ride_id = ride_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public Point2D.Double getStarting_pos() {
        return starting_pos;
    }

    public void setStarting_pos(Point2D.Double starting_pos) {
        this.starting_pos = starting_pos;
    }

    public Point2D.Double getEnding_pos() {
        return ending_pos;
    }

    public void setEnding_pos(Point2D.Double ending_pos) {
        this.ending_pos = ending_pos;
    }

    public Integer getVacancies() {
        return vacancies;
    }

    public void setVacancies(Integer vacancies) {
        this.vacancies = vacancies;
    }

    public LocalDate getDeparture_Date() {
        return departure_Date;
    }

    public void setDeparture_Date(LocalDate departure_Date) {
        this.departure_Date = departure_Date;
    }

    public Double getPD() {
        return PD;
    }

    public void setPD(Double PD) {
        this.PD = PD;
    }

    public boolean doesRideMatch(RideRequest rr){
        if(!rr.getDate().equals(this.getDeparture_Date().toString())){
            return false;
        }
        return this.isInPD(rr.getSrcPoint()) && this.isInPD(rr.getDstPoint());
    }

    private boolean isInPD(Point extraPoint){
        return (this.distance(extraPoint) <= this.getPD());
    }

    private Double distance(Point extraPoint){

        Point2D.Double extraPoint2D = new Point2D.Double(extraPoint.getX(), extraPoint.getY());
        if ((extraPoint2D.x < this.getStarting_pos().x && extraPoint2D.x < this.getEnding_pos().x) ||
                (extraPoint2D.x > this.getStarting_pos().x && extraPoint2D.x > this.getEnding_pos().x) ||
                (extraPoint2D.y < this.getStarting_pos().y && extraPoint2D.y < this.getEnding_pos().y) ||
                (extraPoint2D.y > this.getStarting_pos().y && extraPoint2D.y > this.getEnding_pos().y)) {
            return Math.min(extraPoint2D.distance(this.getStarting_pos()), extraPoint2D.distance(this.getEnding_pos()));
        } else {
            double orgXDist = this.getEnding_pos().x - this.getStarting_pos().x;
            double orgYDist = this.getEnding_pos().y - this.getStarting_pos().y;
            double extraSrcYDist = this.getStarting_pos().y - extraPoint2D.y;
            double extraSrcXDist = this.getStarting_pos().x - extraPoint2D.x;
            return ( Math.abs(( (orgXDist)*(extraSrcYDist) ) - ( (extraSrcXDist)*(orgYDist) ) ) /
                    ( Math.sqrt( Math.pow(orgXDist, 2) + Math.pow(orgYDist, 2)) ) );
        }
    }

    public RideOffer toRideOffer(){
        return RideOffer.newBuilder().setFirstName(this.getFirst_name())
                .setLastName(this.getLast_name()).setPhone(this.getPhone_number()).setId(this.getRide_id()).build();
    }


    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;
        if (!(o instanceof Ride))
            return false;
        Ride ride = (Ride) o;
        return Objects.equals(this.ride_id, ride.ride_id) && Objects.equals(this.first_name, ride.first_name)
                && Objects.equals(this.last_name, ride.last_name) && Objects.equals(this.phone_number, ride.phone_number)
                && Objects.equals(this.starting_pos, ride.starting_pos) && Objects.equals(this.ending_pos, ride.ending_pos)
                && Objects.equals(this.departure_Date.toString(), ride.departure_Date.toString()) && Objects.equals(this.vacancies, ride.vacancies)
                && Objects.equals(this.PD, ride.PD);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.ride_id, this.first_name, this.last_name, this.phone_number, this.starting_pos, this.ending_pos, this.departure_Date, this.vacancies);
    }

    @Override
    public String toString() {
        return "entities.Ride{" + "id=" + this.ride_id + ", first name='" + this.first_name + '\'' + ", last name='" + this.last_name + '\''
                + ", phone number='" + this.phone_number + '\'' + ", starting position='" + this.starting_pos.toString() + '\''
                + ", ending position='" + this.ending_pos + '\'' + ", departure LocalDate='" + this.departure_Date + '\''
                + ", vacancies='" + this.vacancies + '\'' +  ", PD='" + this.PD + '}';
    }

    public String toCustomString(){
        return "" + this.ride_id + ";" + this.first_name + ";" + this.last_name + ";" + this.phone_number + ";"
                + this.starting_pos.x + ";" + + this.starting_pos.y + ";" + this.ending_pos.x + ";" + this.starting_pos.y + ";"
                + this.departure_Date + ";" + this.vacancies + ";" +  + this.PD + ";";

    }
}
