package example.persistence.service;

import example.persistence.dto.TurnoDto;
import example.persistence.entity.Cliente;
import example.persistence.entity.Servicio;
import example.persistence.entity.Turno;
import example.persistence.repository.ClienteRepository;
import example.persistence.repository.ServicioRepository;
import example.persistence.repository.TurnoRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TurnoService {

    private final TurnoRepository turnoRepository;
    private final ClienteRepository clienteRepository;
    private final ServicioRepository servicioRepository;
    private final MessageService messageService;

    public Turno crearTurno(TurnoDto turnoDto) {
        Cliente cliente = clienteRepository.findById(turnoDto.getClienteId())
                .orElseThrow(() -> new EntityNotFoundException("Cliente no encontrado"));
        
        Servicio servicio = servicioRepository.findById(turnoDto.getServicioId())
                .orElseThrow(() -> new EntityNotFoundException("Servicio no encontrado"));

        Turno turno = new Turno();
        turno.setCliente(cliente);
        turno.setServicio(servicio);
        turno.setFechaHora(turnoDto.getFechaHora());
        turno.setEstado(turnoDto.getEstado());
        turno.setObservaciones(turnoDto.getObservaciones());

        Turno turnoGuardado = turnoRepository.save(turno);

        messageService.enviarTurno(turnoDto);

        return turnoGuardado;
    }

    public List<Turno> obtenerTodosTurnos() {
        return turnoRepository.findAll();
    }

    public Turno obtenerTurnoPorId(Long id) {
        return turnoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Turno no encontrado"));
    }

    public void eliminarTurno(Long id) {
        if (!turnoRepository.existsById(id)) {
            throw new EntityNotFoundException("Turno no encontrado");
        }
        turnoRepository.deleteById(id);
    }

    public Turno actualizarTurno(Long id, TurnoDto turnoDto) {
        Turno turnoExistente = turnoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Turno no encontrado"));

        Cliente cliente = clienteRepository.findById(turnoDto.getClienteId())
                .orElseThrow(() -> new EntityNotFoundException("Cliente no encontrado"));
        
        Servicio servicio = servicioRepository.findById(turnoDto.getServicioId())
                .orElseThrow(() -> new EntityNotFoundException("Servicio no encontrado"));

        turnoExistente.setCliente(cliente);
        turnoExistente.setServicio(servicio);
        turnoExistente.setFechaHora(turnoDto.getFechaHora());
        turnoExistente.setEstado(turnoDto.getEstado());
        turnoExistente.setObservaciones(turnoDto.getObservaciones());

        return turnoRepository.save(turnoExistente);
    }
}