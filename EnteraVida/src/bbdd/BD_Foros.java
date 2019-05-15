package bbdd;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import exceptions.TecnicException;
import modelos.Foros;
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

	
	public  Vector <Foros> MostrarForo() throws TecnicException{
		String cadenaSQL="SELECT * from foros" ;
		Vector <Foros> foro =new Vector <Foros>();
		try{
			this.abrir();
			s=c.createStatement();
			reg=s.executeQuery(cadenaSQL);
			while ( reg.next()){
				foro.add(new Foros(reg.getString("TITULO_TIPO"),reg.getString("USER"),reg.getString("TITULO-FORO"),reg.getDate("FECHA").toLocalDate(),reg.getInt("NUM_TEMAS"),reg.getString("DESCRIPCION")));
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
