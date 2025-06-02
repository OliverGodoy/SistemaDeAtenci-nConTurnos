package example.persistence.service;

import example.persistence.Dto.TurnoDto;
import example.persistence.entity.Cliente;
import example.persistence.entity.Servicio;
import example.persistence.entity.Turno;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import example.persistence.repository.ClienteRepository;
import example.persistence.repository.ServicioRepository;
import example.persistence.repository.TurnoRepository;

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
        turno.setNombre(turnoDto.getNombre());

        Turno turnoGuardado = turnoRepository.save(turno);

        messageService.enviarTurno(turnoDto);

        return turnoGuardado;
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



}