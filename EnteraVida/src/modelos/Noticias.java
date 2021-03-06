package modelos;

import java.time.LocalDate;

public class Noticias {
	
private String titulo;
private String autor;
private LocalDate fecha;
private String descripcion;
private int numlikes;



public Noticias(String titulo, String autor, LocalDate fecha, String descripcion, int numlikes) {
	super();
	this.titulo = titulo;
	this.autor = autor;
	this.fecha = fecha;
	this.descripcion = descripcion;
	this.numlikes = numlikes;
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
	autor = autor;
}



public LocalDate getFecha() {
	return fecha;
}



public void setFecha(LocalDate fecha) {
	this.fecha = fecha;
}



public String getDescripcion() {
	return descripcion;
}



public void setDescripcion(String descripcion) {
	this.descripcion = descripcion;
}



public int getNumlikes() {
	return numlikes;
}



public void setNumlikes(int numlikes) {
	this.numlikes = numlikes;
}



@Override
public String toString() {
	return "Noticias [titulo=" + titulo + ", autor=" + autor + ", fecha=" + fecha + ", descripcion=" + descripcion
			+ ", numlikes=" + numlikes + "]";
}



}
