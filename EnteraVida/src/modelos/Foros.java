package modelos;

import java.time.LocalDate;

public class Foros {
	
	private String tituloTipo;
	private String user;
	private String tituloForo;
	private LocalDate fecha;
	private int ntemas;
	private String desc;
	public Foros(String tituloTipo, String user, String tituloForo, LocalDate fecha, int ntemas, String desc) {
		super();
		this.tituloTipo = tituloTipo;
		this.user = user;
		this.tituloForo = tituloForo;
		this.fecha = fecha;
		this.ntemas = ntemas;
		this.desc = desc;
	}
	public String getTituloTipo() {
		return tituloTipo;
	}
	public void setTituloTipo(String tituloTipo) {
		this.tituloTipo = tituloTipo;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "Foros [tituloTipo=" + tituloTipo + ", user=" + user + ", tituloForo=" + tituloForo + ", fecha=" + fecha
				+ ", ntemas=" + ntemas + ", desc=" + desc + "]";
	}
	public String getTituloForo() {
		return tituloForo;
	}
	public void setTituloForo(String tituloForo) {
		this.tituloForo = tituloForo;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public int getNtemas() {
		return ntemas;
	}
	public void setNtemas(int ntemas) {
		this.ntemas = ntemas;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	
	

}
