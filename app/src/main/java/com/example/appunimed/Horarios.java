package com.example.appunimed;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Horarios extends AppCompatActivity {
    private ArrayList<String> horarios;
    private RecyclerView rwHorarios;
    private TextView NombreMedico, EspecialidadEscogida;
    private String nombreDoctor, apellidoDoctor, especialidad, nombrePaciente, apellidoPaciente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_horarios);

        // Set up WindowInsets for edge-to-edge display
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Get data from Intent
        nombrePaciente = getIntent().getStringExtra("nombrePaciente");
        apellidoPaciente = getIntent().getStringExtra("apellidoPaciente");
        nombreDoctor = getIntent().getStringExtra("nombreDoctor");
        apellidoDoctor = getIntent().getStringExtra("apellidoDoctor");
        especialidad = getIntent().getStringExtra("especialidadNombre");
        horarios = (ArrayList<String>) getIntent().getSerializableExtra("horarios");

        // Initialize UI elements
        rwHorarios = findViewById(R.id.rwHorarios);
        NombreMedico = findViewById(R.id.tvNombreMedico);
        EspecialidadEscogida = findViewById(R.id.tvEspecialidadEscogida);

        // Set text views
        EspecialidadEscogida.setText(especialidad);
        NombreMedico.setText(nombreDoctor + " " + apellidoDoctor);

        // Set up RecyclerView
        rwHorarios.setLayoutManager(new LinearLayoutManager(this));
        HorariosAdapter adapter = new HorariosAdapter(horarios, horario -> {
            // Handle click event
            Intent it=new Intent(getApplicationContext(), Ficha.class);
            it.putExtra("nombreDoctor",nombreDoctor);
            it.putExtra("apellidoDoctor", apellidoDoctor);
            it.putExtra("nombrePaciente", nombrePaciente);
            it.putExtra("apellidoPaciente", apellidoPaciente);
            it.putExtra("especialidadNombre", especialidad);
            it.putExtra("horario",horario);
            startActivity(it);
        });
        rwHorarios.setAdapter(adapter);
    }
}