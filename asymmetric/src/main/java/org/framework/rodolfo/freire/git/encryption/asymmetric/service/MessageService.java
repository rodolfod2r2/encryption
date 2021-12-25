package org.framework.rodolfo.freire.git.encryption.asymmetric.service;

import lombok.extern.slf4j.Slf4j;
import org.framework.rodolfo.freire.git.encryption.asymmetric.document.Message;
import org.framework.rodolfo.freire.git.encryption.asymmetric.repository.MessageRepository;
import org.framework.rodolfo.freire.git.encryption.core.component.EncryptComponent;
import org.framework.rodolfo.freire.git.encryption.core.factory.EnumFactory;
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
            encryptComponent.decryptObject(p, EnumFactory.ASYMMETRIC);
            messageList.add(p);
        }
        return messageList;
    }

    public Message findById(Long id) {
        Message message = repository.findById(id).orElse(null);
        if (message != null)
            encryptComponent.decryptObject(message, EnumFactory.ASYMMETRIC);
        return message;
    }

    public Message save(Message message) {
        encryptComponent.encryptObject(message, EnumFactory.ASYMMETRIC);
        return repository.save(message);
    }

    public void delete(Long id) {
        repository.findById(id).ifPresent(repository::delete);
    }

}
