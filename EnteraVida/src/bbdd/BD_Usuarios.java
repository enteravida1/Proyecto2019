/*
 * BD_Usuarios: Operaciones de añadir,buscar y eliminar usuarios de la base de datos.
 * @author Raul_Alonso_Ollero
 */
package bbdd;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import exceptions.TecnicException;
import modelos.*;

public class BD_Usuarios extends BD_Conector {

	
		private static Statement s;	
		private static ResultSet reg;
		
		public BD_Usuarios(){
			super();
		}
		/**
		 * Metodo que crea un usuario. 
		 * Por ahora este metodo se usará en el main para que una persona al registrarse pueda crear su usuario
		 * 
		 * @param Usuarios u: Es el objeto a construir en la clase Usuarios
		 * @throws TecnicException : si no funciona por alguna razon que no tenga que ver con la base de datos.
		 * @return filas: el número de filas que se han insertado.
		 */
		public int CrearUsuario(Usuarios u) throws TecnicException{
			String cadenaSQL="INSERT INTO usuarios (USER,PASSWORD,TIPO,ESTADO) VALUES('" + u.getUsuario() + "','" +
					u.getClave()+"','"+u.getTipo()+"','"+null+"')"; 
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
		 * Metodo que busca un usuario. 
		 * Este metodo se usará principalmente para ver si un usuario está en la base de datos al logearse.
		 * 
		 * @param usuario : el nombre de usuario
		 * @param clave : la contraseña del usuario
		 * @throws TecnicException : si no funciona por alguna razon que no tenga que ver con la base de datos.
		 * @return u : el objeto ya creado de la clase Usuarios si existe.
		 */
		
		public  Usuarios BuscarUsuario(String usuario, String clave) throws TecnicException{
			String cadenaSQL="SELECT * from usuarios WHERE USER ='"+usuario+"' and PASSWORD ='"+clave+"'" ;
			Usuarios u=null;
			try{
				this.abrir();
				s=c.createStatement();
				reg=s.executeQuery(cadenaSQL);
				if ( reg.next()){
					u=new Usuarios(usuario,clave,reg.getString(3),reg.getString(4));
				}			
				s.close();
				this.cerrar();
				return u;
			}
			catch ( SQLException e){
			//	System.out.println(e.getMessage());
				throw new TecnicException("En este momento no podemos atender su petición");
				
			}
		}
		
		public  Usuarios BuscarUsuario2(String usuario) throws TecnicException{
			String cadenaSQL="SELECT * from usuarios WHERE USER ='"+usuario+"'" ;
			Usuarios u=null;
			try{
				this.abrir();
				s=c.createStatement();
				reg=s.executeQuery(cadenaSQL);
				if ( reg.next()){
					u=new Usuarios(usuario,reg.getString(2),reg.getString(3),reg.getString(4));
				}			
				s.close();
				this.cerrar();
				return u;
			}
			catch ( SQLException e){
			//	System.out.println(e.getMessage());
				throw new TecnicException("En este momento no podemos atender su petición");
				
			}
		}
		
		/**
		 * Metodo que elimina un usuario
		 * Este metodo elimina a un usuario, y solo lo puede utilizar el administrador
		 * 
		 * @param Usuarios u: el objeto entero de la clase Usuarios
		 * @throws TecnicException : si no funciona por alguna razon que no tenga que ver con la base de datos.
		 * @return filas : el numero de fila que se han eliminado.
		 */
		
		public int  EliminarUsuario(Usuarios u)  throws TecnicException{
			String cadenaSQL=" DELETE  from usuarios WHERE USER ='" +u.getUsuario()+"'";
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
		/**
		 * Metodo que cambia el tipo de usuario
		 * Este metodo se usará para cambiar el tipo de usuario, que solo lo puede hacer el admin
		 * 
		 * @param Usuarios u : el objeto entero de la clase Usuarios
		 * @throws TecnicException : si no funciona por alguna razon que no tenga que ver con la base de datos.
		 * @return filas : el numero de fila que se han eliminado.
		 */
		
		
		public int CambiarTipo(Usuarios u)throws TecnicException{
			String cadenaSQL="UPDATE usuarios SET tipo='" + u.getTipo()+"' WHERE USER = '"+ u.getUsuario()+"'";
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
		
		public int CambiarEstado1(Usuarios u)throws TecnicException{
			String cadenaSQL="UPDATE usuarios SET estado='advertido' WHERE USER = '"+ u.getUsuario()+"'";
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
		public int CambiarEstado2(Usuarios u)throws TecnicException{
			String cadenaSQL="UPDATE usuarios SET estado='bloqueado' WHERE USER = '"+ u.getUsuario()+"'";
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
