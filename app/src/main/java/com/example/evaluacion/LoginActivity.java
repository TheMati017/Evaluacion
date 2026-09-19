package com.example.evaluacion;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Pantalla de inicio de sesión. Se accede desde la Activity de bienvenida
 * y, tras validar los campos, da paso al menú principal de la aplicación.
 */
public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EditText editUsername = findViewById(R.id.editUsername);
        EditText editPassword = findViewById(R.id.editPassword);
        Button btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(v -> {
            String username = editUsername.getText().toString().trim();
            String password = editPassword.getText().toString().trim();

            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, R.string.toast_login_required, Toast.LENGTH_SHORT).show();
                return;
            }

            startActivity(new Intent(this, MenuActivity.class));
            finish();
        });
    }
}
