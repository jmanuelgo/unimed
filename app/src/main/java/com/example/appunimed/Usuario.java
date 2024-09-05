package com.example.appunimed;

import java.io.Serializable;

public class Usuario implements Serializable {
    private String nombres;
    private String apellidos;
    private String codigo;
    private String usuario;
    private String Contraseña;
    private String direccion;

    public Usuario(String nombres, String apellidos, String codigo, String usuario, String contraseña, String direccion) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.codigo = codigo;
        this.usuario = usuario;
        Contraseña = contraseña;
        this.direccion = direccion;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return Contraseña;
    }

    public void setContraseña(String contraseña) {
        Contraseña = contraseña;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
