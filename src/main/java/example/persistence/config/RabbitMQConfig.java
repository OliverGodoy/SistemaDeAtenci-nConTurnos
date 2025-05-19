package example.persistence.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String CREATE_QUEUE = "create.record.queue";
    public static final String DELETE_QUEUE = "delete.record.queue";

    @Bean
    public Queue createRecordQueue() {
        return new Queue(CREATE_QUEUE, true); // durable=true
    }

    @Bean
    public Queue deleteRecordQueue() {
        return new Queue(DELETE_QUEUE, true); // durable=true
    }
}

