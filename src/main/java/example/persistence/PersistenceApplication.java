package example.persistence;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.context.ConfigurableApplicationContext;
import example.persistence.service.MessageService;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "example.persistence.repository")
@EntityScan(basePackages = "example.persistence.entity")
public class PersistenceApplication {


    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(PersistenceApplication.class, args);

        System.out.println("====================================");
        System.out.println("  Consumidor RabbitMQ INICIADO ✅  ");
        System.out.println("  Esperando mensajes en colas...   ");
        System.out.println("====================================");

        // Probamos el envío de mensajes
        MessageService messageService = context.getBean(MessageService.class);
        messageService.enviarMensaje("¡Hola RabbitMQ!");
    }
}