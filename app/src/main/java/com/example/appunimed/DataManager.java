package com.example.appunimed;

import com.example.appunimed.Doctor;
import com.example.appunimed.Especialidad;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DataManager {

    public static ArrayList<Especialidad> getEspecialidades() {
        ArrayList<Especialidad> listaEspecialidades = new ArrayList<>();

        ArrayList<Doctor> doctoresCardiologia = new ArrayList<>();
        doctoresCardiologia.add(new Doctor("Carlos", "Hernandez", new ArrayList<>(List.of("9:00 - 12:00", "14:00 - 17:00"))));
        doctoresCardiologia.add(new Doctor("María", "López", new ArrayList<>(List.of("10:00 - 13:00", "15:00 - 18:00"))));
        doctoresCardiologia.add(new Doctor("Fernando", "Pérez", new ArrayList<>(List.of("8:00 - 11:00", "13:00 - 16:00"))));
        doctoresCardiologia.add(new Doctor("Laura", "Martínez", new ArrayList<>(List.of("11:00 - 14:00", "16:00 - 19:00"))));
        listaEspecialidades.add(new Especialidad("Cardiología", doctoresCardiologia));

        ArrayList<Doctor> doctoresPediatria = new ArrayList<>();
        doctoresPediatria.add(new Doctor("Ana", "Gómez", new ArrayList<>(List.of("10:00 - 13:00", "15:00 - 18:00"))));
        doctoresPediatria.add(new Doctor("Roberto", "Vega", new ArrayList<>(List.of("9:00 - 12:00", "14:00 - 17:00"))));
        doctoresPediatria.add(new Doctor("Isabel", "Soto", new ArrayList<>(List.of("8:00 - 11:00", "13:00 - 16:00"))));
        doctoresPediatria.add(new Doctor("Miguel", "Torres", new ArrayList<>(List.of("11:00 - 14:00", "16:00 - 19:00"))));
        listaEspecialidades.add(new Especialidad("Pediatría", doctoresPediatria));

        ArrayList<Doctor> doctoresGinecologia = new ArrayList<>();
        doctoresGinecologia.add(new Doctor("Laura", "Martínez", new ArrayList<>(List.of("8:00 - 11:00", "13:00 - 16:00"))));
        doctoresGinecologia.add(new Doctor("Claudia", "Ramírez", new ArrayList<>(List.of("9:00 - 12:00", "14:00 - 17:00"))));
        doctoresGinecologia.add(new Doctor("Esther", "Cruz", new ArrayList<>(List.of("10:00 - 13:00", "15:00 - 18:00"))));
        doctoresGinecologia.add(new Doctor("Mónica", "García", new ArrayList<>(List.of("11:00 - 14:00", "16:00 - 19:00"))));
        listaEspecialidades.add(new Especialidad("Ginecología", doctoresGinecologia));

        ArrayList<Doctor> doctoresDermatologia = new ArrayList<>();
        doctoresDermatologia.add(new Doctor("Luis", "Ramírez", new ArrayList<>(List.of("9:00 - 12:00", "14:00 - 17:00"))));
        doctoresDermatologia.add(new Doctor("Ana", "Jaramillo", new ArrayList<>(List.of("10:00 - 13:00", "15:00 - 18:00"))));
        doctoresDermatologia.add(new Doctor("Jorge", "Gómez", new ArrayList<>(List.of("8:00 - 11:00", "13:00 - 16:00"))));
        doctoresDermatologia.add(new Doctor("Verónica", "Castro", new ArrayList<>(List.of("11:00 - 14:00", "16:00 - 19:00"))));
        listaEspecialidades.add(new Especialidad("Dermatología", doctoresDermatologia));

        ArrayList<Doctor> doctoresNeumologia = new ArrayList<>();
        doctoresNeumologia.add(new Doctor("Marta", "Sánchez", new ArrayList<>(List.of("10:00 - 13:00", "15:00 - 18:00"))));
        doctoresNeumologia.add(new Doctor("Ricardo", "Hernández", new ArrayList<>(List.of("9:00 - 12:00", "14:00 - 17:00"))));
        doctoresNeumologia.add(new Doctor("Sofía", "Luna", new ArrayList<>(List.of("8:00 - 11:00", "13:00 - 16:00"))));
        doctoresNeumologia.add(new Doctor("Daniela", "Vega", new ArrayList<>(List.of("11:00 - 14:00", "16:00 - 19:00"))));
        listaEspecialidades.add(new Especialidad("Neumología", doctoresNeumologia));

        return listaEspecialidades;
    }
}