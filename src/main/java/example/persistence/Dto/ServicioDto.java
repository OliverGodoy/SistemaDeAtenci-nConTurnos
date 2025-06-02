package example.persistence.Dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class ServicioDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String nombre;
    private String descripcion;
    private Double precio;
}
