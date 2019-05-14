package principal;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.Vector;

import bbdd.BD_Comentarios;
import bbdd.BD_Conector;
import bbdd.BD_Foros;
import bbdd.BD_Guias;
import bbdd.BD_Noticias;
import bbdd.BD_Temas;
import bbdd.BD_Tipos;
import bbdd.BD_Usuarios;
import exceptions.TecnicException;
import modelos.Guias;
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

				Guias f = new Guias(eligeTipo, user, tituloF, fechaActual, 0, descF);

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
				Usuarios u = bdu.BuscarUsuario2(us);
				menuControl(u);
				break;

			case 5:
				System.out.println("Indica lo que quieres buscar:");
				System.out.println("1.Foro\n 2.Tema\n 3.Guia\n 4.Noticia\n 5.Salir");
				int opc2 = sLeer.nextInt();
				do {
					switch (opc2) {
					case 1:
						try {
							System.out.println(bdf.MostrarForo());
							Vector<Guias> foros = bdf.MostrarForo();
							for (int i = 0; i < foros.size(); i++) {
								System.out.println(foros.get(i));
							}
							System.out.println("Indica el foro que quieres buscar");
							String foro = sLeer.nextLine();
							System.out.println(bdf.BuscarForo(foro));
						} catch (TecnicException e) {
							System.out.println("Error tecnico");

						}
						case2: try {
							System.out.println(bdf.MostrarForo());
							Vector<Guias> foros = bdf.MostrarForo();
							for (int i = 0; i < foros.size(); i++) {
								System.out.println(foros.get(i));
							}
							System.out.println("Indica el foro que quieres buscar");
							String foro = sLeer.nextLine();
							System.out.println(bdf.BuscarForo(foro));
						} catch (TecnicException e) {
							System.out.println("Error tecnico");

						}
					case 3:
						try {
							Vector<Guias> guias = bdg.MostrarGuias2();
							for (int i = 0; i < guias.size(); i++) {
								System.out.println("Titulo: " + guias.get(i).getTitulo());
								System.out.println("*****************");
								System.out.println("autor:"+ guias.get(i).getAutor());
								System.out.println("fecha :" +guias.get(i).getFecha());
								System.out.println("desarrollador: "+ guias.get(i).getDesarrollador());
								System.out.println("numero de Likes " + guias.get(i).getNum_likes());
								System.out.println("plataforma del juego: " + guias.get(i).getPlataforma());
								System.out.println("*******************");
								System.out.println(guias.get(i).getDescripcion());
								
							}
							System.out.println("Indica el titulo de la guiaque quieres buscar");
							String foro = sLeer.nextLine();
							System.out.println(bdf.BuscarForo(foro).toString());
						} catch (TecnicException e) {
							System.out.println("Error tecnico");

						}
					case 4:
						try {
							Vector<Noticias> noticias = bdn.MostrarNoticias2();
							for (int i = 0; i < noticias.size(); i++) {
								System.out.println("autor:" + noticias.get(i).getAutor());
								System.out.println("descripcion :" + noticias.get(i).getDescripcion());
								System.out.println("likes :" + noticias.get(i).getNumlikes());
								System.out.println("titulo :" + noticias.get(i).getTitulo());
								System.out.println("fecha de creacion:" + noticias.get(i).getFecha());
								System.out.println("******************");
							}
							sLeer.nextLine();
							System.out.println("Indica el autor de la noticia que quieres buscar");
							String not = sLeer.nextLine();
							System.out.println(bdn.BuscarNoticiaUsuario(not).toString());
						} catch (TecnicException e) {
							System.out.println("Error tecnico");

						}
					}
				} while (opc != 5);
				break;

			}
		} while (opc != 6);

	}

	private static void menuCliente() {
		LocalDate fechaactual = LocalDate.now();
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
			Guias f = bdf.BuscarForo(Foro);

			System.out.println("Escribe un titulo para el post: ");
			String titulo_post = sLeer.nextLine();
			System.out.println("Pon una descripcion: ");
			String desc_post = sLeer.nextLine();

			Temas p = new Temas(0, 0, fechaactual, Foro, titulo_post, user, desc_post);

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
			String not = sLeer.nextLine();
			System.out.println(bdn.BuscarNoticiaTitulo(not));

			break;
		case 4:
			System.out.println("Introduce la guia que quieras buscar");
			String gui = sLeer.nextLine();
			System.out.println(bdg.BuscarGuiaTit(gui));

			break;

		}

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
