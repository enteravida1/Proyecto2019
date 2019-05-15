package bbdd;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import exceptions.TecnicException;
import modelos.Temas;
import modelos.Noticias;
import modelos.Temas;
import modelos.Usuarios;

	
	public class BD_Temas extends BD_Conector{
		private static Statement s;		
		private static ResultSet reg;

		
		public BD_Temas(){
			super();
		}

		
		public int CrearTema(Temas t) throws TecnicException{
			String cadenaSQL="INSERT INTO temas  VALUES ('" +t.getTitulo_foro()+"','"+t.getTitulo_tema()+"','"+t.getAutor()+"','"+t.getDescripcion()+"','"
					+t.getNum_likes()+"','"+t.getNum_comentarios()+"','"+t.getFecha()+ "')";
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
		
		public  Temas BuscarTemaTitF(String titulo_foro) throws TecnicException{
			String cadenaSQL="SELECT * from noticias WHERE TITULO_FORO =' "+titulo_foro+ "'" ;
			Temas t=null;
			try{
				this.abrir();
				s=c.createStatement();
				reg=s.executeQuery(cadenaSQL);
				if ( reg.next()){
					t=new Temas(reg.getInt(1),reg.getInt(2),reg.getDate(3).toLocalDate(),titulo_foro,reg.getString(5),reg.getString(6),reg.getString(7));
				}			
				s.close();
				this.cerrar();
				return t;
			}
			catch ( SQLException e){
			//	System.out.println(e.getMessage());
				throw new TecnicException("En este momento no podemos atender su peticiï¿½n");
				
			}
		}
		
		
		public  Temas BuscarTemaTitT(String titulo_tema) throws TecnicException{
			String cadenaSQL="SELECT * from noticias WHERE TITULO_TEMA =' "+titulo_tema+ "'" ;
			Temas t=null;
			try{
				this.abrir();
				s=c.createStatement();
				reg=s.executeQuery(cadenaSQL);
				if ( reg.next()){
					t=new Temas(reg.getInt(1),reg.getInt(2),reg.getDate(3).toLocalDate(),titulo_tema,reg.getString(5),reg.getString(6),reg.getString(7));
				}			
				s.close();
				this.cerrar();
				return t;
			}
			catch ( SQLException e){
			//	System.out.println(e.getMessage());
				throw new TecnicException("En este momento no podemos atender su peticiï¿½n");
				
			}
		}
		

		public  Vector <Temas> MostrarTemas1(String titulo_foro) throws TecnicException{
			String cadenaSQL="SELECT * from temas WHERE TITULO_FORO ='"+titulo_foro+ "'" ;
			Vector <Temas> temas =new Vector <Temas>();
			try{
				this.abrir();
				s=c.createStatement();
				reg=s.executeQuery(cadenaSQL);
				while ( reg.next()){
					temas.add(new Temas(reg.getInt("NUM_COMENTARIOS"),reg.getInt("NUM_LIKES"),reg.getDate("FECHA").toLocalDate(),titulo_foro,reg.getString("TITULO_TEMA"),reg.getString("USER"),reg.getString("DESCRIPCION")));
				}			
				s.close();
				this.cerrar();
				return temas;
			}
			catch ( SQLException e){
			//	System.out.println(e.getMessage());
				throw new TecnicException("En este momento no podemos atender su petición");
				
			}
		}
		
}
