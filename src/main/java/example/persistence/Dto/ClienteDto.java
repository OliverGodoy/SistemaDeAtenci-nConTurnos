package example.persistence.Dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class ClienteDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String nombre;
    private String dni;
    private String telefono;
    private String email;

}
