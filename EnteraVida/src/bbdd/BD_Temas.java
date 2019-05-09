package bbdd;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
			String cadenaSQL="INSERT INTO temas (FECHA,TITULO_FORO, TITULO_TEMA, AUTOR,DESCRIPCION) VALUES('" + t.getFecha() + "','" +
					t.getTitulo_foro()+"','"+t.getTitulo_tema()+"','"+t.getAutor()+"','"+t.getDescripcion()+"')";
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
					t=new Temas(reg.getInt(1),reg.getInt(2),titulo_foro,reg.getString(4),reg.getString(5),reg.getString(6),reg.getString(7));
				}			
				s.close();
				this.cerrar();
				return t;
			}
			catch ( SQLException e){
			//	System.out.println(e.getMessage());
				throw new TecnicException("En este momento no podemos atender su petici�n");
				
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
					t=new Temas(reg.getInt(1),reg.getInt(2),titulo_tema,reg.getString(4),reg.getString(5),reg.getString(6),reg.getString(7));
				}			
				s.close();
				this.cerrar();
				return t;
			}
			catch ( SQLException e){
			//	System.out.println(e.getMessage());
				throw new TecnicException("En este momento no podemos atender su petici�n");
				
			}
		}
}
