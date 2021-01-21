package zk;

import entities.Ride;
import org.apache.zookeeper.AddWatchMode;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.ACL;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;

public class ZKConnection {
    private ZooKeeper zkClient;
    private ZookeeperWatcher watcher;


    //starting the zookeeper client that corresponds to this port
//        zkClient = new ZooKeeper("127.0.0.1:" + (port-1000), 3000, zkWatcher);
//        try {
//            zkClient.addWatch("/add_operation_" + port/10000, zkWatcher, AddWatchMode.PERSISTENT);
//            zkClient.addWatch("/assign_operation_" + port/10000, zkWatcher, AddWatchMode.PERSISTENT);
//        } catch (KeeperException | InterruptedException e) {
//            e.printStackTrace();
//        }

    public ZKConnection(Integer port, ConcurrentHashMap<Integer, Ride> rides) throws IOException,
            InterruptedException, KeeperException {
        watcher = new ZookeeperWatcher();
        zkClient = new ZooKeeper("127.0.0.1:" + (port-1000), 3000, watcher);
        watcher.setFields(zkClient, port, rides);

        createNode("/add_operation", "");
        createNode("/assign_operation", "");

        try {
            zkClient.addWatch("/add_operation", watcher, AddWatchMode.PERSISTENT);
            zkClient.addWatch("/assign_operation", watcher, AddWatchMode.PERSISTENT);
        } catch (KeeperException | InterruptedException e) {
            e.printStackTrace();
        }
    }



    public ZooKeeper connect(Integer port, ConcurrentHashMap<Integer, Ride> rides) throws IOException,
            InterruptedException {
        watcher = new ZookeeperWatcher();
        zkClient = new ZooKeeper("127.0.0.1:" + (port-1000), 3000, watcher);
        watcher.setFields(zkClient, port, rides);
        return zkClient;
    }

    public void close() throws InterruptedException {
        zkClient.close();
    }

    public void addRide(Ride ride){
        try{
            createNode("/add_operation/added_1", ride.toString());
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    private void createNode(String path, String data) throws KeeperException, InterruptedException {
        List<ACL> acls = zkClient.getACL(path, new Stat());
        zkClient.create(path, data.getBytes(StandardCharsets.UTF_8), acls, CreateMode.CONTAINER);
    }
}
