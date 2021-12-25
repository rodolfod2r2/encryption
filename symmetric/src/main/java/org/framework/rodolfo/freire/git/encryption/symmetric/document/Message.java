package org.framework.rodolfo.freire.git.encryption.symmetric.document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.framework.rodolfo.freire.git.encryption.core.annotation.EncryptField;
import org.framework.rodolfo.freire.git.encryption.core.annotation.EnumEncrypt;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Message {

    @Id
    private Long id;
    @EncryptField(encryptField = EnumEncrypt.TRUE, decryptField = EnumEncrypt.TRUE)
    private String messageField;

}
