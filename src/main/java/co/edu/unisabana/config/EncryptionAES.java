package co.edu.unisabana.config;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
 
public class EncryptionAES {
 
    private static SecretKeySpec secretKey;
    private static byte[] key;
/**
 * Genera la key que se usara tanto para cifrado como decifrado
 * @param pKey key para cifrar/decifrar
 */
    public static void setKey(String pKey)
    {
        MessageDigest sha = null;
        try {
            key = pKey.getBytes("UTF-8");
            sha = MessageDigest.getInstance("SHA-1");
            key = sha.digest(key);
            key = Arrays.copyOf(key, 16);
            secretKey = new SecretKeySpec(key, "AES");
        }
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
 /**
  * Cifrado usando AES modo cifrador de bloques ECB
  * @param txt texto plano a cifrar
  * @param key key para cifrado simetrico AES
  * @return texto cifrado usando AES y la key
  */
    public static String encrypt(String txt, String key)
    {
        try
        {
            setKey(key);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            return Base64.getEncoder().encodeToString(cipher.doFinal(txt.getBytes("UTF-8")));
        }
        catch (Exception e)
        {
            System.out.println("Error while encrypting: " + e.toString());
        }
        return null;
    }
 /**
  * Decifrado usando AES modo de cifrador de bloques ECB
  * @param cipheredTxt texto cifrado a decifrar
  * @param key key para decifrado simetrico
  * @return texto decifrado usando AES y la key
  */
    public static String decrypt(String cipheredTxt, String key)
    {
        try
        {
            setKey(key);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            return new String(cipher.doFinal(Base64.getDecoder().decode(cipheredTxt)));
        }
        catch (Exception e)
        {
            System.out.println("Error while decrypting: " + e.toString());
        }
        return null;
    }
}