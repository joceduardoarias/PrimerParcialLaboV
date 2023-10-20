package Primer.parcial.Models;

public class Usuario {

    private String nombre;
    private String contraseña;
    private String tipoUsuario;

    // Constructor
    public Usuario(String nombre, String contraseña, String tipoUsuario) {
        this.nombre = nombre;
        this.contraseña = contraseña;
        this.tipoUsuario = tipoUsuario;
    }

    // Getter para el nombre
    public String getNombre() {
        return nombre;
    }

    // Setter para el nombre
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Getter para la contraseña
    public String getContraseña() {
        return contraseña;
    }

    // Setter para la contraseña
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    // Getter para el tipo de usuario
    public String getTipoUsuario() {
        return tipoUsuario;
    }

    // Setter para el tipo de usuario
    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nombre='" + nombre + '\'' +
                ", contraseña='" + contraseña + '\'' +
                ", tipoUsuario='" + tipoUsuario + '\'' +
                '}';
    }
}

