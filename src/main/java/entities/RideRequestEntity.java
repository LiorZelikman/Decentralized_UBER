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
        this.requestId = req.getId();
        this.srcPoint = new Point2D.Double(req.getSrcPoint().getX(), req.getSrcPoint().getY());
        this.dstPoint = new Point2D.Double(req.getDstPoint().getX(), req.getDstPoint().getY());
        String[] date = req.getDate().split("-");
        int year = Integer.parseInt(date[0]);
        int mon = Integer.parseInt(date[1]);
        int day = Integer.parseInt(date[2]);
        this.departureDate = LocalDate.of(year, mon, day);
    }

    public RideRequestEntity(String description){
        String[] fields = description.split(";");
        int year = Integer.parseInt(fields[5].split("-")[0]);
        int mon = Integer.parseInt(fields[5].split("-")[1]);
        int day = Integer.parseInt(fields[5].split("-")[2]);
        this.requestId = Integer.parseInt(fields[0]);
        this.srcPoint = new Point2D.Double(Double.parseDouble(fields[1]), Double.parseDouble(fields[2]));
        this.dstPoint = new Point2D.Double(Double.parseDouble(fields[3]), Double.parseDouble(fields[4]));
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
                .setDate(this.getDepartureDate().toString()).setId(this.getRequestId())
                .build();
    }

    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public String getCustomString(){
        return "" + this.requestId + ";" + this.srcPoint.x + ";" + this.srcPoint.y + ";" + this.dstPoint.x + ";"
                + this.dstPoint.y + ";" + this.departureDate + ";";
    }
}
