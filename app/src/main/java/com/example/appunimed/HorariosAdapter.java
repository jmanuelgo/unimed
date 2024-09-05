package com.example.appunimed;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HorariosAdapter extends RecyclerView.Adapter<HorariosAdapter.HorariosViewHolder> {

    private ArrayList<String> horarios;
    private OnHorarioClickListener onHorarioClickListener;

    public HorariosAdapter(ArrayList<String> horarios, OnHorarioClickListener onHorarioClickListener) {
        this.horarios = horarios;
        this.onHorarioClickListener = onHorarioClickListener;
    }

    @NonNull
    @Override
    public HorariosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_horarios, parent, false);
        return new HorariosViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HorariosViewHolder holder, int position) {
        holder.bind(horarios.get(position), onHorarioClickListener);
    }

    @Override
    public int getItemCount() {
        return horarios.size();
    }

    public static class HorariosViewHolder extends RecyclerView.ViewHolder {

        private TextView horarioTextView;

        public HorariosViewHolder(@NonNull View itemView) {
            super(itemView);
            horarioTextView = itemView.findViewById(R.id.tvEspecialidades);
        }

        public void bind(String horario, OnHorarioClickListener listener) {
            horarioTextView.setText(horario);
            itemView.setOnClickListener(v -> listener.onHorarioClick(horario));
        }
    }

    public interface OnHorarioClickListener {
        void onHorarioClick(String horario);
    }
}
