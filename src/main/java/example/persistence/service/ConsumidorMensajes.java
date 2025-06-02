package example.persistence.service;

import example.persistence.Dto.ClienteDto;
import example.persistence.Dto.ServicioDto;
import example.persistence.Dto.TurnoDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ConsumidorMensajes {
    
    @RabbitListener(queues = "test-queue")
    public void recibirMensaje(String mensaje) {
        log.info("Mensaje recibido: {}", mensaje);
    }

    @RabbitListener(queues = "turno-queue")
    public void recibirTurno(TurnoDto turnoDto) {
        log.info("Turno recibido: {}", turnoDto);
    }

    @RabbitListener(queues = "cliente-queue")
    public void recibirCliente(ClienteDto clienteDto) {
        log.info("Cliente recibido: {}", clienteDto);
    }

    @RabbitListener(queues = "servicio-queue")
    public void recibirServicio(ServicioDto servicioDto) {
        log.info("Servicio recibido: {}", servicioDto);
    }
}