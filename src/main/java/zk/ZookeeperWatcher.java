package zk;

import entities.Ride;
import org.apache.zookeeper.*;
import services.RidesService;

import java.awt.geom.Point2D;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.concurrent.ConcurrentHashMap;

public class ZookeeperWatcher implements Watcher {
    ZooKeeper zkClient;
    Integer port;
    private ConcurrentHashMap<Integer, Ride> rides;

    public ZookeeperWatcher(){ }

    public void setFields(ZooKeeper zkClient, Integer port, ConcurrentHashMap<Integer, Ride> rides){
        this.zkClient = zkClient;
        this.port = port;
        this.rides = rides;
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
                String[] fields = data.split(";");
                Integer year = Integer.valueOf(fields[8].split("-")[0]);
                Integer mon = Integer.valueOf(fields[8].split("-")[1]);
                Integer day = Integer.valueOf(fields[8].split("-")[2]);
                Ride newRide = new Ride(Integer.valueOf(fields[0]), fields[1], fields[2], fields[3],
                        new Point2D.Double(Double.valueOf(fields[4]), Double.valueOf(fields[5])),
                        new Point2D.Double(Double.valueOf(fields[6]), Double.valueOf(fields[7])),
                        LocalDate.of(year, mon, day),
                        Integer.valueOf(fields[9]), Double.valueOf(fields[10]));
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
                Integer rideID = Integer.valueOf(getZNodeData(megaPathToDelete));
                Ride ride = rides.get(rideID);
                if(ride != null) {
                    Integer newVacancies = ride.getVacancies() - 1;
                    if (newVacancies == 0) {
                        rides.remove(rideID, ride);
                    } else {
                        Ride newRide = new Ride(ride);
                        newRide.setVacancies(newVacancies);
                        rides.replace(rideID, ride, newRide);
                    }
                }
                zkClient.delete(pathToDelete, -1);
                clearNodes(megaPathToDelete);

            } catch (KeeperException | InterruptedException e){}
        } else {
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
