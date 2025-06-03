package example.persistence.service;

import example.persistence.Dto.ClienteDto;
import example.persistence.Dto.ServicioDto;
import example.persistence.Dto.TurnoDto;
import example.persistence.entity.LogMessage;
import example.persistence.repository.LogRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ConsumidorMensajes {
    
    @Autowired
    private LogRepository logRepository;
    
    @RabbitListener(queues = "test-queue")
    public void recibirMensaje(String mensaje) {
        log.info("Mensaje recibido: {}", mensaje);
        logRepository.save(new LogMessage(mensaje, "MENSAJE", mensaje));
    }

    @RabbitListener(queues = "turno-queue")
    public void recibirTurno(TurnoDto turnoDto) {
        log.info("Turno recibido: {}", turnoDto);
        logRepository.save(new LogMessage("Turno recibido", "TURNO", turnoDto));
    }

    @RabbitListener(queues = "cliente-queue")
    public void recibirCliente(ClienteDto clienteDto) {
        log.info("Cliente recibido: {}", clienteDto);
        logRepository.save(new LogMessage("Cliente recibido", "CLIENTE", clienteDto));
    }

    @RabbitListener(queues = "servicio-queue")
    public void recibirServicio(ServicioDto servicioDto) {
        log.info("Servicio recibido: {}", servicioDto);
        logRepository.save(new LogMessage("Servicio recibido", "SERVICIO", servicioDto));
    }
}