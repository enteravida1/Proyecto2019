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
import modelos.Comentarios;
import modelos.Foros;
import modelos.Guias;
import modelos.Guias;
import modelos.Noticias;
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

				
					Usuarios u = new Usuarios(user, pass1, "user", null);

					int filas = bdu.CrearUsuario(u);
					switch (filas) {
					case 1:
						System.out.println("\nUsuario añadido");
						break;
					case 0:
						System.out.println("\nNo añadido");
						break;
					case -1:
						System.out.println("\nProblemas técnicos");

						break;

					
				}
				break;
			case 2:
				sLeer.nextLine();
				System.out.println("Introduce tu usuario");
				user = sLeer.nextLine();

				System.out.println("Introduce tu contraseña");
				String pass = sLeer.nextLine();

				// System.out.println(bdu.BuscarUsuario(user, pass).toString());
				Usuarios u1 = bdu.BuscarUsuario(user, pass);
				if (u1 == null) {
					System.out.println("usuario o contraseña incorrectas");
				} else {
					System.out.println(u1.toString());
					if (u1.getTipo().equals("admin"))
						menuAdministrador(user);
					else
						menuCliente(user);
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
					" 1.Crear guía\n 2.Crear foro\n 3.Crear noticia\n 4.Controlar usuarios\n 5.Buscar foro, post, guia, noticia");
			opc = sLeer.nextInt();
			switch (opc) {
			case 1:
				sLeer.nextLine();
				System.out.println("Indica un titulo para la guia");
				String tituloG = sLeer.nextLine();

				System.out.println("Indica el desarrollador del titulo que vas a hablar");
				String desarrollador = sLeer.nextLine();

				System.out.println("Indica la plataforma para la que está hecho (playStation, Xbox, Pc...)");
				String plataforma = sLeer.nextLine();

				System.out.println("Escribe la guia");
				String desc = sLeer.nextLine();
				Guias g = new Guias(tituloG, fechaActual, user, desarrollador, plataforma, desc, 1);

				int filasg = bdg.AñadirGuia(g);
				switch (filasg) {
				case 1:
					System.out.println("\nGuia añadida");
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
				try {
				sLeer.nextLine();
				System.out.println("Elige un tipo : General\n Videojuegos\n Tecnologia ");
				String eligeTipo = sLeer.nextLine();

				System.out.println(bdti.BuscarTpos(eligeTipo).toString());

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
				//System.out.println(bdf.BuscarForo(tituloF).toString());
				//break;
				} catch (TecnicException e) {
					System.out.println("Error tecnico");
					break;
					}
				

			case 3:
				sLeer.nextLine();
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
				//System.out.println(bdn.BuscarNoticiaTitulo(tituloN).toString());
				break;

			case 4:
				sLeer.nextLine();
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
							Vector<Foros> foros = bdf.MostrarForo();
							for (int i = 0; i < foros.size(); i++) {
								System.out.println(
										"Titulo del tipo donde se encuentra el foro: " + foros.get(i).getTituloTipo());
								System.out.println("Autor del foro " + foros.get(i).getUser());
								System.out.println("Titulo del foro " + foros.get(i).getTituloForo());
								System.out.println("Fecha de creacion " + foros.get(i).getFecha());
								System.out.println("Número de temas que contiene el foro " + foros.get(i).getNtemas());
								System.out.println("Pequeña descripción " + foros.get(i).getDesc());
								System.out.println("*******************");
							}
							System.out.println("Indica el foro que quieres buscar");
							String foro = sLeer.nextLine();
							System.out.println(bdf.BuscarForo(foro).toString());

						} catch (TecnicException e) {
							System.out.println("Error tecnico");
							break;

						}
						break;
					case 2:
						try {
							Vector<Foros> foros = bdf.MostrarForo();
							for (int i = 0; i < foros.size(); i++) {
								System.out.println(
										"Titulo del tipo donde se encuentra el foro: " + foros.get(i).getTituloTipo());
								System.out.println("Autor del foro " + foros.get(i).getUser());
								System.out.println("Titulo del foro " + foros.get(i).getTituloForo());
								System.out.println("Fecha de creacion " + foros.get(i).getFecha());
								System.out.println("Número de temas que contiene el foro " + foros.get(i).getNtemas());
								System.out.println("Pequeña descripción " + foros.get(i).getDesc());
							}

							System.out.println("Indica el foro que quieres buscar");
							String foro = sLeer.nextLine();

							Vector<Temas> temas = bdte.MostrarTemas1(foro);
							for (int i = 0; i < temas.size(); i++) {
								System.out.println(
										"Titulo del foro donde se encuentra el foro: " + temas.get(i).getTitulo_foro());
								System.out.println("Autor del tema " + temas.get(i).getAutor());
								System.out.println("Titulo del tema " + temas.get(i).getTitulo_tema());
								System.out.println("Fecha de creacion " + temas.get(i).getFecha());
								System.out.println("Número de cometnarios que contiene el tema "
										+ temas.get(i).getNum_comentarios());
								System.out.println("Número de likes " + temas.get(i).getNum_likes());
								System.out.println("Contenido del tema " + temas.get(i).getDescripcion());
								System.out.println("*******************");
								Vector<Comentarios> comentarios = bdc.MostrarComentarios(temas.get(i).getTitulo_tema());

								for (int j = 0; j < comentarios.size(); j++) {
									System.out.println(
											"orden del comentario en el tema: " + comentarios.get(j).getOrden());
									System.out.println("fecha de creacion " + comentarios.get(j).getFecha());
									System.out.println("usuario creador: " + comentarios.get(j).getUser());
									System.out.println("contenido del comentario " + comentarios.get(j).getContenido());
									System.out.println("numero de likes: " + comentarios.get(j).getNlikes());
									System.out.println("********************");
									System.out.println("********************");

								}

								System.out.println(
										"Quieres hacer un comentario al tema? pon S si quieres y N si no quieres");
								char opcion = sLeer.nextLine().charAt(0);

								if (opcion == 'S') {

									System.out.println("Escribe el comentario");
									String coment = sLeer.nextLine();
									Comentarios ca = new Comentarios(temas.get(i).getTitulo_tema(), foro, 0, user,
											fechaActual, coment, 0);

									int filasc = bdc.CrearComentario(ca);
									switch (filasc) {
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

								}
								if (opcion == 'N') {
									System.out.println("no se ha hecho el comentario");
									break;
								}
								if (opcion != 'S' || opcion != 'N') {
									System.out.println("Error Tecnico");
									break;
								}

							}

						} catch (TecnicException e) {
							System.out.println("Error tecnico");
							break;
						}
						break;
					case 3:
						try {
							Vector<Guias> guias = bdg.MostrarGuias2();
							for (int i = 0; i < guias.size(); i++) {
								System.out.println("Titulo: " + guias.get(i).getTitulo());
								System.out.println("*****************");
								System.out.println("autor:" + guias.get(i).getAutor());
								System.out.println("fecha :" + guias.get(i).getFecha());
								System.out.println("desarrollador: " + guias.get(i).getDesarrollador());
								System.out.println("numero de Likes " + guias.get(i).getNum_likes());
								System.out.println("plataforma del juego: " + guias.get(i).getPlataforma());
								System.out.println("*******************");
								System.out.println(guias.get(i).getDescripcion());

							}
							System.out.println("Indica el titulo de la guia que quieres buscar");
							String foro = sLeer.nextLine();
							System.out.println(bdf.BuscarForo(foro).toString());
						} catch (TecnicException e) {
							System.out.println("Error tecnico");
							break;
						}
						break;
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
							break;

						}
						break;
					}
				} while (opc != 5);
				

			}
		} while (opc != 6);

	}

	private static void menuCliente(String user) throws TecnicException {
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
		int opc1 = 0;
		
		do {
			System.out.println(" 1.Crear post\n 2.buscar post\n 3.Buscar noticia\n 4.Buscar guía\n 5.Salir");
			opc1 = sLeer.nextInt();
			switch (opc1) {
			case 1:
				sLeer.nextLine();
				/*System.out.println("Escribe el titulo del tipo que quieres entrar: Tecnologia, Videojuegos o General ");
				String Tipo = sLeer.nextLine();
				*/

				try {
					Vector<Foros> foros = bdf.MostrarForo();
					for (int i = 0; i < foros.size(); i++) {
						System.out
								.println("Titulo del tipo donde se encuentra el foro: " + foros.get(i).getTituloTipo());
						System.out.println("Autor del foro " + foros.get(i).getUser());
						System.out.println("Titulo del foro " + foros.get(i).getTituloForo());
						System.out.println("Fecha de creacion " + foros.get(i).getFecha());
						System.out.println("Número de temas que contiene el foro " + foros.get(i).getNtemas());
						System.out.println("Pequeña descripción " + foros.get(i).getDesc());
						System.out.println("*******************");
					}
					System.out.println("Escribe el titulo del foro");
					String foro = sLeer.nextLine();
					//Foros f = bdf.BuscarForo(foro);
					//do {
						//System.out.println("El foro no existe, vuelva a introducir el nombre");
					//} while (f == null);

					System.out.println("Escribe un titulo para el post: ");
					String titulo_post = sLeer.nextLine();
					System.out.println("Pon una descripcion: ");
					String desc_post = sLeer.nextLine();

					Temas p = new Temas(1, 1, fechaactual, foro, titulo_post, user, desc_post);

					int filas = bdte.CrearTema(p);
					switch (filas) {
					case 1:
						System.out.println("\nPost Creado.");
						
						
					case -1:
						System.out.println("\nProblemas técnicos.");

						

					}

				} catch (TecnicException e) {
					System.out.println("Error tecnico");
					break;

				}

				break;

			case 2:
				try {
				Vector<Foros> foros = bdf.MostrarForo();
					for (int i = 0; i < foros.size(); i++) {
						System.out
								.println("Titulo del tipo donde se encuentra el foro: " + foros.get(i).getTituloTipo());
						System.out.println("Autor del foro " + foros.get(i).getUser());
						System.out.println("Titulo del foro " + foros.get(i).getTituloForo());
						System.out.println("Fecha de creacion " + foros.get(i).getFecha());
						System.out.println("Número de temas que contiene el foro " + foros.get(i).getNtemas());
						System.out.println("Pequeña descripción " + foros.get(i).getDesc());
						System.out.println("****************");
						
					}
					
					sLeer.nextLine();
					System.out.println("Indica el titulo foro que quieres buscar");
					String foro = sLeer.nextLine();
					

					Vector<Temas> temas = bdte.MostrarTemas1(foro);
					for (int i = 0; i < temas.size(); i++) {
						System.out.println(
								"Titulo del foro donde se encuentra el tema: " + temas.get(i).getTitulo_foro());
						System.out.println("Autor del tema " + temas.get(i).getAutor());
						System.out.println("Titulo del tema " + temas.get(i).getTitulo_tema());
						System.out.println("Fecha de creacion " + temas.get(i).getFecha());
						System.out.println(
								"Número de comentarios que contiene el tema " + temas.get(i).getNum_comentarios());
						System.out.println("Número de likes " + temas.get(i).getNum_likes());
						System.out.println("Contenido del tema " + temas.get(i).getDescripcion());
						System.out.println("*******************");
						Vector<Comentarios> comentarios = bdc.MostrarComentarios(temas.get(i).getTitulo_tema());

						for (int j = 0; j < comentarios.size(); j++) {
							System.out.println("orden del comentario en el tema: " + comentarios.get(j).getOrden());
							System.out.println("fecha de creacion " + comentarios.get(j).getFecha());
							System.out.println("usuario creador: " + comentarios.get(j).getUser());
							System.out.println("contenido del comentario " + comentarios.get(j).getContenido());
							System.out.println("numero de likes: " + comentarios.get(j).getNlikes());
							System.out.println("********************");
							System.out.println("********************");

						

						System.out.println("Quieres hacer un comentario al tema? pon S si quieres y N si no quieres");
						char opcion = sLeer.nextLine().charAt(0);

						if (opcion == 'S') {

							System.out.println("Escribe el comentario");
							String coment = sLeer.nextLine();
							Comentarios ca = new Comentarios(temas.get(i).getTitulo_tema(), foro, 1, user, fechaactual,coment, 1);

							int filasc = bdc.CrearComentario(ca);
							switch (filasc) {
							case 1:
								System.out.println("\nComentario añadido");
								break;
							case 0:
								System.out.println("\nComentario no añadida");
								break;
							case -1:
								System.out.println("\nProblemas técnicos");

								break;

							}
						

						}
						if (opcion == 'N') {
							System.out.println("no se ha hecho el comentario");
							break;
						}
						if (opcion != 'S' && opcion != 'N') {
							System.out.println("Error Tecnico");
							break;
						}
						}

					}

				} catch (TecnicException e) {
					System.out.println("Error tecnico");
					break;
				}
				break;
			case 3:
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
					System.out.println("Indica el titulo de la noticia que quieres buscar");
					String not = sLeer.nextLine();
					System.out.println(bdn.BuscarNoticiaTitulo(not).toString());
					break;
				} catch (TecnicException e) {
					System.out.println("Error tecnico");
					
				}
				break;
				
				
			case 4:
				try {
					Vector<Guias> guias = bdg.MostrarGuias2();
					for (int i = 0; i < guias.size(); i++) {
						System.out.println("Titulo: " + guias.get(i).getTitulo());
						System.out.println("autor:" + guias.get(i).getAutor());
						System.out.println("fecha :" + guias.get(i).getFecha());
						System.out.println("desarrollador: " + guias.get(i).getDesarrollador());
						System.out.println("numero de Likes " + guias.get(i).getNum_likes());
						System.out.println("plataforma del juego: " + guias.get(i).getPlataforma());
						System.out.println(guias.get(i).getDescripcion());

						System.out.println("******************");
					}
					
					
					
					sLeer.nextLine();
					System.out.println("Indica el titulo de la guia que quieres buscar");
					String tguia = sLeer.nextLine();
					System.out.println(bdg.BuscarGuiaTit(tguia).toString());
					break;
				} catch (TecnicException e) {
					System.out.println("Error tecnico");
				
				}
				break;

			}
			
		} while (opc1 != 5);

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
			sLeer.nextLine();
						System.out.println("Quieres hacer un comentario al tema? pon S si quieres y N si no quieres");
						char opcion = sLeer.nextLine().charAt(0);

				if (opcion != 'S' && opcion != 'N') {
					System.out.println("Error Tecnico");
					break;
				}
				
					if (opcion == 'S') {
						bdu.CambiarEstado1(us);
						System.out.println(
								"Se ha cambiado el estado del usuario " + us.getUsuario() + " a \"advertido\" ");
						break;
					} 
					if (opcion=='N') {
						System.out.println("No se ha cambiado el estado del usuario " + us.getUsuario());
					break;
					}
					break;

			case 2:
				sLeer.nextLine();
				System.out.println(
						"¿Quieres bloquear al usuario " + us.getUsuario() + "/n S para decir si o N para decir no?");
				opcion = sLeer.nextLine().charAt(0);

				if (opcion != 'S' && opcion != 'N') {
					System.out.println("Error Tecnico");
					break;
				}
				
					if (opcion == 'S') {
						bdu.CambiarEstado2(us);
						System.out.println(
								"Se ha cambiado el estado del usuario " + us.getUsuario() + " a \"bloqueado\" ");
						break;
					} if (opcion=='N') {
						System.out.println("No se ha cambiado el estado del usuario " + us.getUsuario());
						break;
				}
				break;

			case 3:
				sLeer.nextLine();
				System.out.println(
						"¿Quieres eliminar al usuario " + us.getUsuario() + "/n S para decir si o N para decir no?");
				opcion = sLeer.nextLine().charAt(0);

				if (opcion != 'S' && opcion != 'N') {
					System.out.println("Error Tecnico");
					break;
				}
				
					if (opcion == 'S') {
						bdu.EliminarUsuario(us);
						System.out.println("Se ha eliminado al usuario " + us.getUsuario());
						break;
					} 
					if (opcion == 'N') {
						System.out.println("No se ha cambiado el estado del usuario " + us.getUsuario());
						break;
				}
				break;

			}
		} while (opc != 4);

	}
}
