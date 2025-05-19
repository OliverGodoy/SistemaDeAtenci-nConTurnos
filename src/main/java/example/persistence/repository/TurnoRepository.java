package example.persistence.repository;

import example.persistence.entity.Turno;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface TurnoRepository extends JpaRepository<Turno, Long> {
    List<Turno> findByFechaHoraBetween(LocalDateTime inicio, LocalDateTime fin);
    List<Turno> findByClienteId(Long clienteId);
    List<Turno> findByServicioId(Long servicioId);
}
