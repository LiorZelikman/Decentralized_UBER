package entities;

import generated.RideOffer;
import generated.RideRequest;
import org.apache.logging.log4j.util.Strings;

import javax.persistence.Id;

import javax.persistence.Entity;
import java.awt.geom.Point2D;
import java.time.LocalDate;
import java.util.Arrays;

@Entity
public class RideOfferEntity extends RideRequestEntity {
    @Id
    private Integer offerId;

    private String firstName;
    private String lastName;
    private String phone;
    private boolean satisfied;

    public RideOfferEntity() {
    }

    public RideOfferEntity(String firstName, String lastName, String phone, boolean satisfied, Integer offerID, RideRequest req) {
        super(req);
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.satisfied = satisfied;
        this.offerId = offerID;
    }

    public RideOfferEntity(RideOffer offer, RideRequest req){
        this(offer.getFirstName(), offer.getLastName(), offer.getPhone(), offer.getSatisfied(), offer.getId(), req);
    }

    public RideOfferEntity(RideRequest req){
        this("No ride found", "", "", false, -1, req);
    }

    public RideOfferEntity(String description){
        super(String.join(";", Arrays.copyOfRange(description.split(";"), 5, description.split(";").length)));
        String[] fields = description.split(";");
        this.offerId = Integer.parseInt(fields[0]);
        this.firstName = fields[1];
        this.lastName = fields[2];
        this.phone = fields[3];
        this.satisfied = Boolean.parseBoolean(fields[4]);

    }

    public Integer getOfferId() {
        return offerId;
    }

    public void setOfferId(Integer offerId) {
        this.offerId = offerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isSatisfied() {
        return satisfied;
    }


    public void setSatisfied(boolean satisfied) {
        this.satisfied = satisfied;
    }

    public String toCustomString(){
        return "" + this.offerId + ";" + this.firstName + ";" + this.lastName + ";" + this.phone + ";" + this.satisfied + ";" + super.getCustomString();
    }
}
