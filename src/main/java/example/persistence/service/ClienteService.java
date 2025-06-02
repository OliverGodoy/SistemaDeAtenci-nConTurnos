package example.persistence.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import example.persistence.Dto.ClienteDto;
import example.persistence.repository.ClienteRepository;
import example.persistence.entity.Cliente;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository clienteRepository;
    private final MessageService messageService;

    public ClienteDto crearCliente(ClienteDto clienteDto) {
        Cliente cliente = new Cliente();
        cliente.setNombre(clienteDto.getNombre());
        cliente.setDni(clienteDto.getDni());
        cliente.setTelefono(clienteDto.getTelefono());
        cliente.setEmail(clienteDto.getEmail());

        // Guardar el cliente en la base de datos
        Cliente clienteGuardado = clienteRepository.save(cliente);

        // Enviar un mensaje de confirmación
        messageService.enviarMensaje("Cliente creado: " + clienteGuardado.getNombre());

        return convertirADto(clienteGuardado);
    }



    public List<ClienteDto> obtenerTodosClientes() {
        return clienteRepository.findAll().stream()
                .map(this::convertirADto)
                .collect(Collectors.toList());
    }

    private ClienteDto convertirADto(Cliente cliente) {
        ClienteDto dto = new ClienteDto();
        dto.setId(cliente.getId());
        dto.setNombre(cliente.getNombre());
        dto.setDni(cliente.getDni());
        dto.setTelefono(cliente.getTelefono());
        dto.setEmail(cliente.getEmail());
        return dto;
    }


}