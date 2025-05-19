package example.persistence.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TurnoDto {
    private Long id;
    private Long clienteId;
    private Long servicioId;
    private LocalDateTime fechaHora;
    private String estado;
    private String observaciones;
}
