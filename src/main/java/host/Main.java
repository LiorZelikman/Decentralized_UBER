package host;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        host.Server haifa1 = new Server(10001);
        host.Server haifa2 = new Server(10002);
        host.Server saratov1 = new Server(20001);
        host.Server saratov2 = new Server(20002);
        host.Server afula1 = new Server(30001);
        host.Server afula2 = new Server(30002);
        Thread haifa_thread = new Thread("haifa");
        Thread saratov_thread = new Thread("saratov");
        Thread afula_thread = new Thread("afula");
        haifa_thread.start();
        saratov_thread.start();
        afula_thread.start();

        System.out.println("Bye");
    }
}