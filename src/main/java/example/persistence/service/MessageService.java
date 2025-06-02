package example.persistence.service;

import example.persistence.Dto.ClienteDto;
import example.persistence.Dto.ServicioDto;
import example.persistence.Dto.TurnoDto;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class MessageService {
    
    private final RabbitTemplate rabbitTemplate;
    
    public void enviarMensaje(String mensaje) {
        try {
            rabbitTemplate.convertAndSend("test-queue", mensaje);
            log.info("Mensaje enviado exitosamente: {}", mensaje);
        } catch (Exception e) {
            log.error("Error al enviar mensaje: {}", e.getMessage());
        }
    }

    public void enviarTurno(TurnoDto turno) {
        try {
            rabbitTemplate.convertAndSend("turno-queue", turno);
            log.info("Turno enviado exitosamente: {}", turno);
        } catch (Exception e) {
            log.error("Error al enviar turno: {}", e.getMessage());
        }
    }

    public void enviarCliente(ClienteDto cliente) {
        try {
            rabbitTemplate.convertAndSend("cliente-queue", cliente);
            log.info("Cliente enviado exitosamente: {}", cliente);
        } catch (Exception e) {
            log.error("Error al enviar cliente: {}", e.getMessage());
        }
    }

    public void enviarServicio(ServicioDto servicio) {
        try {
            rabbitTemplate.convertAndSend("servicio-queue", servicio);
            log.info("Servicio enviado exitosamente: {}", servicio);
        } catch (Exception e) {
            log.error("Error al enviar servicio: {}", e.getMessage());
        }
    }
}