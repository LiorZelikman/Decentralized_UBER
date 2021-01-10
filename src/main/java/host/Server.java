package host;

import org.apache.zookeeper.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import java.awt.geom.Point2D;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class Server /*implements Watcher, Runnable*/ {
    int myid;
    static ZooKeeper zk;
    Point2D location;

    public static void main(String[] args) throws java.io.IOException, InterruptedException, KeeperException {
        SpringApplication.run(Server.class, args);
        //host.Server haifa = new host.Server(2181, 3, 5);
        //host.Server saratov = new host.Server(2182, 6, 2);
        //host.Server afula = new host.Server(2183, 1, 10);
        //Thread haifa_thread = new Thread(haifa);
        //Thread saratov_thread = new Thread(saratov);
        //Thread afula_thread = new Thread(afula);
        //haifa_thread.start();
        //saratov_thread.start();
        //afula_thread.start();

        //System.out.println("Bye");
    }
/*
    public Server(int port, double x, double y) throws java.io.IOException{
        zk = new ZooKeeper("127.0.0.1:" + port, 3000, this);
        location = new Point2D.Double(x, y);
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
*/

}
