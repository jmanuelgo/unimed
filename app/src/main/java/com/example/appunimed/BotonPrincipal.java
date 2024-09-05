package com.example.appunimed;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class BotonPrincipal extends AppCompatActivity {
    Button datos;
    TextView nombreUsuario;
    String nombre, apellido;
    ArrayList<Especialidad> listaEspecialidades;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_boton_principal);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        nombreUsuario = findViewById(R.id.twNombre);
        datos = findViewById(R.id.btnDatos);

        nombre = getIntent().getStringExtra("nombre");
        apellido = getIntent().getStringExtra("apellido");
        nombreUsuario.setText(nombre + " " + apellido);

        // Initialize the data
        listaEspecialidades = DataManager.getEspecialidades();
    }

    public void VerEspecialidades(View v) {
        Intent especialidades = new Intent(getApplicationContext(), Especialidades.class);
        especialidades.putExtra("nombrePaciente", nombre);
        especialidades.putExtra("apellidoPaciente", apellido);
        especialidades.putExtra("especialidades", listaEspecialidades); // Pass the list of specialties
        startActivity(especialidades);
    }
}
