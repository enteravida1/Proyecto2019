package principal;

import java.time.LocalDate;
import java.util.Scanner;

import bbdd.BD_Comentarios;
import bbdd.BD_Conector;
import bbdd.BD_Foros;
import bbdd.BD_Guias;
import bbdd.BD_Noticias;
import bbdd.BD_Temas;
import bbdd.BD_Tipos;
import bbdd.BD_Usuarios;
import exceptions.TecnicException;
import modelos.Foros;
import modelos.Temas;
import modelos.Tipos;
import modelos.Usuarios;

public class main {

	public static void main(String[] args) throws TecnicException {

		Scanner sLeer = new Scanner(System.in);
		int opc = 0;
		BD_Conector.BD_Ini("enteravida");
		BD_Usuarios bdu = new BD_Usuarios();
		BD_Tipos bdti = new BD_Tipos();
		BD_Foros bdf = new BD_Foros();
		BD_Temas bdte = new BD_Temas();
		BD_Comentarios bdc = new BD_Comentarios();
		BD_Noticias bdn = new BD_Noticias();
		BD_Guias bdg = new BD_Guias();

		do {
			System.out.println("\n\nBienvenido a EnteraVida");
			System.out.println("***************");
			System.out.println(" 1.Registrarte\n 2.Iniciar Sesión\n 3.Salir");
			opc = sLeer.nextInt();

			switch (opc) {
			case 1:
				sLeer.nextLine();
				System.out.println("Introduce tu nombre de usuario");
				String user = sLeer.nextLine();

				System.out.println("Introduce una contraseña");
				String pass1 = sLeer.nextLine();

				System.out.println("Introducede de nuevo la contraseña");
				String pass2 = sLeer.nextLine();

				if (!pass1.equals(pass2))
					System.out.println("Las contraseñas no coinciden");
				else {
					Usuarios u = new Usuarios(user, pass1, user, null);

					int filas = bdu.CrearUsuario(u);
					switch (filas) {
					case 1:
						System.out.println("\nAlumno añadido");
						break;
					case 0:
						System.out.println("\nNo añadido");
						break;
					case -1:
						System.out.println("\nProblemas técnicos");

						break;

					}
				}
				break;
			case 2:
				sLeer.nextLine();
				System.out.println("Introduce tu usuario");
				user = sLeer.nextLine();

				System.out.println("Introduce tu contraseña");
				String pass = sLeer.nextLine();

				// System.out.println(bdu.BuscarUsuario(user, pass).toString());
				Usuarios u = bdu.BuscarUsuario(user, pass);
				if (u == null) {
					System.out.println("usuario o contraseña incorrectas");
				} else {
					System.out.println(u.toString());
					if (u.getTipo().equals("admin"))
						menuAdministrador();
					else
						menuCliente(user);
				}
				break;

			}

		} while (opc != 3);

	}

	private static void menuAdministrador() {

	}

	private static void menuCliente(String user) throws TecnicException {
		LocalDate fechaactual=LocalDate.now();
		BD_Conector.BD_Ini("enteravida");
		BD_Usuarios bdu = new BD_Usuarios();
		BD_Tipos bdti = new BD_Tipos();
		BD_Foros bdf = new BD_Foros();
		BD_Temas bdte = new BD_Temas();
		BD_Comentarios bdc = new BD_Comentarios();
		BD_Noticias bdn = new BD_Noticias();
		BD_Guias bdg = new BD_Guias();

		Scanner sLeer = new Scanner(System.in);
		int usu = 0;
		System.out.println(" 1.Crear post\n 2.buscar post\n 3.Buscar noticia\n 4.Buscar guía");
		usu = sLeer.nextInt();

		switch (usu) {
		case 1:
			System.out.println(bdti.MostrarTipos());

			System.out.println("Escribe el titulo del tipo");
			String Tipo = sLeer.nextLine();
			Tipos t = bdti.BuscarTipos(Tipo);

			System.out.println(bdf.MostrarForos());

			System.out.println("Escribe el titulo del foro");
			String Foro = sLeer.nextLine();
			Foros f = bdf.BuscarForo(Foro);

			System.out.println("Escribe un titulo para el post: ");
			String titulo_post = sLeer.nextLine();
			System.out.println("Pon una descripcion: ");
			String desc_post = sLeer.nextLine();
			
			Temas p=new Temas(0,0,fechaactual,Foro,titulo_post,user,desc_post);

			int filas = bdte.CrearTema(p);
			switch (filas) {
			case 1:
				System.out.println("\nPost Creado.");
				break;
			case 0:
				System.out.println("\nNo se ha podido crear el Post.");
				break;
			case -1:
				System.out.println("\nProblemas técnicos.");

				break;

			}
			break;

		case 2:
			System.out.println(bdti.MostrarTipos());
			System.out.println("Elige el tipo al que quieres entrar: ");
			String eleccion = sLeer.nextLine();
			System.out.println(bdti.BuscarTipos(eleccion));

			System.out.println(bdf.MostrarForos());
			System.out.println("Elige el foro al que quieres entrar: ");
			String eleccion1 = sLeer.nextLine();
			System.out.println(bdf.BuscarForo(eleccion1));

			System.out.println("Escribe un titulo para el post: ");
			String titulo_post1 = sLeer.nextLine();
			
 
			System.out.println(bdte.BuscarTemaTitT(titulo_post1));
			break;

			

			
		case 3:
			System.out.println("Introduce la noticia que quieras buscar");
			String not= sLeer.nextLine();
			System.out.println(bdn.BuscarNoticiaTitulo(not));

			break;
		case 4:
			System.out.println("Introduce la guia que quieras buscar");
			String gui= sLeer.nextLine();
			System.out.println(bdg.BuscarGuiaTit(gui));
			
			break;

		}
	}

}
