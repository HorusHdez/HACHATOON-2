package model;

public class ContactoPersonal extends Contacto {
    private String cumpleaños;

    public ContactoPersonal(String nombre, String apellido, String telefono, String cumpleaños) {
        super(nombre, apellido, telefono);
        this.cumpleaños = cumpleaños;
    }

    @Override
    public String toString() {
        return super.toString() + " (Cumpleaños: " + cumpleaños + ")";
    }
}
