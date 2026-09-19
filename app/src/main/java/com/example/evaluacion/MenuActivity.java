package com.example.evaluacion;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Menú principal de la aplicación. Desde aquí, mediante botones, se accede
 * a las demás Activity: listado de tareas y formulario de nueva tarea.
 * También permite cerrar sesión y volver a la pantalla de bienvenida.
 */
public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        View menuItemTasks = findViewById(R.id.menuItemTasks);
        View menuItemAddTask = findViewById(R.id.menuItemAddTask);
        View menuItemLogout = findViewById(R.id.menuItemLogout);

        menuItemTasks.setOnClickListener(v ->
                startActivity(new Intent(this, TaskListActivity.class)));

        menuItemAddTask.setOnClickListener(v ->
                startActivity(new Intent(this, AddTaskActivity.class)));

        menuItemLogout.setOnClickListener(v -> {
            Intent intent = new Intent(this, WelcomeActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
        });
    }
}
