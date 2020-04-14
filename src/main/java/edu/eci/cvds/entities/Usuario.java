package edu.eci.cvds.entities;

public class Usuario{
    private String nombre;
    private String correo;
    private String contraseña;
    private Rol rol;
    private Estado estado;

    public Usuario(){}

    public Usuario(String nombre, String correo, String contraseña, Rol rol, Estado estado){
        this.nombre = nombre;
        this.correo = correo;
        this.contraseña = contraseña;
        this.rol = rol;
        this.estado = estado;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public Rol getRol() {
        return rol;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nombre='" + nombre + '\'' +
                ", correo='" + correo + '\'' +
                ", contraseña='" + contraseña + '\'' +
                ", rol='" + rol.name() + '\'' +
                ", estado='" + estado.name() + '\'' +
                '}';
    }
}
