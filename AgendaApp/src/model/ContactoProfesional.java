package model;

public class ContactoProfesional extends Contacto {
    private String empresa;

    public ContactoProfesional(String nombre, String apellido, String telefono, String empresa) {
        super(nombre, apellido, telefono);
        this.empresa = empresa;
    }

    @Override
    public String toString() {
        return super.toString() + " (Empresa: " + empresa + ")";
    }
}
