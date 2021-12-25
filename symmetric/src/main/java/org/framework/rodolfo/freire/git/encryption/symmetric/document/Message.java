package org.framework.rodolfo.freire.git.encryption.symmetric.document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.framework.rodolfo.freire.git.encryption.core.annotation.EncryptField;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import static org.framework.rodolfo.freire.git.encryption.core.annotation.EnumEncrypt.TRUE;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Message {

    @Id
    private Long id;
    @EncryptField(encryptField = TRUE, decryptField = TRUE)
    private String messageField;

}
