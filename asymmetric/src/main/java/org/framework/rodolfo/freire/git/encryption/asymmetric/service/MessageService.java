package org.framework.rodolfo.freire.git.encryption.asymmetric.service;

import lombok.extern.slf4j.Slf4j;
import org.framework.rodolfo.freire.git.encryption.asymmetric.document.Message;
import org.framework.rodolfo.freire.git.encryption.asymmetric.repository.MessageRepository;
import org.framework.rodolfo.freire.git.encryption.core.component.EncryptComponent;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static org.framework.rodolfo.freire.git.encryption.core.factory.EnumFactory.ASYMMETRIC;

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
            encryptComponent.decryptObject(p, ASYMMETRIC);
            messageList.add(p);
        }
        return messageList;
    }

    public Message findById(Long id) {
        Message message = repository.findById(id).orElse(null);
        if (message != null)
            encryptComponent.decryptObject(message, ASYMMETRIC);
        return message;
    }

    public Message save(Message message) {
        encryptComponent.encryptObject(message, ASYMMETRIC);
        return repository.save(message);
    }

    public void delete(Long id) {
        repository.findById(id).ifPresent(repository::delete);
    }

}
