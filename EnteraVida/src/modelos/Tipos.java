package modelos;

public class Tipos {
	private String titulo;
	private String user;
	private int nforos;
	private String descripcion;
	
	
	public Tipos(String titulo, String user, int nforos, String descripcion) {
		super();
		this.titulo = titulo;
		this.user = user;
		this.nforos = nforos;
		this.descripcion = descripcion;
	}
	
	
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public int getNforos() {
		return nforos;
	}
	public void setNforos(int nforos) {
		this.nforos = nforos;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	@Override
	public String toString() {
		return "Tipos [titulo=" + titulo + ", user=" + user + ", nforos=" + nforos + ", descripcion=" + descripcion
				+ "]";
	}
	
	
	

}
