package co.edu.unisabana.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * Endpoint de las transacciones (Requiere estar autenticado)
 * @author mate_
 *
 */
@RestController
public class TransactionController {

	@RequestMapping({ "/hello" })
	public String firstPage() {
		return "Hello World";
	}

}
