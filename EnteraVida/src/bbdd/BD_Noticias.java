package bbdd;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import exceptions.TecnicException;
import modelos.Noticias;
import modelos.Usuarios;


public class BD_Noticias extends BD_Conector{
	private static Statement s;		
	private static ResultSet reg;

	public BD_Noticias(){
		super();
	}
	
	public  Noticias BuscarNoticiaTitulo(String titulo) throws TecnicException{
		String cadenaSQL="SELECT * from noticias WHERE TITULO =' "+titulo+ "'" ;
		Noticias n=null;
		try{
			this.abrir();
			s=c.createStatement();
			reg=s.executeQuery(cadenaSQL);
			if ( reg.next()){
				n=new Noticias(titulo,reg.getString(2),reg.getString(3),reg.getString(4),reg.getInt(5));
			}			
			s.close();
			this.cerrar();
			return n;
		}
		catch ( SQLException e){
		//	System.out.println(e.getMessage());
			throw new TecnicException("En este momento no podemos atender su peticiï¿½n");
			
		}
	}
	
	public  Noticias BuscarNoticiaFecha(String fecha) throws TecnicException{
		String cadenaSQL="SELECT * from noticias WHERE FECHA =' "+fecha+ "'" ;
		Noticias n=null;
		try{
			this.abrir();
			s=c.createStatement();
			reg=s.executeQuery(cadenaSQL);
			if ( reg.next()){
				n=new Noticias(fecha,reg.getString(2),reg.getString(3),reg.getString(4),reg.getInt(5));
			}			
			s.close();
			this.cerrar();
			return n;
		}
		catch ( SQLException e){
		//	System.out.println(e.getMessage());
			throw new TecnicException("En este momento no podemos atender su peticiï¿½n");
			
		}
	}
	
	
	public  Noticias BuscarNoticiaUsuario(String autor) throws TecnicException{
		String cadenaSQL="SELECT * from noticias WHERE AUTOR =' "+autor+ "'" ;
		Noticias n=null;
		try{
			this.abrir();
			s=c.createStatement();
			reg=s.executeQuery(cadenaSQL);
			if ( reg.next()){
				n=new Noticias(autor,reg.getString(2),reg.getString(3),reg.getString(4),reg.getInt(5));
			}			
			s.close();
			this.cerrar();
			return n;
		}
		catch ( SQLException e){
		//	System.out.println(e.getMessage());
			throw new TecnicException("En este momento no podemos atender su peticiï¿½n");
			
		}
	}
	
	
	public int AñadirNoticia(Noticias n) throws TecnicException{
		String cadenaSQL="INSERT INTO noticias (TITULO, AUTOR, FECHA,DESCRIPCION) VALUES('" + n.getTitulo() + "','" +
				n.getAutor()+"','"+n.getFecha()+"','"+n.getDescripcion()+")"; 
		try{
			this.abrir();
			s=c.createStatement();
			int filas=s.executeUpdate(cadenaSQL);
			s.close();
			this.cerrar();
			return filas;
			}
			catch ( SQLException e){			
				return -1;
			}
		
	}
	

}
