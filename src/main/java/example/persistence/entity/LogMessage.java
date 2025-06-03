package example.persistence.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Data
@Document(collection = "logs")
public class LogMessage {
    @Id
    private String id;
    private String mensaje;
    private String tipo;
    private LocalDateTime fecha;
    private Object datos;
    
    public LogMessage(String mensaje, String tipo, Object datos) {
        this.mensaje = mensaje;
        this.tipo = tipo;
        this.datos = datos;
        this.fecha = LocalDateTime.now();
    }
}