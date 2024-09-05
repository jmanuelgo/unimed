package com.example.appunimed;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Ficha extends AppCompatActivity {
    private TextView ficha;
    private String nombrePaciente, apellidoPaciente, nombreDoctor, apellidoDoctor, especialidadNombre, horario, datosPaciente, datosDoctor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ficha);

        // Set up WindowInsets for edge-to-edge display
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Initialize views
        ficha = findViewById(R.id.twFicha); // Make sure this ID matches your layout

        // Retrieve data from Intent
        nombrePaciente = getIntent().getStringExtra("nombrePaciente");
        apellidoPaciente = getIntent().getStringExtra("apellidoPaciente");
        datosPaciente = nombrePaciente + " " + apellidoPaciente;
        nombreDoctor = getIntent().getStringExtra("nombreDoctor");
        apellidoDoctor = getIntent().getStringExtra("apellidoDoctor");
        datosDoctor = nombreDoctor + " " + apellidoDoctor;
        especialidadNombre = getIntent().getStringExtra("especialidadNombre");
        horario = getIntent().getStringExtra("horario");

        // Set the text for the TextView
        ficha.setText("Nombre y Apellido:\n" + datosPaciente +
                "\nDoctor:\n" + datosDoctor +
                "\nEspecialidad:\n" + especialidadNombre +
                "\nHorario:\n" + horario);
    }
}