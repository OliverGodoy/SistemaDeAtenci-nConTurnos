package example.persistence.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import example.persistence.service.MessageService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/messages")
@RequiredArgsConstructor
public class MessageController {

    private final MessageService messageService;

    @PostMapping
    public String enviarMensaje(@RequestBody String mensaje) {
        messageService.enviarMensaje(mensaje);
        return "Mensaje enviado: " + mensaje;
    }
}