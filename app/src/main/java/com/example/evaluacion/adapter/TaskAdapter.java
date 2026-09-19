package com.example.evaluacion.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import com.example.evaluacion.R;
import com.example.evaluacion.model.Task;

/**
 * Adaptador reutilizable que conecta la lista de {@link Task} con un
 * RecyclerView, mostrando cada tarea dentro de una tarjeta (CardView).
 * Al ser un módulo separado, puede reutilizarse en cualquier pantalla
 * que necesite listar tareas.
 */
public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskViewHolder> {

    private final List<Task> taskList;

    public TaskAdapter(List<Task> taskList) {
        this.taskList = taskList;
    }

    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_task, parent, false);
        return new TaskViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {
        Task task = taskList.get(position);
        holder.txtItemTitle.setText(task.getTitle());
        holder.txtItemCategory.setText(task.getCategory() + " · Prioridad " + task.getPriority());
        holder.ratingItem.setRating(task.getImportance());
        holder.checkCompleted.setOnCheckedChangeListener(null);
        holder.checkCompleted.setChecked(task.isCompleted());
        holder.checkCompleted.setOnCheckedChangeListener((buttonView, isChecked) ->
                task.setCompleted(isChecked));
    }

    @Override
    public int getItemCount() {
        return taskList.size();
    }

    static class TaskViewHolder extends RecyclerView.ViewHolder {
        ImageView imgTaskIcon;
        TextView txtItemTitle;
        TextView txtItemCategory;
        RatingBar ratingItem;
        CheckBox checkCompleted;

        TaskViewHolder(@NonNull View itemView) {
            super(itemView);
            imgTaskIcon = itemView.findViewById(R.id.imgTaskIcon);
            txtItemTitle = itemView.findViewById(R.id.txtItemTitle);
            txtItemCategory = itemView.findViewById(R.id.txtItemCategory);
            ratingItem = itemView.findViewById(R.id.ratingItem);
            checkCompleted = itemView.findViewById(R.id.checkCompleted);
        }
    }
}
