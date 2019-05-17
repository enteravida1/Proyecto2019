package bbdd;
/*

* @author Raul Alonso
*/

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import exceptions.TecnicException;
import modelos.Tipos;

public class BD_Tipos extends BD_Conector {

	private static Statement s;	
	private static ResultSet reg;
	
	
	public BD_Tipos(){
		super();
	}
	
	
	

	public  Tipos BuscarTpos(String titulo) throws TecnicException{
		String cadenaSQL="SELECT * from tipos WHERE TITULO ='"+titulo+"'" ;
		Tipos u=null;
		try{
			this.abrir();
			s=c.createStatement();
			reg=s.executeQuery(cadenaSQL);
			if ( reg.next()){
				u=new Tipos(titulo,reg.getString(2),reg.getInt(3),reg.getString(4));
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
		public  Tipos MostrarTipos() throws TecnicException{
			String cadenaSQL="SELECT * from tipos " ;
			Tipos u=null;
			try{
				this.abrir();
				s=c.createStatement();
				reg=s.executeQuery(cadenaSQL);
				if ( reg.next()){
					u=new Tipos(reg.getString(1),reg.getString(2),reg.getInt(3),reg.getString(4));
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
	
	
}
