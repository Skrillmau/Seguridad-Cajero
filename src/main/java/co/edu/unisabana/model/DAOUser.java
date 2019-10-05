package co.edu.unisabana.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
/**
 * modela usuario y conexion a base de datos
 * @author mate_
 *
 */
@Entity
@Table(name = "user")
public class DAOUser {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column
	private String username;
	@Column
	@JsonIgnore
	private String password;
/**
 * Retorna el nombre de usuario 
 * @return username nombre de usuario
 */
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
