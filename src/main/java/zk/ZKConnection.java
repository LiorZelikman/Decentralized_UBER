package zk;

import entities.Ride;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;

public class ZKConnection {
    private ZooKeeper zkClient;
    private ZookeeperWatcher watcher;


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
}
