package modelos;

import java.time.LocalDate;

public class Guias {
	
	private String titulo;
	private LocalDate fecha;
	private String autor;
	private String desarrollador;
	private String plataforma;
	private String descripcion;
	private int num_likes;
	
	public Guias(String titulo, LocalDate fecha, String autor, String desarrollador, String plataforma, String descripcion,
			int num_likes) {
		super();
		this.titulo = titulo;
		this.fecha = fecha;
		this.autor = autor;
		this.desarrollador = desarrollador;
		this.plataforma = plataforma;
		this.descripcion = descripcion;
		this.num_likes = num_likes;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getDesarrollador() {
		return desarrollador;
	}

	public void setDesarrollador(String desarrollador) {
		this.desarrollador = desarrollador;
	}

	public String getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getNum_likes() {
		return num_likes;
	}

	public void setNum_likes(int num_likes) {
		this.num_likes = num_likes;
	}
	
	
	

}
