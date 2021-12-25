package org.framework.rodolfo.freire.git.encryption.symmetric.service;

import lombok.extern.slf4j.Slf4j;
import org.framework.rodolfo.freire.git.encryption.core.component.EncryptComponent;
import org.framework.rodolfo.freire.git.encryption.core.factory.EnumFactory;
import org.framework.rodolfo.freire.git.encryption.symmetric.document.Message;
import org.framework.rodolfo.freire.git.encryption.symmetric.repository.MessageRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class MessageService {

    private final MessageRepository repository;

    private final EncryptComponent encryptComponent;

    public MessageService(MessageRepository repository, EncryptComponent encryptComponent) {
        this.repository = repository;
        this.encryptComponent = encryptComponent;
    }

    public List<Message> findAll() {
        List<Message> messageList = new ArrayList<>();
        for (Message p : repository.findAll()) {
            encryptComponent.decryptObject(p, EnumFactory.SYMMETRIC);
            messageList.add(p);
        }
        return messageList;
    }

    public Message findById(Long id) {
        Message message = repository.findById(id).orElse(null);
        if (message != null)
            encryptComponent.decryptObject(message, EnumFactory.SYMMETRIC);
        return message;
    }

    public Message save(Message message) {
        encryptComponent.encryptObject(message, EnumFactory.SYMMETRIC);
        return repository.save(message);
    }

    public void delete(Long id) {
        repository.findById(id).ifPresent(repository::delete);
    }


}
