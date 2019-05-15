package modelos;

public class Usuarios {

	private String clave;
	private String usuario;
	private String tipo;
	private String estado;
	
	
	public Usuarios(String usuario, String clave, String tipo,String estado) {
		super();
		this.clave = clave;
		this.usuario = usuario;
		this.tipo = tipo;
		this.estado= estado;
	}


	@Override
	public String toString() {
		return "Usuarios [clave=" + clave + ", usuario=" + usuario + ", tipo=" + tipo + ", estado=" + estado + "]";
	}


	public String getClave() {
		return clave;
	}


	public void setClave(String clave) {
		this.clave = clave;
	}


	public String getUsuario() {
		return usuario;
	}


	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
}
