package com.example.alan.proyecto;

public class usuarioModelo {

    private String nombre, apellidos, telefono, email, estado;
    private int imgusuario;

    public usuarioModelo() {
    }

    public usuarioModelo(String nombre, String apellidos, String telefono, String email, String estado, int imgusuario) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.email = email;
        this.estado = estado;
        this.imgusuario = imgusuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getImgusuario() {
        return imgusuario;
    }

    public void setImgusuario(int imgusuario) {
        this.imgusuario = imgusuario;
    }
}
