package example.persistence; // Ajusta el paquete según tu estructura

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "example.persistence.repository") // Ajusta la ruta
@EntityScan(basePackages = "example.persistence.entity") // Ajusta la ruta
public class PersistenceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PersistenceApplication.class, args);

        System.out.println("====================================");
        System.out.println("  Consumidor RabbitMQ INICIADO ✅  ");
        System.out.println("  Esperando mensajes en colas...   ");
        System.out.println("====================================");
    }

}
