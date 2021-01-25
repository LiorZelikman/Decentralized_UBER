package zk;

import entities.Ride;
import entities.RideOfferEntity;
import entities.RideRequestEntity;
import generated.RideRequest;
import org.apache.zookeeper.*;
import services.RidesService;

import java.awt.geom.Point2D;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;

public class ZookeeperWatcher implements Watcher {
    ZooKeeper zkClient;
    Integer port;
    private ConcurrentHashMap<Integer, Ride> rides;
    private ConcurrentHashMap<Integer, RideOfferEntity> rideOffers;

    public ZookeeperWatcher(){ }

    public void setFields(ZooKeeper zkClient, Integer port, ConcurrentHashMap<Integer, Ride> rides, ConcurrentHashMap<Integer, RideOfferEntity> rideOffers){
        this.zkClient = zkClient;
        this.port = port;
        this.rides = rides;
        this.rideOffers = rideOffers;
    }

    public String getZNodeData(String path) throws KeeperException, InterruptedException {
        byte[] b;
        b = zkClient.getData(path, null, null);
        return new String(b, StandardCharsets.UTF_8);
    }

    public void clearNodes(String megaPathToDelete){
        long start = System.currentTimeMillis();
        long end = start + 30*1000;
        while (System.currentTimeMillis() < end) {
            try {
                //checking if the path (i.e. all of its children) was deleted
                if (zkClient.getAllChildrenNumber(megaPathToDelete) == 0) {
                    break;
                }
            } catch (KeeperException | InterruptedException e) { }
        }

        //trying to delete the path (and all its children in any case
        for (int i = 0; i < RidesService.servers_per_city; i++) {
            try {
                zkClient.delete(megaPathToDelete + "/" + (i + 1), -1);
            } catch(KeeperException | InterruptedException e) {}
        }
        try {
            zkClient.delete(megaPathToDelete, -1);
            //unlock her and may god be with us
        } catch(Exception e) {}
    }

    @Override
    public void process(WatchedEvent event) {
        String path = event.getPath();
        String serverID = "" + port%10;
        if(path == null){
            return;
        }
        if(path.equals("/add_operation")){
            try {
                String timestamp = getZNodeData(path);
                String megaPathToDelete = "/added_" + timestamp;
                String pathToDelete = megaPathToDelete + "/" + serverID;
                String data = getZNodeData(megaPathToDelete);
                Ride newRide = new Ride(data);
                rides.put(newRide.getRide_id(), newRide);
                zkClient.delete(pathToDelete, -1);
                clearNodes(megaPathToDelete);

            }
            catch (KeeperException | InterruptedException e) {
                e.printStackTrace();
            }

        } else if (path.equals("/assign_operation")){
            try {
                String timestamp = getZNodeData(path);
                String megaPathToDelete = "/assigned_" + timestamp;
                String pathToDelete = megaPathToDelete + "/" + serverID;
                String[] data = getZNodeData(megaPathToDelete).split(";");
                Integer rideID = Integer.valueOf(data[0]);
                String rideOfferDescription = String.join(";", Arrays.copyOfRange(data, 1, data.length));
                RideOfferEntity rideOfferEntity = new RideOfferEntity(rideOfferDescription);

                Integer requestID = Integer.valueOf(data[6]);
                if(rideID == -1){
                    RideOfferEntity newRideOffer = new RideOfferEntity(rideOfferEntity.toRideRequest());
                    rideOffers.put(requestID, newRideOffer);
                } else {
                    Ride ride = rides.get(rideID);
                    if (ride != null) {
                        Integer newVacancies = ride.getVacancies() - 1;
                        if (newVacancies >= 0) {
                            Ride newRide = new Ride(ride);
                            newRide.setVacancies(newVacancies);
                            rides.replace(rideID, ride, newRide);
                            RideOfferEntity newRideOffer = new RideOfferEntity(newRide.toRideOffer(), rideOfferEntity.toRideRequest());
                            rideOffers.put(requestID, newRideOffer);
                        }
                    }
                }
                zkClient.delete(pathToDelete, -1);
                clearNodes(megaPathToDelete);

            } catch (KeeperException | InterruptedException e){}
        } else if (path.equals("/unassign_operation")){
            try {
                String timestamp = getZNodeData(path);
                String megaPathToDelete = "/unassigned_" + timestamp;
                String pathToDelete = megaPathToDelete + "/" + serverID;
                Integer requestId = Integer.valueOf(getZNodeData(megaPathToDelete));
                RideOfferEntity rideOfferEntity = rideOffers.get(requestId);

                Integer rideID = rideOfferEntity.getOfferId();
                Ride ride = rides.get(rideID);
                Integer newVacancies = ride.getVacancies() + 1;
                Ride newRide = new Ride(ride);
                newRide.setVacancies(newVacancies);
                rides.replace(rideID, ride, newRide);

                RideOfferEntity newRideOffer = new RideOfferEntity(rideOfferEntity.toRideRequest());
                rideOffers.replace(requestId, rideOfferEntity, newRideOffer);
                zkClient.delete(pathToDelete, -1);
                clearNodes(megaPathToDelete);

            } catch (KeeperException | InterruptedException e){}
        }
        else {
            System.out.println("How did you get here?");
        }
    }



    /*System.out.println("In process");
        if(zkClient != null) {
            try {
                zkClient.addWatch("/write_operation", this, AddWatchMode.PERSISTENT);
            } catch (KeeperException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }*/
}
