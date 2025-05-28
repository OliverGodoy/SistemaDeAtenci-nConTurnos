package example.persistence.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public Queue turnoQueue() {
        return new Queue("turno-queue", true);
    }

    @Bean
    public Queue clienteQueue() {
        return new Queue("cliente-queue", true);
    }

    @Bean
    public Queue servicioQueue() {
        return new Queue("servicio-queue", true);
    }
}