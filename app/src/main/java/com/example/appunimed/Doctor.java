package com.example.appunimed;

import java.io.Serializable;
import java.util.ArrayList;

public class Doctor implements Serializable {
    String nombres;
    String apellidos;
    ArrayList<String> horarios;

    public Doctor(String nombres, String apellidos, ArrayList<String> horarios) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.horarios = horarios;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public ArrayList<String> getHorarios() {
        return horarios;
    }

    public void setHorarios(ArrayList<String> horarios) {
        this.horarios = horarios;
    }
}
