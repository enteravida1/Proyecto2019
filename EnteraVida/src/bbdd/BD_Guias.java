package bbdd;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import exceptions.TecnicException;
import modelos.Guias;
import modelos.Temas;

	public class BD_Guias extends BD_Conector{
		private static Statement s;		
		private static ResultSet reg;

		
		public BD_Guias(){
			super();
		}

		
		public  Guias BuscarGuiaTit(String titulo) throws TecnicException{
			String cadenaSQL="SELECT * from guias WHERE TITULO =' "+titulo+ "'" ;
			Guias g=null;
			try{
				this.abrir();
				s=c.createStatement();
				reg=s.executeQuery(cadenaSQL);
				if ( reg.next()){
					g=new Guias(titulo,reg.getString(2),reg.getString(3),reg.getString(4),reg.getString(5),reg.getString(6),reg.getInt(7));
				}			
				s.close();
				this.cerrar();
				return g;
			}
			catch ( SQLException e){
			//	System.out.println(e.getMessage());
				throw new TecnicException("En este momento no podemos atender su peticiï¿½n");
				
			}
		}
		
		public  Guias BuscarGuiaFecha(String fecha) throws TecnicException{
			String cadenaSQL="SELECT * from guias WHERE FECHA =' "+fecha+ "'" ;
			Guias g=null;
			try{
				this.abrir();
				s=c.createStatement();
				reg=s.executeQuery(cadenaSQL);
				if ( reg.next()){
					g=new Guias(reg.getString(1),fecha,reg.getString(3),reg.getString(4),reg.getString(5),reg.getString(6),reg.getInt(7));
				}			
				s.close();
				this.cerrar();
				return g;
			}
			catch ( SQLException e){
			//	System.out.println(e.getMessage());
				throw new TecnicException("En este momento no podemos atender su peticiï¿½n");
				
			}
		}
		
		
		public  Guias BuscarGuiaAutor(String autor) throws TecnicException{
			String cadenaSQL="SELECT * from guias WHERE AUTOR =' "+autor+ "'" ;
			Guias g=null;
			try{
				this.abrir();
				s=c.createStatement();
				reg=s.executeQuery(cadenaSQL);
				if ( reg.next()){
					g=new Guias(reg.getString(1),reg.getString(2),autor,reg.getString(4),reg.getString(5),reg.getString(6),reg.getInt(7));
				}			
				s.close();
				this.cerrar();
				return g;
			}
			catch ( SQLException e){
			//	System.out.println(e.getMessage());
				throw new TecnicException("En este momento no podemos atender su peticiï¿½n");
				
			}
		}
		
		public int AñadirGuia(Guias g) throws TecnicException{
			String cadenaSQL="INSERT INTO guias (TITULO,FECHA,AUTOR,DESARROLLADOR,PLATAFORMA,DESCRIPCION) VALUES('" + g.getTitulo() + "','" +
					g.getFecha()+"','"+g.getAutor()+"','"+g.getDesarrollador()+"','"+g.getPlataforma()+"','"+g.getDescripcion()+"')";
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
}
