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
import modelos.Guias;
import modelos.Noticias;
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

				System.out.println("Introduce de nuevo la contraseña");
				String pass2 = sLeer.nextLine();

				if (!pass1.equals(pass2))
					System.out.println("Las contraseñas no coinciden");
				else {
					Usuarios u = new Usuarios(user, pass1, "user", null);

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
						menuAdministrador(user);
					else
						menuCliente();
				}
				break;

			}

		} while (opc != 3);

	}

	private static void menuAdministrador(String user) throws TecnicException {
		Scanner sLeer = new Scanner(System.in);
		int opc = 0;

		LocalDate fechaActual = LocalDate.now();

		BD_Conector.BD_Ini("enteravida");
		BD_Usuarios bdu = new BD_Usuarios();
		BD_Tipos bdti = new BD_Tipos();
		BD_Foros bdf = new BD_Foros();
		BD_Temas bdte = new BD_Temas();
		BD_Comentarios bdc = new BD_Comentarios();
		BD_Noticias bdn = new BD_Noticias();
		BD_Guias bdg = new BD_Guias();

		do {
			System.out.println("\n\nBienvenido administrador  " + user);
			System.out.println("***************");
			System.out.println(
					" 1.Crear guía\n 2.Crear foro\n 3.Crear noticia\n 4.Controlar usuarios\n 5.Buscar foro, guia, noticia");
			opc = sLeer.nextInt();
			switch (opc) {
			case 1:
				System.out.println("Indica un titulo para la guia");
				String tituloG = sLeer.nextLine();

				System.out.println("Indica el desarrollador del titulo que vas a hablar");
				String desarrollador = sLeer.nextLine();

				System.out.println("Indica la plataforma para la que está hecho (playStation, Xbox, Pc...)");
				String plataforma = sLeer.nextLine();

				System.out.println("Escribe la guia");
				String desc = sLeer.nextLine();
				Guias g = new Guias(tituloG, fechaActual, user, desarrollador, plataforma, desc, 0);

				int filasg = bdg.AñadirGuia(g);
				switch (filasg) {
				case 1:
					System.out.println("\nGuia añadido");
					break;
				case 0:
					System.out.println("\nGuia NO añadida");
					break;
				case -1:
					System.out.println("\nProblemas técnicos");

					break;

				}

				break;

			case 2:

				System.out.println("-------");
				System.out.println(bdti.MostrarTipos());
				System.out.println("-------");

				System.out.println("Elige un tipo");
				String eligeTipo = sLeer.nextLine();

				bdti.BuscarTpos(eligeTipo);
				bdf.MostrarForo();

				System.out.println("Indica un titulo al foro:\n");
				String tituloF = sLeer.nextLine();

				System.out.println("Escribe una descripcion para el foro:\n");
				String descF = sLeer.nextLine();

				Foros f = new Foros(eligeTipo, user, tituloF, fechaActual, 0, descF);

				int filasf = bdf.CrearForo(f);
				switch (filasf) {
				case 1:
					System.out.println("\nForo añadido");
					break;
				case 0:
					System.out.println("\nForo NO añadido");
					break;
				case -1:
					System.out.println("\nProblemas técnicos");

					break;

				}
				break;

			case 3:

				System.out.println("Indica un titulo para la noticia:\n");
				String tituloN = sLeer.nextLine();

				System.out.println("Escribe una descripción:\n");
				String descripcion = sLeer.nextLine();

				Noticias n = new Noticias(tituloN, user, fechaActual, descripcion, 0);

				int filasn = bdn.AñadirNoticia(n);
				switch (filasn) {
				case 1:
					System.out.println("\nNoticia añadida");
					break;
				case 0:
					System.out.println("\nNoticia NO añadido");
					break;
				case -1:
					System.out.println("\nProblemas técnicos");

					break;

				}
				break;

			case 4:
				System.out.println("Introduce el nombre del usuario al que quieres controlar");
				String us = sLeer.nextLine();
				bdu.BuscarUsuario2(us);

				break;

			}
		} while (opc != 6);

	}

	private static void menuCliente() {

	}

	private static void menuControl(Usuarios us) throws TecnicException {

		BD_Usuarios bdu = new BD_Usuarios();
		Scanner sLeer = new Scanner(System.in);
		int opc = 0;

		do {
			System.out.println("\n\nBienvenido al controlador de Usuarios ");
			System.out.println("***************");
			System.out.println(" 1.Advertir usuario \n 2.Bloquear usuario \n 3. Eliminar usuario\n 4.Salir");
			opc = sLeer.nextInt();
			switch (opc) {
			case 1:
				System.out.println(
						"¿Quieres advertir al usuario " + us.getUsuario() + "/n S para decir si o N para decir no?");
				char opcion = sLeer.nextLine().charAt(0);

				if (opcion != 'S' || opcion != 'N') {
					System.out.println("Error al elegir la opcion");
					break;
				} else {
					if (opcion == 'S') {
						bdu.CambiarEstado1(us);
						System.out.println(
								"Se ha cambiado el estado del usuario " + us.getUsuario() + " a \"advertido\" ");
						break;
					} else
						System.out.println("No se ha cambiado el estado del usuario " + us.getUsuario());
					break;
				}

			case 2:
				System.out.println(
						"¿Quieres bloquear al usuario " + us.getUsuario() + "/n S para decir si o N para decir no?");
				opcion = sLeer.nextLine().charAt(0);

				if (opcion != 'S' || opcion != 'N') {
					System.out.println("Error al elegir la opcion");
					break;
				} else {
					if (opcion == 'S') {
						bdu.CambiarEstado2(us);
						System.out.println(
								"Se ha cambiado el estado del usuario " + us.getUsuario() + " a \"bloqueado\" ");
						break;
					} else
						System.out.println("No se ha cambiado el estado del usuario " + us.getUsuario());
				}
				break;

			case 3:
				System.out.println(
						"¿Quieres eliminar al usuario " + us.getUsuario() + "/n S para decir si o N para decir no?");
				opcion = sLeer.nextLine().charAt(0);

				if (opcion != 'S' || opcion != 'N') {
					System.out.println("Error al elegir la opcion");
					break;
				} else {
					if (opcion == 'S') {
						bdu.EliminarUsuario(us);
						System.out.println("Se ha eliminado al usuario " + us.getUsuario());
						break;
					} else
						System.out.println("No se ha cambiado el estado del usuario " + us.getUsuario());
				}
				break;

			}
		} while (opc != 4);

	}
}
