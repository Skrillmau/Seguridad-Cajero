package co.edu.unisabana.config.test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import co.edu.unisabana.config.EncryptionAES;
import co.edu.unisabana.config.EncryptionRSA;

class EncrytionRSATest {

	@Test()//crea el archivo
	void testSaveKeyToFile() {
		Integer a=17,b=23;
		try {
			EncryptionRSA.saveKeyToFile("Key",new BigInteger(""+ a),new BigInteger( ""+b));
		} catch (IOException e) {
			fail();
		}
		File file = new File("Key");
		Assert.assertTrue(file.exists());
		
	}
	@Test()//no debe leer archivos inexistentes
	void testReadKey() {
		try {
			EncryptionRSA.readKeyFromFile("notkey");
			fail();
		} catch (IOException e) {
			
		}
	}
	@Test()//clave identica cifrado- descrifrado retorna original
	void testEncryptDecryptSame() {
		String txt="prueba";
		try {
		
			Assert.assertEquals("prueba", EncryptionRSA.decrypt(EncryptionRSA.encrypt(txt, "Key"), "Key"));
		} catch (Exception e) {
		}
	}
	@Test()//clave vacia con cifrado debe retornar original
	void testEncryptDecryptDifferent() {
		
		String txt="prueba";
		try {
			Integer a=51,b=23;
			EncryptionRSA.saveKeyToFile("Key2",new BigInteger(""+ a),new BigInteger( ""+b));
			
			Assert.assertNotEquals("prueba", EncryptionRSA.decrypt(EncryptionRSA.encrypt(txt, "Key"), "Key2"));
		} catch (Exception e) {
		}
	}
}
