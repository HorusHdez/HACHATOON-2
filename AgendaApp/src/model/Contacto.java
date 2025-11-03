package model;

public class Contacto {
    protected String nombre;
    protected String apellido;
    protected String telefono;

    public Contacto(String nombre, String apellido, String telefono) {
        if (nombre == null || nombre.isEmpty() || apellido == null || apellido.isEmpty()) {
            throw new IllegalArgumentException("Nombre y apellido no pueden estar vacíos.");
        }
        this.nombre = nombre.trim();
        this.apellido = apellido.trim();
        this.telefono = telefono;
    }

    public String getNombre() { return nombre; }
    public String getApellido() { return apellido; }
    public String getTelefono() { return telefono; }

    public void setTelefono(String nuevoTelefono) {
        this.telefono = nuevoTelefono;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Contacto) {
            Contacto otro = (Contacto) obj;
            return nombre.equalsIgnoreCase(otro.nombre) &&
                    apellido.equalsIgnoreCase(otro.apellido);
        }
        return false;
    }

    @Override
    public String toString() {
        return nombre + " " + apellido + " - " + telefono;
    }
}