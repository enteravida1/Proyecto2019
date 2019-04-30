/*
 * BD_Usuarios: Operaciones de añadir,buscar y eliminar usuarios de la base de datos.
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
		
		public int CrearUsuario(Usuarios u) throws TecnicException{
			String cadenaSQL="INSERT INTO usuarios (USER, PASSWORD, TIPO) VALUES('" + u.getUsuario() + "','" +
					u.getClave()+"','"+u.getTipo()+"')"; 
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
		
		
		public  Usuarios BuscarUsuario(String usuario, String clave) throws TecnicException{
			String cadenaSQL="SELECT * from usuarios WHERE USER =' "+usuario+ "' and PASSWORD =' "+clave+ "'" ;
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
	 

}
