package bbdd;

import java.sql.ResultSet;
import java.sql.Statement;

public class BD_Comentarios extends BD_Conector {
	
	
	private static Statement s;	
	private static ResultSet reg;
	
	public BD_Comentarios(){
		super();
	}
	
	public int CrearComentario(Comentarios c) throws TecnicException{
		String cadenaSQL="INSERT INTO comentarios (TITULO_TEMA,TITULO_FORO,ORDEN,USER,FECHA,CONTENIDO,NUM_LIKES) VALUES('" + c.getTituloTema() + "','" +
				c.getTituloForo()+ "','" +c.getOrden()+  "','" + c.getUser() + "','" + c.getFecha()+ "','" + c.getContenido()+ "','"+u.getNlikes()+"')"; 
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
	
	public  Comentarios BuscarComentarios(int orden) throws TecnicException{
		String cadenaSQL="SELECT * from comentarios WHERE ORDEN =' "+orden+"'" ;
		Comentarios c=null;
		try{
			this.abrir();
			s=c.createStatement();
			reg=s.executeQuery(cadenaSQL);
			if ( reg.next()){
				c=new Comentarios(reg.getString(1),reg.getString(2),orden,reg.getString(4),reg.getString(5),reg.getString(6),reg.getString(7));
			}			
			s.close();
			this.cerrar();
			return c;
		}
		catch ( SQLException e){
		//	System.out.println(e.getMessage());
			throw new TecnicException("En este momento no podemos atender su petición");
			
		}
	}
	
	public int  EliminarComentario(Comentarios c)  throws TecnicException{
		String cadenaSQL=" DELETE  from usuarios WHERE ORDEN ='" +c.getOrden+"'";
		try{
			this.abrir();
			s=c.createStatement();
			int filas=s.executeUpdate(cadenaSQL);	
			s.close();
			this.cerrar();
			return filas;
			
			}
			catch ( SQLException e){
				this.cerrar();
				return -1;
			}
		
	}
	
	

}
