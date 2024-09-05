package com.example.appunimed;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.Serializable;
import java.util.ArrayList;

public class CrearUsuario extends AppCompatActivity {
    EditText nombre, apellido, codigo, nuevousuario, nuevacontraseña, direccion;
    Button crearUsuario;
    ArrayList<Usuario> usuarios = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_crear_usuario);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        nombre = findViewById(R.id.txtNombre);
        apellido = findViewById(R.id.txtApellidos);
        codigo = findViewById(R.id.txtAsegurado);
        nuevousuario = findViewById(R.id.txtUsuarioNuevo);
        nuevacontraseña = findViewById(R.id.txtContraseñaNueva);
        direccion = findViewById(R.id.txtDireccion);
        crearUsuario = findViewById(R.id.btnCrearNuevoUsuario);
        usuarios = (ArrayList<Usuario>) getIntent().getSerializableExtra("ListUsuarios");

        // Agregar TextWatcher para generar el nombre de usuario automáticamente
        TextWatcher usuarioTextWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // No se necesita hacer nada aquí
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // Generar el nombre de usuario cuando el nombre o apellido cambien
                generarNombreUsuario();
            }

            @Override
            public void afterTextChanged(Editable s) {
                // No se necesita hacer nada aquí
            }
        };

        // Añadir el TextWatcher a los campos de nombre y apellido
        nombre.addTextChangedListener(usuarioTextWatcher);
        apellido.addTextChangedListener(usuarioTextWatcher);

        // Inicializar el campo de contraseña y el botón de alternar visibilidad
        EditText txtContraseñaNueva = findViewById(R.id.txtContraseñaNueva);
        ImageButton btnTogglePasswordVisibility = findViewById(R.id.btnTogglePasswordVisibility);

        // Configurar la alternancia de visibilidad de la contraseña
        btnTogglePasswordVisibility.setOnClickListener(v -> {
            if (txtContraseñaNueva.getTransformationMethod() instanceof PasswordTransformationMethod) {
                // Si la contraseña está oculta, mostrarla
                txtContraseñaNueva.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                btnTogglePasswordVisibility.setImageResource(R.drawable.ic_eye); // Cambiar icono a "visible"
            } else {
                // Si la contraseña está visible, ocultarla
                txtContraseñaNueva.setTransformationMethod(PasswordTransformationMethod.getInstance());
                btnTogglePasswordVisibility.setImageResource(R.drawable.ic_eye_closed); // Cambiar icono a "ocultar"
            }

            // Mover el cursor al final del texto
            txtContraseñaNueva.setSelection(txtContraseñaNueva.length());
        });
    }

    // Método para generar el nombre de usuario
    private void generarNombreUsuario() {
        String nombreText = nombre.getText().toString();
        String apellidoText = apellido.getText().toString();
        String nombreUsuario = "";

        if (nombreText.length() >= 3 && apellidoText.length() >= 3) {
            nombreUsuario = nombreText.substring(0, 3) + apellidoText.substring(0, 3);
        } else if (nombreText.length() >= 3) {
            nombreUsuario = nombreText.substring(0, 3);
        } else if (apellidoText.length() >= 3) {
            nombreUsuario = apellidoText.substring(0, 3);
        } else {
            nombreUsuario = nombreText + apellidoText;
        }

        // Asignar el nombre de usuario generado al EditText de Usuario Nuevo
        nuevousuario.setText(nombreUsuario);
    }

    public void CrearNuevoUsuario(View v) {
        Usuario us = new Usuario(
                nombre.getText().toString(),
                apellido.getText().toString(),
                codigo.getText().toString(),
                nuevousuario.getText().toString(),
                nuevacontraseña.getText().toString(),
                direccion.getText().toString()
        );

        usuarios.add(us);

        Intent it = new Intent(getApplicationContext(), MainActivity.class);
        it.putExtra("ListaNueva", (Serializable) usuarios);
        startActivity(it);
    }
}
