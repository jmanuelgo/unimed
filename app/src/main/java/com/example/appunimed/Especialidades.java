package com.example.appunimed;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.io.Serializable;
import java.util.ArrayList;

public class Especialidades extends AppCompatActivity {

    private ArrayList<Especialidad> listaEspecialidades;
    private RecyclerView recyclerViewEspecialidades;
    private String nombrePaciente, apellidoPaciente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_especialidades);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Get data from the Intent
        listaEspecialidades = (ArrayList<Especialidad>) getIntent().getSerializableExtra("especialidades");
        nombrePaciente = getIntent().getStringExtra("nombrePaciente");
        apellidoPaciente = getIntent().getStringExtra("apellidoPaciente");

        recyclerViewEspecialidades = findViewById(R.id.rwEspecialidades);
        recyclerViewEspecialidades.setLayoutManager(new LinearLayoutManager(this));

        // Create the adapter with the click listener
        EspecialidadAdapter adapter = new EspecialidadAdapter(listaEspecialidades, especialidad -> {
            // Acción al hacer clic en una especialidad
            Intent it = new Intent(getApplicationContext(), Doctores.class);
            it.putExtra("nombrePaciente", nombrePaciente);
            it.putExtra("apellidoPaciente", apellidoPaciente);
            it.putExtra("especialidadNombre", especialidad.getNombreEspecialidad());
            it.putExtra("doctores", (Serializable) especialidad.getDoctor()); // Asegúrate de que la lista de doctores sea serializable
            startActivity(it);
        });

        recyclerViewEspecialidades.setAdapter(adapter);

        recyclerViewEspecialidades.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            @Override
            public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
                return false;
            }

            @Override
            public void onTouchEvent(RecyclerView rv, MotionEvent e) {
                // This method is no longer needed because we handle clicks in the adapter
            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
                // No implementation needed
            }
        });
    }
}