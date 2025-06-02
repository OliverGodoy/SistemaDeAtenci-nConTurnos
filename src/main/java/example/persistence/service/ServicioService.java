package example.persistence.service;

import example.persistence.Dto.ServicioDto;
import example.persistence.entity.Servicio;
import example.persistence.repository.ServicioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServicioService {

    private final ServicioRepository servicioRepository;
    private final MessageService messageService;

    public Servicio crearServicio(ServicioDto servicioDto) {
        Servicio servicio = new Servicio();
        servicio.setNombre(servicioDto.getNombre());
        servicio.setDescripcion(servicioDto.getDescripcion());
        servicio.setPrecio(servicioDto.getPrecio());
        
        Servicio servicioGuardado = servicioRepository.save(servicio);
        messageService.enviarServicio(servicioDto);
        
        return servicioGuardado;
    }


    public Servicio obtenerServicioPorId(Long id) {
        return servicioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Servicio no encontrado con ID: " + id));
    }

    public void eliminarServicio(Long id) {
        Servicio servicio = servicioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Servicio no encontrado con ID: " + id));

        servicioRepository.delete(servicio);
        messageService.enviarMensaje("Servicio eliminado: " + servicio.getNombre());
    }

}