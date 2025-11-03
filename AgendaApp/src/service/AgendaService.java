package service;

import model.Contacto;
import java.util.*;

public class AgendaService {
    private List<Contacto> contactos;
    private int capacidad;

    public AgendaService() {
        this(10);
    }

    public AgendaService(int capacidad) {
        this.capacidad = capacidad;
        this.contactos = new ArrayList<>();
    }

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

    public boolean existeContacto(Contacto c) {
        return contactos.contains(c);
    }

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

    public void eliminarContacto(Contacto c) {
        if (contactos.remove(c)) {
            System.out.println("Contacto eliminado: " + c);
        } else {
            System.out.println("No se encontró el contacto para eliminar.");
        }
    }

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

    public boolean agendaLlena() {
        return contactos.size() >= capacidad;
    }

    public int espacioLibres() {
        return capacidad - contactos.size();
    }
}