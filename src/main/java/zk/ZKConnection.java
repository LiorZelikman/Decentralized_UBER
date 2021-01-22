package zk;

import entities.Ride;
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
    public final
    String serverID;


    public ZKConnection(Integer port, ConcurrentHashMap<Integer, Ride> rides) throws IOException,
            InterruptedException, KeeperException {
        watcher = new ZookeeperWatcher();
        zkClient = new ZooKeeper("127.0.0.1:" + (port-1000), 60000, watcher);
        watcher.setFields(zkClient, port, rides);
        this.port = port;
        serverID = "" + port%10;

        createNode("/add_operation", "");
        createNode("/assign_operation", "");

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

    public void assign(Integer rideID){
        try{
            long timestamp = System.currentTimeMillis();
            createNode("/added_" + timestamp, rideID.toString());
            for(int i = 0; i < RidesService.servers_per_city; i++){
                createNode("/added_" + timestamp + "/" + (i + 1), rideID.toString());
            }
            zkClient.setData("/add_operation", String.valueOf(timestamp).getBytes(), -1);
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
}
