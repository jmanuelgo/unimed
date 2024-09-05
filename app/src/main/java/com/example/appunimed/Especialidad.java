package com.example.appunimed;

import java.io.Serializable;
import java.util.ArrayList;

public class Especialidad implements Serializable {
    String nombreEspecialidad;
    ArrayList<Doctor> doctor;
    private int logoResId;

    public Especialidad(String nombreEspecialidad, ArrayList<Doctor> doctor,int logoResId) {
        this.nombreEspecialidad = nombreEspecialidad;
        this.doctor = doctor;
        this.logoResId = logoResId;
    }

    public String getNombreEspecialidad() {
        return nombreEspecialidad;
    }

    public void setNombreEspecialidad(String nombreEspecialidad) {
        this.nombreEspecialidad = nombreEspecialidad;
    }

    public ArrayList<Doctor> getDoctor() {
        return doctor;
    }

    public void setDoctor(ArrayList<Doctor> doctor) {
        this.doctor = doctor;
    }
    public int getLogoResId() {
        return logoResId;
    }
}
