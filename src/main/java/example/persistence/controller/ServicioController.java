package example.persistence.controller;

import example.persistence.Dto.ServicioDto;
import example.persistence.entity.Servicio;
import example.persistence.service.ServicioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/servicios")
@RequiredArgsConstructor
public class ServicioController {

    private final ServicioService servicioService;

    @PostMapping
    public ResponseEntity<Servicio> crearServicio(@RequestBody ServicioDto servicioDto) {
        return ResponseEntity.ok(servicioService.crearServicio(servicioDto));
    }

    @GetMapping
    public ResponseEntity<List<Servicio>> obtenerTodosServicios() {
        return ResponseEntity.ok(servicioService.obtenerTodosServicios());
    }
}