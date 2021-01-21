package zk;

import entities.Ride;
import org.apache.zookeeper.*;

import java.awt.geom.Point2D;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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

    @Override
    public void process(WatchedEvent event) {
        String path = event.getPath();
        String cityID = "" + port/10000;
        String serverID = "" + port%10;
        if(path.equals("/" + cityID + "/add_operation")){
            try {
                String data = getZNodeData(path);
                String[] fields = data.split(";");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/d");
                Ride newRide = new Ride(Integer.getInteger(fields[0]), fields[1], fields[2], fields[3],
                        new Point2D.Double(Double.valueOf(fields[4]), Double.valueOf(fields[5])),
                        new Point2D.Double(Double.valueOf(fields[6]), Double.valueOf(fields[7])),
                        (LocalDate) formatter.parse(fields[8]), Integer.getInteger(fields[9]), Double.valueOf(fields[10]));
                String triggeringServerID = fields[11];
                rides.put(newRide.getRide_id(), newRide);
                String megaPathToDelete = "/" + cityID +"/added_" + triggeringServerID;
                String pathToDelete = megaPathToDelete + "/" + serverID;
                zkClient.delete(pathToDelete, -1);
                long start = System.currentTimeMillis();
                long end = start + 5*1000;
                while (System.currentTimeMillis() < end) {
                    try {
                        //checking if the path (i.e. all of its children) was deleted
                        if (zkClient.getAllChildrenNumber(megaPathToDelete) == 0) {
                            break;
                        }
                    } catch (KeeperException | InterruptedException e) { }
                }

                //trying to delete the path (and all its children in any case
                //3 is the number of servers per city
                for (int i = 0; i < 3; i++) {
                    try {
                        zkClient.delete(megaPathToDelete + "/" + i, -1);
                    } catch(KeeperException | InterruptedException e) {}
                }
                try {
                    zkClient.delete(megaPathToDelete, -1);
                } catch(KeeperException | InterruptedException e) {}

            }
            catch (KeeperException | InterruptedException e) {
                e.printStackTrace();
            }




        } else { //path.equals("/" + cityID + "/assign_operation")

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
