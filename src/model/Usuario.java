package model;

import java.util.*;

public class Usuario {
	
	private int id;
	private String nombre;
	private String mail;
	private String password;	
	private String estado = "activo";
	
	public Usuario(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	

	@Override
	public String toString() {
		return "Usuario {" + "id=" + id + ", nombre=" + nombre + ", mail=" + mail + ", password=" + password + ", estado=" + estado + "}";
	} 
	
	
	
	

}
