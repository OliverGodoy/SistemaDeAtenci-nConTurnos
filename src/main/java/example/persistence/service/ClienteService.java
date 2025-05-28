package example.persistence.service;

import example.persistence.dto.ClienteDto;
import example.persistence.entity.Cliente;
import example.persistence.repository.ClienteRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository clienteRepository;
    private final MessageService messageService;

    public Cliente crearCliente(ClienteDto clienteDto) {
        Cliente cliente = new Cliente();
        cliente.setNombre(clienteDto.getNombre());
        cliente.setDni(clienteDto.getDni());
        cliente.setTelefono(clienteDto.getTelefono());
        cliente.setEmail(clienteDto.getEmail());
        
        Cliente clienteGuardado = clienteRepository.save(cliente);
        messageService.enviarCliente(clienteDto);
        
        return clienteGuardado;
    }

    public List<Cliente> obtenerTodosClientes() {
        return clienteRepository.findAll();
    }
}