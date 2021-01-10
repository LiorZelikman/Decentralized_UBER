package entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.awt.geom.Point2D;
import java.util.Date;
import java.util.Objects;

@Entity
public class Ride {
    @Id
    private Long ride_id;

    private String first_name;
    private String last_name;
    private Integer phone_number;
    private Point2D.Double starting_pos;
    private Point2D.Double ending_pos;
    private Date departure_date;
    private Integer vacancies;

    protected Ride(){}

    public Ride(Long ride_id, String first_name, String last_name, Integer phone_number, Point2D.Double starting_pos, Point2D.Double ending_pos, Date departure_date, Integer vacancies) {
        this.ride_id = ride_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.phone_number = phone_number;
        this.starting_pos = starting_pos;
        this.ending_pos = ending_pos;
        this.departure_date = departure_date;
        this.vacancies = vacancies;
    }

    public Long getRide_id() {
        return ride_id;
    }

    public void setRide_id(Long ride_id) {
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

    public Integer getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(Integer phone_number) {
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

    public Date getDeparture_date() {
        return departure_date;
    }

    public void setDeparture_date(Date departure_date) {
        this.departure_date = departure_date;
    }

    public Integer getVacancies() {
        return vacancies;
    }

    public void setVacancies(Integer vacancies) {
        this.vacancies = vacancies;
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
                && Objects.equals(this.departure_date, ride.departure_date) && Objects.equals(this.vacancies, ride.vacancies);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.ride_id, this.first_name, this.last_name, this.phone_number, this.starting_pos, this.ending_pos, this.departure_date, this.vacancies);
    }

    @Override
    public String toString() {
        return "entities.Ride{" + "id=" + this.ride_id + ", first name='" + this.first_name + '\'' + ", last name='" + this.last_name + '\''
                + ", phone number='" + this.phone_number + '\'' + ", starting position='" + this.starting_pos.toString() + '\''
                + ", ending position='" + this.ending_pos + '\'' + ", departure date='" + this.departure_date + '\''
                + ", vacancies='" + this.vacancies + '\'' + '}';
    }
}
