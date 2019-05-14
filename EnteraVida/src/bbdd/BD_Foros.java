package bbdd;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import exceptions.TecnicException;
import modelos.Foros;
import modelos.Tipos;
import modelos.Usuarios;

public class BD_Foros extends BD_Conector {
	
	

	private static Statement s;	
	private static ResultSet reg;
	
	public BD_Foros(){
		super();
	}
	public int CrearForo(Foros f) throws TecnicException{
		String cadenaSQL="INSERT INTO foros (TITULO_TIPO,USER,TITULO-FORO,FECHA,NUM_TEMAS,DESCRIPCION) VALUES('" + f.getTituloTipo() + "','" +
				f.getUser()+ "','" + f.getTituloForo()  + "','" + f.getFecha() + "','" + f.getNtemas()+ "','" + f.getDesc()+ "')"; 
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
	
	
	
	public  Foros BuscarForo(String tituloForo) throws TecnicException{
		String cadenaSQL="SELECT * from foros WHERE TITULO-FORO ='"+ tituloForo+ " '" ;
		Foros f=null;
		try{
			this.abrir();
			s=c.createStatement();
			reg=s.executeQuery(cadenaSQL);
			if ( reg.next()){
				f= new Foros(reg.getString(1),reg.getString(2),tituloForo,reg.getDate(4).toLocalDate(),reg.getInt(5),reg.getString(6));
			}			
			s.close();
			this.cerrar();
			return f;
		}
		catch ( SQLException e){
		//	System.out.println(e.getMessage());
			throw new TecnicException("En este momento no podemos atender su petición");
			
		}
	}
	
	
	public  Foros MostrarForos() throws TecnicException{
		String cadenaSQL="SELECT * from foros" ;
		Foros u=null;
		try{
			this.abrir();
			s=c.createStatement();
			reg=s.executeQuery(cadenaSQL);
			if ( reg.next()){
				u=new Foros(reg.getString(1),reg.getString(2),reg.getString(3),reg.getDate(4).toLocalDate(),reg.getInt(5),reg.getString(6));
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
