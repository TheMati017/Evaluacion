package com.example.evaluacion;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Activity de inicio de TaskMaster. Es la primera pantalla que ve el usuario
 * (pantalla de bienvenida) y reorienta el flujo de la aplicación según los
 * distintos estados del ciclo de vida, registrando cada uno en el Logcat.
 */
public class WelcomeActivity extends AppCompatActivity {

    private static final String TAG = "WelcomeActivity";
    private final Handler handler = new Handler(Looper.getMainLooper());
    private Runnable autoStartRunnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        Log.d(TAG, "onCreate: pantalla de bienvenida creada");

        Button btnStart = findViewById(R.id.btnStart);
        btnStart.setOnClickListener(v -> goToLogin());

        // Navegación automática tras una breve carga simulada,
        // reorientando el flujo hacia el inicio de sesión.
        autoStartRunnable = this::goToLogin;
        handler.postDelayed(autoStartRunnable, 2500);
    }

    private void goToLogin() {
        handler.removeCallbacks(autoStartRunnable);
        startActivity(new Intent(this, LoginActivity.class));
        finish();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacks(autoStartRunnable);
        Log.d(TAG, "onDestroy");
    }
}
