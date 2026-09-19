package com.example.evaluacion;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import com.example.evaluacion.adapter.TaskAdapter;
import com.example.evaluacion.model.Task;

/**
 * Pantalla principal de la aplicación: muestra la lista de tareas en un
 * RecyclerView con tarjetas (CardView), reutilizando el módulo TaskAdapter.
 */
public class TaskListActivity extends AppCompatActivity {

    // Lista en memoria compartida entre pantallas (módulo de datos simple).
    public static final List<Task> TASKS = new ArrayList<>();

    private RecyclerView recyclerTasks;
    private TextView txtEmpty;
    private TaskAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_list);

        recyclerTasks = findViewById(R.id.recyclerTasks);
        txtEmpty = findViewById(R.id.txtEmpty);
        Button btnAddTask = findViewById(R.id.btnAddTask);

        adapter = new TaskAdapter(TASKS);
        recyclerTasks.setLayoutManager(new LinearLayoutManager(this));
        recyclerTasks.setAdapter(adapter);

        btnAddTask.setOnClickListener(v ->
                startActivity(new Intent(this, AddTaskActivity.class)));

        updateEmptyState();
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Refresca la lista cada vez que esta Activity vuelve al primer plano
        // (por ejemplo, al regresar desde AddTaskActivity).
        adapter.notifyDataSetChanged();
        updateEmptyState();
    }

    private void updateEmptyState() {
        boolean isEmpty = TASKS.isEmpty();
        txtEmpty.setVisibility(isEmpty ? View.VISIBLE : View.GONE);
        recyclerTasks.setVisibility(isEmpty ? View.GONE : View.VISIBLE);
    }
}
