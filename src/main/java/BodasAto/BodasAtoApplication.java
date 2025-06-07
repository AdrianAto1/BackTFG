package BodasAto;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import jakarta.annotation.PostConstruct;



@SpringBootApplication
public class BodasAtoApplication {

    @Value("${server.port}")
    private String port;

    public static void main(String[] args) {
        SpringApplication.run(BodasAtoApplication.class, args);
    }

    @PostConstruct
    public void init() {
        System.out.println("### La aplicación se está ejecutando en el puerto: " + port);
    }
}
