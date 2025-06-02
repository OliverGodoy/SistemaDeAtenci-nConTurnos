package example.persistence;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.context.ConfigurableApplicationContext;
import example.persistence.service.MessageService;



@SpringBootApplication
@Slf4j
public class PersistenceApplication {
    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(PersistenceApplication.class, args);

        log.info("====================================");
        log.info("  Consumidor RabbitMQ INICIADO ✅  ");
        log.info("  Esperando mensajes en colas...   ");
        log.info("====================================");

        MessageService messageService = context.getBean(MessageService.class);
        messageService.enviarMensaje("¡Conexion exitosa!");
    }
}