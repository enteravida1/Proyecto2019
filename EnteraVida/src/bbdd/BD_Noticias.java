package bbdd;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Vector;

import exceptions.TecnicException;
import modelos.Noticias;
import modelos.Noticias;
import modelos.Usuarios;


public class BD_Noticias extends BD_Conector{
	private static Statement s;		
	private static ResultSet reg;

	public BD_Noticias(){
		super();
	}
	
	public  Noticias BuscarNoticiaTitulo(String titulo) throws TecnicException{
		String cadenaSQL="SELECT * from noticias WHERE TITULO ='"+titulo+ "'" ;
		Noticias n=null;
		try{
			this.abrir();
			s=c.createStatement();
			reg=s.executeQuery(cadenaSQL);
			if ( reg.next()){
				n=new Noticias(titulo,reg.getString("USER"),reg.getDate("FECHA").toLocalDate(),reg.getString("DESCRIPCION"),reg.getInt("NUM_LIKES"));
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
	
	public  Noticias BuscarNoticiaFecha(LocalDate fecha) throws TecnicException{
		String cadenaSQL="SELECT * from noticias WHERE FECHA ='"+fecha+ "'" ;
		Noticias n=null;
		try{
			this.abrir();
			s=c.createStatement();
			reg=s.executeQuery(cadenaSQL);
			if ( reg.next()){
				n=new Noticias(reg.getString(1),reg.getString(2),fecha,reg.getString(4),reg.getInt(5));
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
		String cadenaSQL="SELECT * from noticias WHERE USER ='"+autor+ "'" ;
		Noticias n=null;
		try{
			this.abrir();
			s=c.createStatement();
			reg=s.executeQuery(cadenaSQL);
			if ( reg.next()){
			//	java.sql.Date fecha = reg.getDate("FECHA");
				//LocalDate fechaBuena = fecha.toLocalDate();
				n=new Noticias(reg.getString("TITULO"),autor,reg.getDate("FECHA").toLocalDate(),reg.getString("DESCRIPCION"),reg.getInt("NUM_LIKES"));
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
		String cadenaSQL="INSERT INTO noticias  VALUES('" + n.getAutor()+"','"+n.getFecha()+"','"+n.getDescripcion()+ "','" + n.getNumlikes()+ "','"+n.getTitulo()+"')"; 
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
	
	public  Vector <Noticias> MostrarNoticias2() throws TecnicException{
		String cadenaSQL="SELECT * from noticias " ;
		Vector <Noticias> noticias =new Vector <Noticias>();
		try{
			this.abrir();
			s=c.createStatement();
			reg=s.executeQuery(cadenaSQL);
			while ( reg.next()){
				noticias.add(new Noticias(reg.getString("TITULO"),reg.getString("USER"),reg.getDate("FECHA").toLocalDate(),reg.getString("DESCRIPCION"),reg.getInt("NUM_LIKES")));
			}			
			s.close();
			this.cerrar();
			return noticias;
		}
		catch ( SQLException e){
		//	System.out.println(e.getMessage());
			throw new TecnicException("En este momento no podemos atender su petición");
			
		}
	}
	

}
