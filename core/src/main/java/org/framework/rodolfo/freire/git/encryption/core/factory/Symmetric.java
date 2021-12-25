package org.framework.rodolfo.freire.git.encryption.core.factory;

import lombok.extern.slf4j.Slf4j;
import org.framework.rodolfo.freire.git.encryption.core.config.CoreConfigurationProperties;
import org.springframework.stereotype.Service;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.Base64;

@Slf4j
@Service
public class Symmetric implements Encrypt {

    private final CoreConfigurationProperties coreConfigurationProperties;

    public Symmetric(CoreConfigurationProperties coreConfigurationProperties) {
        this.coreConfigurationProperties = coreConfigurationProperties;
    }


    @Override
    public String encrypted(String text) {
        try {
            Cipher encrypted = Cipher.getInstance(coreConfigurationProperties.getSymmetricSecurityCipherType(), coreConfigurationProperties.getSymmetricSecurityCipherProvider());
            SecretKeySpec key = new SecretKeySpec(coreConfigurationProperties.getSymmetricSecurityCipherKey().getBytes(StandardCharsets.UTF_8), coreConfigurationProperties.getSymmetricSecurityCipherAlgorithmType());
            encrypted.init(Cipher.ENCRYPT_MODE, key, new IvParameterSpec(coreConfigurationProperties.getSymmetricSecurityCipherIv().getBytes(StandardCharsets.UTF_8)));
            return Base64.getEncoder().withoutPadding().encodeToString(encrypted.doFinal(text.getBytes()));
        } catch (NoSuchAlgorithmException | IllegalBlockSizeException | BadPaddingException | NoSuchPaddingException | InvalidKeyException | NoSuchProviderException | InvalidAlgorithmParameterException ex) {
            log.error("");
        }
        return null;
    }

    @Override
    public String decrypted(String text) {
        try {
            Cipher decrypted = Cipher.getInstance(coreConfigurationProperties.getSymmetricSecurityCipherType(), coreConfigurationProperties.getSymmetricSecurityCipherProvider());
            SecretKeySpec key = new SecretKeySpec(coreConfigurationProperties.getSymmetricSecurityCipherKey().getBytes(StandardCharsets.UTF_8), coreConfigurationProperties.getSymmetricSecurityCipherAlgorithmType());
            decrypted.init(Cipher.DECRYPT_MODE, key, new IvParameterSpec(coreConfigurationProperties.getSymmetricSecurityCipherIv().getBytes(StandardCharsets.UTF_8)));
            byte[] decodedValue = Base64.getDecoder().decode(text);
            byte[] decValue = decrypted.doFinal(decodedValue);
            return new String(decValue);
        } catch (NoSuchAlgorithmException | IllegalBlockSizeException | BadPaddingException | NoSuchPaddingException | InvalidKeyException | NoSuchProviderException | InvalidAlgorithmParameterException ex) {
            log.error("");
        }
        return null;
    }

}
