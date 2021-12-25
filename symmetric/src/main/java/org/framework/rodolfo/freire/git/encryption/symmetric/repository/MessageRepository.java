package org.framework.rodolfo.freire.git.encryption.symmetric.repository;

import org.framework.rodolfo.freire.git.encryption.symmetric.document.Message;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends MongoRepository<Message, Long> {
}
