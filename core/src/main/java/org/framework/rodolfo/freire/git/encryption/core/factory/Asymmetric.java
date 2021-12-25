package org.framework.rodolfo.freire.git.encryption.core.factory;

import lombok.extern.slf4j.Slf4j;
import org.framework.rodolfo.freire.git.encryption.core.config.CoreConfigurationProperties;
import org.springframework.stereotype.Service;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.*;
import java.util.Base64;

@Slf4j
@Service
public class Asymmetric implements Encrypt {

    private final CoreConfigurationProperties coreConfigurationProperties;

    private PrivateKey privateKey;
    private PublicKey publicKey;

    public Asymmetric(CoreConfigurationProperties coreConfigurationProperties) {
        this.coreConfigurationProperties = coreConfigurationProperties;
        try {
            KeyPairGenerator generator = KeyPairGenerator.getInstance(coreConfigurationProperties.getAsymmetricSecurityKeyPairGeneratorType());
            generator.initialize(1024);
            KeyPair pair = generator.generateKeyPair();
            privateKey = pair.getPrivate();
            publicKey = pair.getPublic();
        } catch (NoSuchAlgorithmException ex) {
            log.error("");
        }

    }

    @Override
    public String encrypted(String text) {
        try {
            Cipher encrypted = Cipher.getInstance(coreConfigurationProperties.getAsymmetricSecurityCipherType());
            encrypted.init(Cipher.ENCRYPT_MODE, publicKey);
            return Base64.getEncoder().withoutPadding().encodeToString(encrypted.doFinal(text.getBytes()));
        } catch (NoSuchAlgorithmException | IllegalBlockSizeException | BadPaddingException | NoSuchPaddingException | InvalidKeyException ex) {
            log.error(ex.getMessage());
        }
        return null;
    }


    @Override
    public String decrypted(String text) {
        try {
            Cipher decrypted = Cipher.getInstance(coreConfigurationProperties.getAsymmetricSecurityCipherType());
            decrypted.init(Cipher.DECRYPT_MODE, privateKey);
            byte[] decodedValue = Base64.getDecoder().decode(text);
            byte[] decValue = decrypted.doFinal(decodedValue);
            return new String(decValue);
        } catch (NoSuchAlgorithmException | IllegalBlockSizeException | BadPaddingException | NoSuchPaddingException | InvalidKeyException ex) {
            log.error(ex.getMessage());

        }
        return null;
    }


}
