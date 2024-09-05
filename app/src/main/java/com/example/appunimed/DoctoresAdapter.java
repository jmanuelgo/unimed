package com.example.appunimed;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DoctoresAdapter extends RecyclerView.Adapter<DoctoresAdapter.DoctoresViewHolder> {

    private ArrayList<Doctor> doctores;
    private OnDoctorClickListener onDoctorClickListener;

    public DoctoresAdapter(ArrayList<Doctor> doctores, OnDoctorClickListener onDoctorClickListener) {
        this.doctores = doctores;
        this.onDoctorClickListener = onDoctorClickListener ;
    }

    @NonNull
    @Override
    public DoctoresViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_doctores, parent, false);
        return new DoctoresViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DoctoresViewHolder holder, int position) {
        holder.bind(doctores.get(position), onDoctorClickListener);
    }

    @Override
    public int getItemCount() {
        return doctores.size();
    }

    public static class DoctoresViewHolder extends RecyclerView.ViewHolder {

        private TextView nombreDoctor;

        public DoctoresViewHolder(@NonNull View itemView) {
            super(itemView);
            nombreDoctor = itemView.findViewById(R.id.tvEspecialidades);
        }

        public void bind(Doctor doctor, OnDoctorClickListener listener) {
            nombreDoctor.setText(doctor.getNombres() + " " + doctor.getApellidos());
            itemView.setOnClickListener(v -> listener.onDoctorClick(doctor));
        }
    }

    public interface OnDoctorClickListener {
        void onDoctorClick(Doctor doctor);
    }
}
