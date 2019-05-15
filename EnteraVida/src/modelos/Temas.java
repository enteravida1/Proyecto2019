package modelos;

import java.time.LocalDate;

public class Temas {
	
	private int num_comentarios;
	private int num_likes;
	private LocalDate fecha;
	private String titulo_foro;
	private String titulo_tema;
	private String autor;
	private String descripcion;
	
	
	public Temas(int num_comentarios, int num_likes, LocalDate fecha, String titulo_foro, String titulo_tema, String autor,
			String descripcion) {
		super();
		this.num_comentarios = num_comentarios;
		this.num_likes = num_likes;
		this.fecha = fecha;
		this.titulo_foro = titulo_foro;
		this.titulo_tema = titulo_tema;
		this.autor = autor;
		this.descripcion = descripcion;
	}


	public int getNum_comentarios() {
		return num_comentarios;
	}


	public void setNum_comentarios(int num_comentarios) {
		this.num_comentarios = num_comentarios;
	}


	public int getNum_likes() {
		return num_likes;
	}


	public void setNum_likes(int num_likes) {
		this.num_likes = num_likes;
	}


	

	@Override
	public String toString() {
		return "Temas [num_comentarios=" + num_comentarios + ", num_likes=" + num_likes + ", fecha=" + fecha
				+ ", titulo_foro=" + titulo_foro + ", titulo_tema=" + titulo_tema + ", autor=" + autor
				+ ", descripcion=" + descripcion + "]";
	}


	public LocalDate getFecha() {
		return fecha;
	}


	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}


	public String getTitulo_foro() {
		return titulo_foro;
	}


	public void setTitulo_foro(String titulo_foro) {
		this.titulo_foro = titulo_foro;
	}


	public String getTitulo_tema() {
		return titulo_tema;
	}


	public void setTitulo_tema(String titulo_tema) {
		this.titulo_tema = titulo_tema;
	}


	public String getAutor() {
		return autor;
	}


	public void setAutor(String autor) {
		this.autor = autor;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	
	
}
