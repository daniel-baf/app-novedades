package Backend.Utils;

import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Base64;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * Clase que se encarga de encriptar texto plano
 * @author jefe_mayoneso
 */
public class AES256Encrypter {

    private static final String SECRET_KEY = ">da123<dss_dfag;+123s>kds1...]2";
    private static final String SALT = "lgas->123:-ssfa";

    public AES256Encrypter() {
    }

    /**
     * Encripta un texto de entrada y devuelve el mismo texto encriptado con SHA256
     * @param strToEncrypt palabra a encriptar
     * @return palabra encriptada
     */
    public static String encrypt(String strToEncrypt) throws Exception {
        try {
            byte[] iv = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}; // byte de datos
            IvParameterSpec ivspec = new IvParameterSpec(iv);
            // Invoca el algoritmo SHA256
            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
            KeySpec spec = new PBEKeySpec(SECRET_KEY.toCharArray(), SALT.getBytes(), 65536, 256);
            SecretKey tmpKey = factory.generateSecret(spec);
            SecretKeySpec secretKey = new SecretKeySpec(tmpKey.getEncoded(), "AES");
            // cifra
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivspec);
            return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes(StandardCharsets.UTF_8)));
        } catch (InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException |
                 InvalidKeySpecException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e) {
            throw new Exception("No se ha podido generar una contraseña valida");
        }
    }
}
