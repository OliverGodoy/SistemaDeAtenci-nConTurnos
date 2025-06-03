package example.persistence;

import example.persistence.entity.LogMessage;
import example.persistence.repository.LogRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
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

        // Obtener los beans necesarios del contexto
        MessageService messageService = context.getBean(MessageService.class);
        LogRepository logRepository = context.getBean(LogRepository.class);

        // Enviar mensaje y guardar log
        messageService.enviarMensaje("¡Conexión exitosa!");
        logRepository.save(new LogMessage("¡Conexión exitosa!", "INICIO", "El consumidor RabbitMQ ha iniciado correctamente."));
    }
}