/****************************************************
Clase para testear

Name: Andrade Gonzalez Paulo Cesar
Fecha: 20/09/2016
Nota: El metodo next() captura un string hasta encontrar
	un espacio, en cambio nextLine() captura toda el string
	de la linea, solo hay un problema, cuando se usa nextInt()
	y seguido se usa nextLine(), hay que poner dos veces este
	ultimo, el primero servira para vaciar el buffer de entrada.
****************************************************/

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.text.SimpleDateFormat;

public class TestSeleccion
{
	// Creamos una instancia de la clase Entrenador
	public static Entrenador e = new Entrenador();
	// Creamos un array list de tipo Persona
	public static ArrayList<Entrenador> lista = new ArrayList<Entrenador>();

	public static void main(String[] args)
	{
		int opcion = 0; // Opciones para el menu
		Scanner lector = new Scanner(System.in); // Instancia para escaner

		do{
			// Menu
			System.out.println("\n*********");
			System.out.println("SELECCION");
			System.out.println("*********\n");
			System.out.println("1.- AGREGAR ENTRENADOR");
			System.out.println("2.- MOSTRAR ENTRENADORES");
			System.out.println("0.- SALIR");

			// Elegimos la opcion
			System.out.print("Opcion: ");
			opcion = lector.nextInt();

			// Seleccionamos la opcion
			switch(opcion){
				case 0:
					System.out.println("Fin del programa");
					break;
				case 1:
					// Opcion - Agregar entrenador

					// Ingresamos los datos del entrenador
					System.out.print("\nNombre: ");
					lector.nextLine(); // Limpiamos el buffer
					e.setNombre(lector.nextLine());
					System.out.print("Domicilio: ");
					e.setDomicilio(lector.nextLine());
					System.out.print("Telefono: ");
					e.setTelefono(lector.next());
					// Como leer la fecha de nacimiento
					lector.nextLine(); // Limpiamos el buffer
					e.setFechaNacimiento(readDate());
					System.out.print("Historial: ");
					e.setHistorial(lector.nextLine());
					System.out.print("Años de experiencia: ");
					// Usamos parseInt para evitar errores de ingreso
					e.setAniosExperiencia(Integer.parseInt(lector.next()));
					System.out.print("Especialidad: ");
					lector.nextLine(); // Limpiamos el buffer
					e.setEspecialidad(lector.nextLine());

					// Agregamos al array list
					lista.add(e);
					break;
				case 2:
					// Mostrar entrenadores
					int count = 1; // Contador

					// Verificamos si el arrayList esta vacio
					if(lista.isEmpty()){
						System.out.println("\nNo hay entrenadores registrados");
					} else {
						// Recorremos el ArrayList
						for(Entrenador temp: lista){
							// Mostramos los datos
							System.out.println("\nEntrenador " + count + ":");
							System.out.println("=============\n");
							System.out.println("Nombre: " + temp.getNombre());
							System.out.println("Domicilio: " + temp.getDomicilio());
							System.out.println("Telefono: " + temp.getTelefono());
							System.out.println("Fecha de nacimiento: " + formatDate(temp.getFechaNacimiento()));
							System.out.println("Historial: " + temp.getHistorial());
							System.out.println("Anios de experiencia: " + temp.getAniosExperiencia());
							System.out.println("Especialidad: " + temp.getEspecialidad());
							System.out.println(temp.concentrarse());
							temp.viajar();
							temp.dirigirEntrenamiento();
							System.out.println(temp.dirigirPartido());

							count++; // Aumentamos el contador
						}
					}

					break;
			}
		} while(opcion != 0);
	}
	// Método para darle formato a la fecha
	public static String formatDate(Date fecha)
	{
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy"); // Creamos un formato para la fecha

		// Retornamos la fecha en un string
		return df.format(fecha);
	}
	// Método para leer la fecha
	public static Date readDate ()
    {
    	Scanner lector = new Scanner(System.in); // Instanciamos un lector

        System.out.println("Introduzca su fecha de nacimiento [dd/mm/yyyy]");
        String fecha = lector.nextLine(); // Capturamos la fecha
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy"); // Creamos un formato para la fecha
        Date testDate = null;

        // Convertimos el string en tipo Date
        // Nota: Para usar el metodo parse() hay que hacerlo utilizando excepciones
        try {
            testDate = df.parse(fecha);
        } catch (Exception e){
        	// Si es incorrecto volvemos a pedir la fecha
        	System.out.println("Formato incorrecto, ingrese de nuevo:");
        	return readDate();
        }

    	// Si es correcto la retornamos
        return testDate;

    }
}