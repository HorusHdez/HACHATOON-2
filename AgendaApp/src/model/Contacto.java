package model;

public class Contacto {
    // Crear variables
    protected String nombre;
    protected String apellido;
    protected String telefono;


    // Metodo constructor, agrega excepcion para que no envien una opcion vacia
    public Contacto(String nombre, String apellido, String telefono) {
        if (nombre == null || nombre.isEmpty() || apellido == null || apellido.isEmpty()) {
            throw new IllegalArgumentException("Nombre y apellido no pueden estar vacíos.");
        }
        this.nombre = nombre.trim();
        this.apellido = apellido.trim();
        this.telefono = telefono;
    }

    // Getters y Setters

    public String getNombre() { return nombre; }
    public String getApellido() { return apellido; }
    public String getTelefono() { return telefono; }

    public void setTelefono(String nuevoTelefono) {
        this.telefono = nuevoTelefono;
    }

    // Override para comparacion de nombres iguales

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Contacto) {
            Contacto otro = (Contacto) obj;
            return nombre.equalsIgnoreCase(otro.nombre) &&
                    apellido.equalsIgnoreCase(otro.apellido);
        }
        return false;
    }

    // toString()

    @Override
    public String toString() {
        return nombre + " " + apellido + " - " + telefono;
    }
}