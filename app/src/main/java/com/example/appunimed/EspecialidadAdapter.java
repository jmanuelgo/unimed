package com.example.appunimed;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class EspecialidadAdapter extends RecyclerView.Adapter<EspecialidadAdapter.EspecialidadViewHolder> {

    private ArrayList<Especialidad> especialidades;
    private OnEspecialidadClickListener onEspecialidadClickListener;

    public EspecialidadAdapter(ArrayList<Especialidad> especialidades, OnEspecialidadClickListener onEspecialidadClickListener) {
        this.especialidades = especialidades;
        this.onEspecialidadClickListener = onEspecialidadClickListener;
    }

    @NonNull
    @Override
    public EspecialidadViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_especialidades, parent, false);
        return new EspecialidadViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EspecialidadViewHolder holder, int position) {
        holder.bind(especialidades.get(position), onEspecialidadClickListener);
    }

    @Override
    public int getItemCount() {
        return especialidades.size();
    }

    public static class EspecialidadViewHolder extends RecyclerView.ViewHolder {

        private TextView nombreEspecialidad;

        public EspecialidadViewHolder(@NonNull View itemView) {
            super(itemView);
            nombreEspecialidad = itemView.findViewById(R.id.tvEspecialidades);
        }

        public void bind(Especialidad especialidad, OnEspecialidadClickListener listener) {
            nombreEspecialidad.setText(especialidad.getNombreEspecialidad());
            itemView.setOnClickListener(v -> listener.onEspecialidadClick(especialidad));
        }
    }

    public interface OnEspecialidadClickListener {
        void onEspecialidadClick(Especialidad especialidad);
    }
}