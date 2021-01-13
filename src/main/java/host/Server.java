package host;

import org.apache.zookeeper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.awt.geom.Point2D;
import java.util.Collections;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class Server implements Watcher, Runnable {
    int myid;
    static ZooKeeper zk;
    Point2D location;

    public Server(){}

    public Server(int port) throws java.io.IOException{
        String[] args = new String[0];
        SpringApplication app = new SpringApplication(Server.class);
        app.setDefaultProperties(Collections
                .singletonMap("server.port", String.valueOf(port)));
        app.run(args);
        //zk = new ZooKeeper("127.0.0.1:" + (port-1000), 3000, this);

    }


    @Override
    public void run() {
        while(true) {
            System.out.println("Staying alive");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void process(WatchedEvent event) {
        System.out.println("In process");
        try {
            zk.addWatch("/testik_100", this, AddWatchMode.PERSISTENT);
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
