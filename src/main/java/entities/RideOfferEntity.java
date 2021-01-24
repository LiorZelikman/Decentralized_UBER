package entities;

import generated.RideOffer;
import generated.RideRequest;

import javax.persistence.Id;

import javax.persistence.Entity;
import java.awt.geom.Point2D;
import java.time.LocalDate;

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

    public RideOfferEntity(String firstName, String lastName, String phone, int id, boolean satisfied, RideRequest req) {
        super(req);
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.offerId = id;
        this.satisfied = satisfied;
    }

    public RideOfferEntity(RideOffer offer, RideRequest req){
        this(offer.getFirstName(), offer.getLastName(), offer.getPhone(), offer.getId(), req);
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
}
