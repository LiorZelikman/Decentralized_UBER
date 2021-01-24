package entities;


import generated.Point;
import generated.RideRequest;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.awt.geom.Point2D;
import java.time.LocalDate;

@Entity
public class RideRequestEntity {
    @Id
    private int requestId;

    private Point2D.Double srcPoint;
    private Point2D.Double dstPoint;
    private LocalDate departureDate;


    protected RideRequestEntity() { }

    public RideRequestEntity(Point2D.Double srcPoint, Point2D.Double dstPoint, LocalDate departureDate) {
        this.srcPoint = srcPoint;
        this.dstPoint = dstPoint;
        this.departureDate = departureDate;
    }

    public RideRequestEntity(RideRequest req){
        this.srcPoint = new Point2D.Double(req.getSrcPoint().getX(), req.getSrcPoint().getY());
        this.dstPoint = new Point2D.Double(req.getDstPoint().getX(), req.getDstPoint().getY());
        String[] date = req.getDate().split("-");
        int year = Integer.parseInt(date[0]);
        int mon = Integer.parseInt(date[1]);
        int day = Integer.parseInt(date[2]);
        this.departureDate = LocalDate.of(year, mon, day);

    }

    public Point2D.Double getSrcPoint() {
        return srcPoint;
    }

    public void setSrcPoint(Point2D.Double srcPoint) {
        this.srcPoint = srcPoint;
    }

    public Point2D.Double getDstPoint() {
        return dstPoint;
    }

    public void setDstPoint(Point2D.Double dstPoint) {
        this.dstPoint = dstPoint;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public RideRequest toRideRequest(){
        return RideRequest.newBuilder()
                .setSrcPoint(Point.newBuilder().setX(this.getSrcPoint().getX()).setY(this.getSrcPoint().getY()).build())
                .setDstPoint(Point.newBuilder().setX(this.getDstPoint().getX()).setY(this.getDstPoint().getY()).build())
                .setDate(this.getDepartureDate().toString())
                .build();
    }

    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }
}
