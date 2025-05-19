package example.persistence.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class HistorialDto {
    private Long id;
    private Long clienteId;
    private LocalDateTime fecha;
    private String descripcion;
    private String tipo;
}
