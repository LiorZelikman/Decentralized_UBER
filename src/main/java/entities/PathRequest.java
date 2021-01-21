package entities;

import org.springframework.beans.factory.annotation.Value;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.awt.geom.Point2D;
import java.time.LocalDate;
import java.util.List;

@Entity
public class PathRequest {
    @Id
    private Integer rideID;

    @ElementCollection
    private List<Point2D.Double> citiesList;
    private LocalDate departureDate;

    protected PathRequest(){ }

    public PathRequest(List<Point2D.Double> citiesList, LocalDate departureDate) {
        this.citiesList = citiesList;
        this.departureDate = departureDate;
    }
}
