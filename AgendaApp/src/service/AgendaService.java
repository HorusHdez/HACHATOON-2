package service;

import model.Contacto;
import java.util.*;

public class AgendaService {
    //Se crea una variable de instancia de tipo List y una variable de tipo int "capacidad"
    private List<Contacto> contactos;
    private int capacidad;

    //Se crea un metodo que tiene la funcion de asignar un valor a la variable capacidad
    public AgendaService() {
        this(10);
    }
    //Se crea un constructor que contiene las variables de instancia y las inicializa
    public AgendaService(int capacidad) {
        this.capacidad = capacidad;
        this.contactos = new ArrayList<>();
    }
    //Se crea metodo para añadir contacto que recibe como parametro un objeto de tipo Contacto
    //Llama a los metodos agendaLlena, existeContacto si regresan false entonces añade un contacto al arrayList<>
    public boolean añadirContacto(Contacto c) {
        if (agendaLlena()) {
            System.out.println("La agenda ya está llena.");
            return false;
        }
        if (existeContacto(c)) {
            System.out.println("El contacto ya existe.");
            return false;
        }
        contactos.add(c);
        System.out.println("Contacto añadido: " + c);
        return true;
    }
    //Metodo para buscar si un contacto ya existe, devuelve true si lo encuentra o false si no lo encuentra
    public boolean existeContacto(Contacto c) {
        return contactos.contains(c);
    }
    //Se crea metodo para mostrar en pantalla los contactos guardados, si contactos esta vacio, imprime "la agenda esta vacia"
    //Si no está vacia, entonces los ordena y los muestra en pantalla
    public void listarContactos() {
        if (contactos.isEmpty()) {
            System.out.println("La agenda está vacía.");
            return;
        }
        contactos.stream()
                .sorted(Comparator.comparing(Contacto::getNombre)
                        .thenComparing(Contacto::getApellido))
                .forEach(System.out::println);
    }
    //Se crea metodo para buscar contactos, En caso de que tanto Nombre como apellido sean iguales, muestra el
    //telefono en pantala, en caso contrario devuelve el mensaje "Contacto no encontrado"
    public void buscaContacto(String nombre, String apellido) {
        for (Contacto c : contactos) {
            if (c.getNombre().equalsIgnoreCase(nombre) &&
                    c.getApellido().equalsIgnoreCase(apellido)) {
                System.out.println("Teléfono: " + c.getTelefono());
                return;
            }
        }
        System.out.println("Contacto no encontrado.");
    }
    //Metodo para eliminar contacto recibe como parametro un objeto de tipo Contacto, con remove eliminamos ese contacto
    public void eliminarContacto(Contacto c) {
        if (contactos.remove(c)) {
            System.out.println("Contacto eliminado: " + c);
        } else {
            System.out.println("No se encontró el contacto para eliminar.");
        }
    }
    //Podemos modificar un telefono ya registrado con este metodo, busca y compara el nombre y apellido, si lo encuentra, se le
    //puede asignar un nuevo numero
    public void modificarTelefono(String nombre, String apellido, String nuevoTelefono) {
        for (Contacto c : contactos) {
            if (c.getNombre().equalsIgnoreCase(nombre) &&
                    c.getApellido().equalsIgnoreCase(apellido)) {
                c.setTelefono(nuevoTelefono);
                System.out.println("Teléfono actualizado: " + c);
                return;
            }
        }
        System.out.println("Contacto no encontrado.");
    }
//Se crea metodo agendaLlena() retorna true si el tamaño de nuestra ArrayList es mayor o igual a la variable de instancia capacidad
    public boolean agendaLlena() {
        return contactos.size() >= capacidad;
    }
//Se crea metodo espacioLibres, que retorna la diferencia entre la variable de instancia capacidad, ya definida y el tamaño de nuestra ArrayList
    public int espacioLibres() {
        return capacidad - contactos.size();
    }
}