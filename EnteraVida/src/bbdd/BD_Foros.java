package bbdd;

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
	
	
	
	public  Vector <Foros>  BuscarForo(String tituloForo) throws TecnicException{
		String cadenaSQL="SELECT * FROM foros WHERE \"TITULO-FORO\"='"+tituloForo+"'";
		Vector <Foros> foros =new Vector <Foros>();
		try{
			this.abrir();
			s=c.createStatement();
			reg=s.executeQuery(cadenaSQL);
			if ( reg.next()){
				foros.add( new Foros(reg.getString("TITULO_TIPO"),reg.getString("USER"),tituloForo,reg.getDate("FECHA").toLocalDate(),reg.getInt("NUM_TEMAS"),reg.getString("DESCRIPCION")));
			}			
			s.close();
			this.cerrar();
			return foros;
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
