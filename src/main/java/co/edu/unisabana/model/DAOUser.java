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
 * @return username
 */
	public String getUsername() {
		return username;
	}
/**
 * Setea el username del cliente
 * @param username
 */
	public void setUsername(String username) {
		this.username = username;
	}
/**
 * Retorna el password del cliente
 * @return
 */
	public String getPassword() {
		return password;
	}
/**
 * Setea el password del lciente
 * @param password
 */
	public void setPassword(String password) {
		this.password = password;
	}

}
