package example.persistence.dto;

import lombok.Data;

@Data
public class ServicioDto {
    private Long id;
    private String nombre;
    private String descripcion;
    private Double precio;
}
