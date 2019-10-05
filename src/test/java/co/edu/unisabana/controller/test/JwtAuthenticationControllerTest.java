package co.edu.unisabana.controller.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import co.edu.unisabana.controller.JwtAuthenticationController;

class JwtAuthenticationControllerTest {
	JwtAuthenticationController authcon= new JwtAuthenticationController();
	@Test//no puede añadir usuarios nulos
	void testAutheticate() {
		try {
			authcon.saveUser(null);
			fail();
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block

		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail();

		}
		
	}

}
