package modelos;

public class Comentarios {
	
	private String tituloTema;
	private String tituloForo;
	private int orden;
	private String user;
	private String fecha;
	private String contenido;
	private int nlikes;
	
	
	
	public Comentarios(String tituloTema, String tituloForo, int orden, String user, String fecha, String contenido,
			int nlikes) {
		super();
		this.tituloTema = tituloTema;
		this.tituloForo = tituloForo;
		this.orden = orden;
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



	public String getFecha() {
		return fecha;
	}



	public void setFecha(String fecha) {
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



	public void setNlikes(int nlikes) {
		this.nlikes = nlikes;
	}
	
	
	
	
	

}
