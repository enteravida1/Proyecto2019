package modelos;

import java.sql.Statement;
import java.time.LocalDate;

public class Comentarios {
	
	private String tituloTema;
	private String tituloForo;
	private int orden;
	private String user;
	private LocalDate fecha;
	private String contenido;
	private int nlikes;
	
	
	
	public Comentarios(String tituloTema, String tituloForo, int orden, String user, LocalDate fecha, String contenido,
			int nlikes) {
		super();
		this.tituloTema = tituloTema;
		this.tituloForo = tituloForo;
		this.orden = 0;
		this.user = user;
		this.fecha = fecha;
		this.contenido = contenido;
		this.nlikes = nlikes;
	}

	


	public String getTituloTema() {
		return tituloTema;
	}



	public void setTituloTema(String tituloTema) {
		this.tituloTema = tituloTema;
	}



	public String getTituloForo() {
		return tituloForo;
	}



	public void setTituloForo(String tituloForo) {
		this.tituloForo = tituloForo;
	}



	public int getOrden() {
		return orden;
	}



	public void setOrden(int orden) {
		this.orden = orden;
	}



	public String getUser() {
		return user;
	}



	public void setUser(String user) {
		this.user = user;
	}



	


	public LocalDate getFecha() {
		return fecha;
	}



	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}



	public String getContenido() {
		return contenido;
	}



	public void setContenido(String contenido) {
		this.contenido = contenido;
	}



	public int getNlikes() {
		return nlikes;
	}



	@Override
	public String toString() {
		return "Comentarios [tituloTema=" + tituloTema + ", tituloForo=" + tituloForo + ", orden=" + orden + ", user="
				+ user + ", fecha=" + fecha + ", contenido=" + contenido + ", nlikes=" + nlikes + "]";
	}



	public void setNlikes(int nlikes) {
		this.nlikes = nlikes;
	}



	
	
	
	
	

}
