package principal;

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
			case 2:
				sLeer.nextLine();
				System.out.println("Introduce tu usuario");
				 user=sLeer.nextLine();
				
				System.out.println("Introduce tu contraseña");
				String pass=sLeer.nextLine();
				
				// System.out.println(bdu.BuscarUsuario(user, pass).toString());
				Usuarios u=bdu.BuscarUsuario(user, pass);
				if (u==null) {
					System.out.println("usuario o contraseña incorrectas");
				}
				System.out.println(u.toString());
				break;

			}

		} while (opc != 3);

	}

}
