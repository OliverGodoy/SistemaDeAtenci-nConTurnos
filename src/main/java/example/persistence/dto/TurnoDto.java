package example.persistence.dto;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class TurnoDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private Long clienteId;
    private Long servicioId;
    private LocalDateTime fechaHora;
    private String estado;
    private String observaciones;
    private String nombre;
}
