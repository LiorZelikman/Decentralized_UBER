package entities;

import generated.RideOffer;
import javax.persistence.Id;

import javax.persistence.Entity;

@Entity
public class RideOfferEntity {
    @Id
    private Integer offerId;

    private String firstName;
    private String lastName;
    private String phone;

    public RideOfferEntity() {
    }

    public RideOfferEntity(String firstName, String lastName, String phone, int id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.offerId = id;
    }

    public RideOfferEntity(RideOffer offer){
        this(offer.getFirstName(), offer.getLastName(), offer.getPhone(), offer.getId());
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
}
