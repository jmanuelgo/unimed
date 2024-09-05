package com.example.appunimed;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // Inicializa la animación Lottie
        LottieAnimationView animationView = findViewById(R.id.lottieAnimationView);
        animationView.setAnimation(R.raw.carga); // Archivo de animación Lottie en /res/raw

        // Recuperar los datos del intent
        String nombre = getIntent().getStringExtra("nombre");
        String apellido = getIntent().getStringExtra("apellido");

        new Handler().postDelayed(() -> {
            Intent mainIntent = new Intent(SplashActivity.this, BotonPrincipal.class);
            mainIntent.putExtra("nombre", nombre);
            mainIntent.putExtra("apellido", apellido);
            startActivity(mainIntent);
            finish(); // Finaliza SplashActivity para que el usuario no pueda volver a esta pantalla
        }, 5000);
    }
}
