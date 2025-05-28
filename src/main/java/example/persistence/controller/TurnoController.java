package example.persistence.controller;

import example.persistence.dto.TurnoDto;
import example.persistence.entity.Turno;
import example.persistence.service.TurnoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/turnos")
@RequiredArgsConstructor
public class TurnoController {

    private final TurnoService turnoService;

    @PostMapping
    public ResponseEntity<Turno> crearTurno(@RequestBody TurnoDto turnoDto) {
        return ResponseEntity.ok(turnoService.crearTurno(turnoDto));
    }

    @GetMapping
    public ResponseEntity<List<Turno>> obtenerTodosTurnos() {
        return ResponseEntity.ok(turnoService.obtenerTodosTurnos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Turno> obtenerTurnoPorId(@PathVariable Long id) {
        return ResponseEntity.ok(turnoService.obtenerTurnoPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarTurno(@PathVariable Long id) {
        turnoService.eliminarTurno(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Turno> actualizarTurno(@PathVariable Long id, @RequestBody TurnoDto turnoDto) {
        return ResponseEntity.ok(turnoService.actualizarTurno(id, turnoDto));
    }
}