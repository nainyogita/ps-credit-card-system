package com.publicissapient.creditcardsystem.helper;

import org.springframework.stereotype.Component;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import javax.persistence.AttributeConverter;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 * AttributeEncrytHelper class implements the methods of AttributeConverter
 * This is used to encrypt/decrypt the card number of Account domain for storing in DB
 */
@Component
public class AttributeEncyptHelper implements AttributeConverter<String, String> {
    private static final String AES = "AES";
    private static final String SECRET = "abcdefg123456789";

    private final Key key; // 16 bytes
    private final Cipher cipher;

    public AttributeEncyptHelper() throws NoSuchPaddingException, NoSuchAlgorithmException {
        this.key = new SecretKeySpec(SECRET.getBytes(StandardCharsets.UTF_8), AES);
        this.cipher = Cipher.getInstance(AES);
    }

    /**
     * Encrypt the cardNumber with AES for storing in DB
     *
     * @param attribute to be encrypted
     * @return String - encrytped value
     */
    @Override
    public String convertToDatabaseColumn(String attribute) {
        try {
            cipher.init(Cipher.ENCRYPT_MODE, key);
            return Base64.getEncoder().encodeToString(cipher.doFinal(attribute.getBytes(StandardCharsets.UTF_8)));
        } catch (IllegalBlockSizeException | BadPaddingException | InvalidKeyException e) {
            throw new IllegalStateException(e);

        }
    }

    /**
     * Decrypt the dbData back to String
     *
     * @param dbData - encrypted value from DB
     * @return String - decrypted attribute value
     */
    @Override
    public String convertToEntityAttribute(String dbData) {
        try {
            cipher.init(Cipher.DECRYPT_MODE, key);
            return new String(cipher.doFinal(Base64.getDecoder().decode(dbData)));
        } catch (InvalidKeyException | BadPaddingException | IllegalBlockSizeException e) {
            throw new IllegalStateException(e);
        }
    }
}
