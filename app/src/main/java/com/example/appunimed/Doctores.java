package com.example.appunimed;

import android.content.Intent;
import android.os.Bundle;
import android.view.GestureDetector;
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

public class Doctores extends AppCompatActivity {

    private ArrayList<Doctor> listaDoctores;
    private RecyclerView recyclerViewDoctores;
    String especialidadNombre,nombrePaciente,apellidoPaciente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_doctores);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Intent intent = getIntent();
        nombrePaciente = intent.getStringExtra("nombrePaciente");
        apellidoPaciente = intent.getStringExtra("apellidoPaciente");
        especialidadNombre = intent.getStringExtra("especialidadNombre");
        listaDoctores = (ArrayList<Doctor>) intent.getSerializableExtra("doctores");

        recyclerViewDoctores = findViewById(R.id.rwDoctores);
        recyclerViewDoctores.setLayoutManager(new LinearLayoutManager(this));
        DoctoresAdapter adapter = new DoctoresAdapter(listaDoctores,doctor-> {
            // Acción al hacer clic en un doctor
            Intent it = new Intent(getApplicationContext(), Horarios.class); // Cambia Horarios.class a la actividad correspondiente
            it.putExtra("nombreDoctor", doctor.getNombres());
            it.putExtra("apellidoDoctor", doctor.getApellidos());
            it.putExtra("nombrePaciente", nombrePaciente);
            it.putExtra("apellidoPaciente", apellidoPaciente);
            it.putExtra("especialidadNombre", especialidadNombre);
            it.putExtra("horarios", (Serializable) doctor.getHorarios()); // Asegúrate de que los horarios sean serializables
            startActivity(it);
        });

        recyclerViewDoctores.setAdapter(adapter);
    }
}
