package co.edu.unisabana.config.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import co.edu.unisabana.config.EncryptionAES;

class EncryptionAESTest {

	@Test()//clave nula debe tirar NullpointerException
	void testSetKey() {
		try {
			String key = null;
			EncryptionAES.setKey(key);
			fail();
		}catch (NullPointerException e) {
		}
		
	}
	@Test()//clave vacia con texto prueba debe retornar 
	void testEncrypt() {
			String text="prueba";
			String key ="pass";
			Assert.assertEquals("EJnSmuSYZ09rooLc+fpEeQ==",EncryptionAES.encrypt(text, key));
	}
	@Test()//clave igual con cifrado debe retornar original
	void testDecrypt() {
			String cipher="EJnSmuSYZ09rooLc+fpEeQ==";
			String key = "pass";
			
			Assert.assertEquals("prueba",EncryptionAES.decrypt(cipher, key));
	}
	@Test()//clave larga no debe permitir desencripcion
	void testSetKeyLongitudDeClaveDecrypt() {
			String cipher="EJnSmuSYZ09rooLc+fpEeQ==";
			String key = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
			Assert.assertEquals(null,EncryptionAES.decrypt(cipher, key));
	}
	@Test()//clave larga  debe permitir encripcion
	void testSetKeyLongitudDeClaveEncrypt() {
			String text="prueba";
			String key = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
			Assert.assertNotEquals(null,EncryptionAES.encrypt(text, key));
	}
	@Test()//clave distinta con cifrado debe retornar otra cosa
	void testDecryptWrong() {
			String cipher="EJnSmuSYZ09rooLc+fpEeQ==";
			String key = "Pass";
			Assert.assertNotEquals("prueba",EncryptionAES.decrypt(cipher, key));
	}
	

}
