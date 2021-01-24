package host;

import org.apache.zookeeper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import services.RidesService;

import java.awt.geom.Point2D;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class Server implements Runnable {

    public static ArrayList<Process> zkServers;

    static{
        zkServers = new ArrayList<>();
        for (int i=0; i < RidesService.number_of_cities; i++) {
            for(int j=1; j <= RidesService.servers_per_city; j++){
                ProcessBuilder pb = new ProcessBuilder("ZookeeperServers\\ZookeeperServer_" + (i*RidesService.servers_per_city + j) + "\\bin\\zkServer.cmd");
                try {
                    Process pr = pb.start();
                    zkServers.add(pr);
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println("zkServer failed to start");
                    System.exit(-1);
                }
            }
        }
    }


    public Server(){}

    public Server(int port) throws java.io.IOException{
        String[] args = new String[0];
        SpringApplication app = new SpringApplication(Server.class);
        app.setDefaultProperties(Collections
                .singletonMap("server.port", String.valueOf(port)));
        app.run(args);

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
}
