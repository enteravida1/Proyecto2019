package bbdd;
/*
@author Mario Martin
* editado por: 
* @author Raul Alonso
*/

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import exceptions.TecnicException;
import modelos.Foros;
import modelos.Temas;
import modelos.Usuarios;

public class BD_Foros extends BD_Conector {
	
	

	private static Statement s;	
	private static ResultSet reg;
	
	public BD_Foros(){
		super();
	}
	public int CrearForo(Foros f) throws TecnicException{
		String cadenaSQL="INSERT INTO foros VALUES('" + f.getTituloTipo() + "','" +
				f.getUser()+ "','"  + f.getFecha() + "','" + f.getNtemas()+ "','" + f.getDesc()+"','" + f.getTituloForo()  + "')"; 
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
	
	
	public  Foros BuscarForos(String titulo_foro) throws TecnicException{
		String cadenaSQL="SELECT * from foros WHERE TITULO_FORO ='"+titulo_foro+ "'" ;
		Foros f=null;
		try{
			this.abrir();
			s=c.createStatement();
			reg=s.executeQuery(cadenaSQL);
			if ( reg.next()){
				f=new Foros(reg.getString("TITULO_TIPO"),reg.getString("USER"),reg.getString("TITULO_FORO"),reg.getDate("FECHA").toLocalDate(),reg.getInt("NUM_TEMAS"),reg.getString("DESCRIPCION"));
			}			
			s.close();
			this.cerrar();
			return f;
		}
		catch ( SQLException e){
		//	System.out.println(e.getMessage());
			throw new TecnicException("En este momento no podemos atender su peticiï¿½n");
			
		}
	}
	//Foros(reg.getString("TITULO_TIPO"),reg.getString("USER"),reg.getString("TITULO_FORO"),reg.getDate("FECHA").toLocalDate(),reg.getInt("NUM_TEMAS"),reg.getString("DESCRIPCION")));

	
	public  Vector <Foros> MostrarForo() throws TecnicException{
		String cadenaSQL="SELECT * from foros" ;
		Vector <Foros> foro =new Vector <Foros>();
		try{
			this.abrir();
			s=c.createStatement();
			reg=s.executeQuery(cadenaSQL);
			while ( reg.next()){
				foro.add(new Foros(reg.getString("TITULO_TIPO"),reg.getString("USER"),reg.getString("TITULO_FORO"),reg.getDate("FECHA").toLocalDate(),reg.getInt("NUM_TEMAS"),reg.getString("DESCRIPCION")));
			}			
			s.close();
			this.cerrar();
			return foro;
		}
		catch ( SQLException e){
		//	System.out.println(e.getMessage());
			throw new TecnicException("En este momento no podemos atender su petición");
			
		}
	}
}
