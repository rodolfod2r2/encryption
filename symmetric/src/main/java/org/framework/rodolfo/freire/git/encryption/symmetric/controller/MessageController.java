package org.framework.rodolfo.freire.git.encryption.symmetric.controller;

import org.framework.rodolfo.freire.git.encryption.symmetric.document.Message;
import org.framework.rodolfo.freire.git.encryption.symmetric.service.MessageService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/message")
public class MessageController {

    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }


    @GetMapping
    public List<Message> findAll() {
        return messageService.findAll();
    }

    @PostMapping
    public Message save(@RequestBody Message message) {
        return messageService.save(message);
    }

    @PutMapping
    public Message update(@RequestBody Message message) {
        return messageService.save(message);
    }
}
