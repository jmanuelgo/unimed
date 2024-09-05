package com.example.appunimed;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText usuario, contraseña;
    Button crearUsuario, ingresar;
    ImageButton showPasswordButton;
    boolean isPasswordVisible = false;
    public ArrayList<Usuario> usuarios = new ArrayList<>();
    String nombreSeleccionado, apellidoSelecionado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Intent intent = getIntent();
        if (intent != null && intent.getSerializableExtra("ListaNueva") != null) {
            usuarios = (ArrayList<Usuario>) intent.getSerializableExtra("ListaNueva");
        } else {
            // Si no hay datos, inicializar con valores predeterminados
            usuarios.add(new Usuario("Juan", "Pérez", "001", "jperez", "password123", "Calle Falsa 123"));
            usuarios.add(new Usuario("Ana", "López", "002", "alopez", "pass456", "Avenida Siempre Viva 456"));
            usuarios.add(new Usuario("Carlos", "Gómez", "003", "123", "123", "Boulevard de los Sueños 789"));
        }

        // Inicializar vistas
        usuario = findViewById(R.id.txtUsuario);
        contraseña = findViewById(R.id.txtContraseña);
        crearUsuario = findViewById(R.id.btnCrear);
        ingresar = findViewById(R.id.btnIngresar);
        showPasswordButton = findViewById(R.id.showPasswordButton);

        // Lógica para alternar visibilidad de la contraseña
        showPasswordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isPasswordVisible) {
                    // Ocultar contraseña
                    contraseña.setTransformationMethod(new android.text.method.PasswordTransformationMethod());
                    showPasswordButton.setImageResource(R.drawable.ic_eye_closed); // Cambiar ícono a ojo cerrado
                    isPasswordVisible = false;
                } else {
                    // Mostrar contraseña
                    contraseña.setTransformationMethod(null);
                    showPasswordButton.setImageResource(R.drawable.ic_eye); // Cambiar ícono a ojo abierto
                    isPasswordVisible = true;
                }

                // Mover el cursor al final del texto
                contraseña.setSelection(contraseña.getText().length());
            }
        });
    }

    public void Ingresar(View v) {
        String pruebaUsuario = usuario.getText().toString();
        String pruebaContraseña = contraseña.getText().toString();
        boolean Usuarioencontrado = false;

        for (Usuario user : usuarios) {
            if (user.getUsuario().equals(pruebaUsuario) && user.getContraseña().equals(pruebaContraseña)) {
                Usuarioencontrado = true;
                nombreSeleccionado = user.getNombres();
                apellidoSelecionado = user.getApellidos();
                break;
            }
        }

        if (Usuarioencontrado) {
            // Navega al SplashActivity en lugar de BotonPrincipal directamente
            Intent splashIntent = new Intent(getApplicationContext(), SplashActivity.class);
            splashIntent.putExtra("nombre", nombreSeleccionado);
            splashIntent.putExtra("apellido", apellidoSelecionado);
            startActivity(splashIntent);
            overridePendingTransition(R.anim.enter, R.anim.exit);
        } else {
            Toast.makeText(this, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show();
            usuario.setText("");
            contraseña.setText("");
        }
    }

    public void Crear(View v) {
        Intent it = new Intent(getApplicationContext(), CrearUsuario.class);
        it.putExtra("ListUsuarios", (Serializable) usuarios);
        startActivity(it);
    }
}
