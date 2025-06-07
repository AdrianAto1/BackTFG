package BodasAto;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import jakarta.annotation.PostConstruct;



@SpringBootApplication
public class BodasAtoApplication {

    @Value("${server.port}")
    private String port;

    public static void main(String[] args) {
        SpringApplication.run(BodasAtoApplication.class, args);
        System.out.println("App iniciada y main thread terminado");
    }

    @PostConstruct
    public void init() {
        System.out.println("### La aplicación se está ejecutando en el puerto: " + port);
    }
    @EventListener(ApplicationReadyEvent.class)
    public void onReady() {
        System.out.println("App lista para recibir solicitudes");
    }
}
