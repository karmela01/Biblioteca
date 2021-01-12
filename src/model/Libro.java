package model;

import java.util.*;

public class Libro {
	
	private int id;
	private String titulo;
	private String autor;
	private String Editorial;
	
	public Libro(int id) {
		this.id = id;
	}
	public Libro(int id, String titulo, String autor, String editorial) {
		this.id = id;
		this.titulo = titulo;
		this.autor = autor;
		this.Editorial = editorial;
	}

	/*public Libro() {
		
	}
	*/
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getEditorial() {
		return Editorial;
	}

	public void setEditorial(String editorial) {
		Editorial = editorial;
	}

	@Override
	public String toString() {
		return "Libro {" + " id=" + id + ", titulo=" + titulo + ", autor=" + autor + ", Editorial=" + Editorial + "}";
	}
	
	
	
}
