package host;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        host.Server haifa1 = new Server(10001);
        host.Server haifa2 = new Server(10002);
        host.Server haifa3 = new Server(10003);
        host.Server saratov1 = new Server(20001);
        host.Server saratov2 = new Server(20002);
        host.Server saratov3 = new Server(20003);
        host.Server afula1 = new Server(30001);
        host.Server afula2 = new Server(30002);
        host.Server afula3 = new Server(30003);


        System.out.println("Bye");
    }
}
