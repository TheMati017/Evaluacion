package com.example.evaluacion;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.evaluacion.model.Task;

/**
 * Formulario para crear una nueva tarea. Usa TableLayout (dentro de un
 * ScrollView) para alinear etiquetas y campos, e incorpora Spinner,
 * RadioButton, RatingBar, CheckBox e ImageView según lo solicitado.
 */
public class AddTaskActivity extends AppCompatActivity {

    private EditText editTitle;
    private EditText editDescription;
    private Spinner spinnerCategory;
    private RadioGroup radioGroupPriority;
    private RatingBar ratingImportance;
    private CheckBox checkCompleted;
    private ProgressBar progressSaving;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        editTitle = findViewById(R.id.editTitle);
        editDescription = findViewById(R.id.editDescription);
        spinnerCategory = findViewById(R.id.spinnerCategory);
        radioGroupPriority = findViewById(R.id.radioGroupPriority);
        ratingImportance = findViewById(R.id.ratingImportance);
        checkCompleted = findViewById(R.id.checkCompleted);
        progressSaving = findViewById(R.id.progressSaving);
        Button btnSave = findViewById(R.id.btnSave);

        ArrayAdapter<CharSequence> categoryAdapter = ArrayAdapter.createFromResource(
                this, R.array.categories_array, android.R.layout.simple_spinner_item);
        categoryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCategory.setAdapter(categoryAdapter);

        btnSave.setOnClickListener(v -> saveTask());
    }

    private void saveTask() {
        String title = editTitle.getText().toString().trim();
        if (title.isEmpty()) {
            Toast.makeText(this, R.string.toast_title_required, Toast.LENGTH_SHORT).show();
            return;
        }

        String description = editDescription.getText().toString().trim();
        String category = spinnerCategory.getSelectedItem().toString();
        String priority = getSelectedPriority();
        int importance = Math.round(ratingImportance.getRating());
        boolean completed = checkCompleted.isChecked();

        progressSaving.setVisibility(View.VISIBLE);

        // Simula una breve operación de guardado, mostrando el ProgressBar.
        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            Task task = new Task(title, description, category, priority, importance, completed);
            TaskListActivity.TASKS.add(task);

            progressSaving.setVisibility(View.GONE);
            Toast.makeText(this, R.string.toast_task_saved, Toast.LENGTH_SHORT).show();
            finish();
        }, 600);
    }

    private String getSelectedPriority() {
        int id = radioGroupPriority.getCheckedRadioButtonId();
        if (id == R.id.radioHigh) return getString(R.string.priority_high);
        if (id == R.id.radioLow) return getString(R.string.priority_low);
        return getString(R.string.priority_medium);
    }
}
