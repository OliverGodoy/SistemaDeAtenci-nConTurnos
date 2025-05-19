package example.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "historiales")
@Data
public class Historial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    private LocalDateTime fecha;

    @Column(columnDefinition = "TEXT")
    private String descripcion;

    private String tipo; // "CONSULTA", "SERVICIO", "OBSERVACION"
}
