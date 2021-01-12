package model;

import java.util.*;

public class Prestamo {
	
	private int id;
	private int id_libro;
	private int id_usuario;
	private Date fecha;
	
	private Usuario usr;
	private Libro lbr;
	
	public Prestamo(int id) {
		this.id = id;
		this.fecha = new Date();
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId_libro() {
		return id_libro;
	}
	public void setId_libro(int id_libro) {
		this.id_libro = id_libro;
	}
	public int getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Usuario getUsr() {
		return usr;
	}
	public void setUsr(Usuario usr) {
		this.usr = usr;
	}
	public Libro getLbr() {
		return lbr;
	}
	public void setLbr(Libro lbr) {
		this.lbr = lbr;
	}
	@Override
	public String toString() {
		return "Prestamo {id=" + id + ", id_libro=" + id_libro + ", id_usuario=" + id_usuario + ", fecha=" + fecha
				+ ", usr=" + usr + ", lbr=" + lbr + "}";
	}
	
	

}
