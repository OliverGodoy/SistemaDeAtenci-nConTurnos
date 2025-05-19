package example.persistence.repository;

import example.persistence.entity.Historial;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HistorialRepository extends JpaRepository<Historial, Long> {
    List<Historial> findByClienteId(Long clienteId);
    List<Historial> findByTipo(String tipo);
}
