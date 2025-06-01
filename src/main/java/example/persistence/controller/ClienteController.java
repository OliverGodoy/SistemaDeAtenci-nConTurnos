package example.persistence.controller;

import example.persistence.dto.ClienteDto;
import example.persistence.entity.Cliente;
import example.persistence.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService clienteService;

    @PostMapping
    public ResponseEntity<ClienteDto> crearCliente(@RequestBody ClienteDto clienteDto) {
        return ResponseEntity.ok(clienteService.crearCliente(clienteDto));
    }

    @GetMapping
    public ResponseEntity<List<ClienteDto>> obtenerTodosClientes() {
        return ResponseEntity.ok(clienteService.obtenerTodosClientes());
    }
}