/*
 * @author Raul_Alonso_Ollero
 * BD_Comentarios: Operaciones de añadir,buscar y eliminar comentarios a un tema de la base de datos.
 */


package bbdd;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import exceptions.TecnicException;
import modelos.Comentarios;
import modelos.Comentarios;

public class BD_Comentarios extends BD_Conector {
	
	
	private static Statement s;	
	private static ResultSet reg;
	
	public BD_Comentarios(){
		super();
	}
	
	/**
	 * Metodo que crea un comentario, que lo puede realizar tanto un administrador,
	 * como un usuario normal.
	 * 
	 * @param Comentarios ca : Es el objeto a construir en la clase Comentarios
	 * @throws TecnicException : si no funciona por alguna razon que no tenga que ver con la base de datos.
	 * @return filas: el número de filas que se han insertado.
	 */
	
	public int CrearComentario(Comentarios ca) throws TecnicException{
		String cadenaSQL="INSERT INTO comentarios  VALUES('" + ca.getTituloTema() + "','" +
				ca.getTituloForo()+ "','" +ca.getOrden()+  "','" + ca.getUser() + "','" + ca.getFecha()+ "','" + ca.getContenido()+ "','"+ca.getNlikes()+"')"; 
		
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
	
	/**
	 * Metodo que busca un comentario por el orden en el que se ha escrito,
	 * ya que el orden no puede repetirse y es unico en cada tema.
	 * 
	 * @param orden : es el orden que ocupa el comentario en el tema
	 * @throws TecnicException : si no funciona por alguna razon que no tenga que ver con la base de datos.
	 * @return ca : el objeto construido que se ha formado al buscar el comentario
	 */
	public  Comentarios BuscarComentarios(int orden) throws TecnicException{
		String cadenaSQL="SELECT * from comentarios WHERE ORDEN ='"+orden+"'" ;
		Comentarios ca=null;
		try{
			this.abrir();
			s=c.createStatement();
			reg=s.executeQuery(cadenaSQL);
			
			if ( reg.next()){
				ca=new Comentarios(reg.getString(1),reg.getString(2),orden,reg.getString(4),reg.getDate(5).toLocalDate(),reg.getString(6),reg.getInt(7));
			}			
			s.close();
			this.cerrar();
			return ca;
		}
		catch ( SQLException e){
		//	System.out.println(e.getMessage());
			throw new TecnicException("En este momento no podemos atender su petición");
			
		}
	}

	public  Vector <Comentarios> MostrarComentarios(String tituloTema) throws TecnicException{
		String cadenaSQL="SELECT * from comentarios WHERE TITULO_TEMA ='"+ tituloTema+ "'" ;
		Vector <Comentarios> comentarios =new Vector <Comentarios>();
		try{
			this.abrir();
			s=c.createStatement();
			reg=s.executeQuery(cadenaSQL);
			while ( reg.next()){
				comentarios.add(new Comentarios(tituloTema,reg.getString("TITULO_FORO"),reg.getInt("ORDEN"),reg.getString("USER"),reg.getDate("FECHA").toLocalDate(),reg.getString("CONTENIDO"),reg.getInt("NUM_LIKES")));
			}			
			s.close();
			this.cerrar();
			return comentarios;
		}
		catch ( SQLException e){
		//	System.out.println(e.getMessage());
			throw new TecnicException("En este momento no podemos atender su petición");
			
		}
	}
	
	/**
	 * Metodo que elimina un comentario pasandole un objeto comentario entero
	 * 
	 * @param  Comentarios ca : Es el objeto a construir en la clase Comentarios
	 * @throws TecnicException : si no funciona por alguna razon que no tenga que ver con la base de datos.
	 * @return filas: el número de filas que se han eliminado.
	 */
	
	public int  EliminarComentario(Comentarios ca)  throws TecnicException{
		String cadenaSQL=" DELETE  from usuarios WHERE ORDEN ='" +ca.getOrden()+"'";
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
