package org.framework.rodolfo.freire.git.encryption.asymmetric.repository;

import org.framework.rodolfo.freire.git.encryption.asymmetric.document.Message;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends MongoRepository<Message, Long> {
}
