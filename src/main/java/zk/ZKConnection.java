package zk;

import entities.Ride;
import entities.RideOfferEntity;
import generated.RideRequest;
import org.apache.zookeeper.AddWatchMode;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.ACL;
import org.apache.zookeeper.data.Stat;
import services.RidesService;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;

public class ZKConnection {
    private ZooKeeper zkClient;
    private ZookeeperWatcher watcher;
    private Integer port;
    public final String serverID;
    private ConcurrentHashMap<Integer, Ride> rides;
    private ConcurrentHashMap<Integer, RideOfferEntity> rideOffers;


    public ZKConnection(Integer port, ConcurrentHashMap<Integer, Ride> rides, ConcurrentHashMap<Integer, RideOfferEntity> rideOffers) throws IOException,
            InterruptedException, KeeperException {
        watcher = new ZookeeperWatcher();
        zkClient = new ZooKeeper("127.0.0.1:" + (port-1000), 60000, watcher);
        watcher.setFields(zkClient, port, rides, rideOffers);
        this.port = port;
        serverID = "" + port%10;
        this.rideOffers = rideOffers;
        this.rides = rides;

        createNode("/add_operation", "");
        createNode("/assign_operation", "");
        createNode("/ID", "1");
        try {
            zkClient.addWatch("/add_operation", watcher, AddWatchMode.PERSISTENT);
            zkClient.addWatch("/assign_operation", watcher, AddWatchMode.PERSISTENT);
        } catch (KeeperException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void close() throws InterruptedException {
        zkClient.close();
    }

    public void addRide(Ride ride){
        try{
            long timestamp = System.currentTimeMillis();
            createNode("/added_" + timestamp, ride.toCustomString());
            for(int i = 0; i < RidesService.servers_per_city; i++){
                createNode("/added_" + timestamp + "/" + (i + 1), ride.toCustomString());
            }
            //Add lock with timeout here
            zkClient.setData("/add_operation", String.valueOf(timestamp).getBytes(), -1);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void assign(Integer rideID, RideRequest rideRequest){
        try{
            RideOfferEntity offerEntity = new RideOfferEntity(rideRequest);
            long timestamp = System.currentTimeMillis();
            createNode("/assigned_" + timestamp, rideID + ";" + offerEntity.toCustomString());
            for(int i = 0; i < RidesService.servers_per_city; i++){
                createNode("/assigned_" + timestamp + "/" + (i + 1), rideID + ";" + offerEntity.getRequestId() + offerEntity.toCustomString());
            }
            zkClient.setData("/assign_operation", String.valueOf(timestamp).getBytes(), -1);
            while(rideOffers.get(offerEntity.getRequestId()) == null){
                System.out.println(port + ": waiting");
                Thread.sleep(1000);
            }
            System.out.println(port + ": done waiting");
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    private void createNode(String path, String data) throws KeeperException, InterruptedException {
        List<ACL> acls = zkClient.getACL("/", new Stat());
        try {
            zkClient.create(path, data.getBytes(StandardCharsets.UTF_8), acls, CreateMode.CONTAINER);
        } catch (KeeperException | InterruptedException e){}
    }

    public int supplyID() throws KeeperException, InterruptedException {
        while(true) {
            Stat stat = new Stat();
            int ID = Integer.parseInt(new String(zkClient.getData("/ID", false, stat), StandardCharsets.UTF_8));
            int version = stat.getVersion();
            try {
                zkClient.setData("/ID", String.valueOf(ID + 1).getBytes(), version);
                return ID;
            } catch (KeeperException | InterruptedException e) {
            }
        }
    }
}
