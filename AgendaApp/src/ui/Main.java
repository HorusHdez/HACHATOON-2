package ui; //Paquete que contiene la interfaz del usuario

import model.*;
import service.AgendaService;
import java.util.Scanner; // Importación de clases del modelo y servicio


public class Main {
    public static void main(String[] args) {
        AgendaService agenda = new AgendaService(); //Se crea una instaqcia del servicio de agenda
        Scanner sc = new Scanner(System.in); //Se crea un objeto Scanner para leer entrada del usuario
        int opcion; //Variable para almacenar la opción seleccionada por el usuario

        //Bucle principal del menú que se repite hasta que el usuario elija salir

        do {
            //Se muestra el menú de opciones
            System.out.println("\n--- MENÚ AGENDA ---");
            System.out.println("1. Añadir contacto");
            System.out.println("2. Listar contactos");
            System.out.println("3. Buscar contacto");
            System.out.println("4. Eliminar contacto");
            System.out.println("5. Modificar teléfono");
            System.out.println("6. Ver si agenda está llena");
            System.out.println("7. Ver espacios libres");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            opcion = sc.nextInt();
            sc.nextLine();


            switch (opcion) { //Se ejecuta la acción correspondiente según la opción seleccionada
                case 1:
                    //Añadir un nuevo contacto
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Apellido: ");
                    String apellido = sc.nextLine();
                    System.out.print("Teléfono: ");
                    String telefono = sc.nextLine();
                    Contacto nuevo = new Contacto(nombre, apellido, telefono); //Se crea el objeto Contacto y se añade a la agenda
                    agenda.añadirContacto(nuevo);
                    break;
                case 2:
                    agenda.listarContactos(); //Listar todos los contactos almacenados
                    break;
                case 3:
                    // Buscar un contacto por nombre y apellido
                    System.out.print("Nombre: ");
                    nombre = sc.nextLine();
                    System.out.print("Apellido: ");
                    apellido = sc.nextLine();
                    agenda.buscaContacto(nombre, apellido);
                    break;
                case 4:
                    // Eliminar un contacto por nombre y apellido
                    System.out.print("Nombre: ");
                    nombre = sc.nextLine();
                    System.out.print("Apellido: ");
                    apellido = sc.nextLine();
                    agenda.eliminarContacto(new Contacto(nombre, apellido, ""));
                    break;
                case 5:
                    // Modificar el teléfono de un contacto existente
                    System.out.print("Nombre: ");
                    nombre = sc.nextLine();
                    System.out.print("Apellido: ");
                    apellido = sc.nextLine();
                    System.out.print("Nuevo teléfono: ");
                    telefono = sc.nextLine();
                    agenda.modificarTelefono(nombre, apellido, telefono);
                    break;
                case 6:
                    // Verificar si la agenda está llena
                    System.out.println(agenda.agendaLlena() ? "La agenda está llena." : "Hay espacio disponible.");
                    break;
                case 7:
                    // Mostrar cuántos espacios libres quedan en la agenda
                    System.out.println("Espacios libres: " + agenda.espacioLibres());
                    break;
                case 0:
                    // Salir del programa
                    System.out.println("Saliendo...");
                    break;
                default:
                    // Opción inválida

                    System.out.println("Opción inválida.");
            }
        } while (opcion != 0); // El bucle se repite mientras la opción no sea salir
    }
}