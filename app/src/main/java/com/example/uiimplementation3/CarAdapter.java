package com.example.uiimplementation3;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CarAdapter extends RecyclerView.Adapter<CarAdapter.CarViewHolder> {
    ArrayList<CarItem> carList;
    OnItemListener onItemListener;


    public CarAdapter(ArrayList<CarItem> carList, OnItemListener onItemListener ) {
        this.carList = carList;
        this.onItemListener = onItemListener;


    }

    @NonNull
    @Override
    public CarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_design, parent, false);
        CarViewHolder carViewHolder = new CarViewHolder(view, onItemListener);
        return carViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CarViewHolder holder, int position) {
        CarItem carItem = carList.get(position);
        holder.img.setImageResource(carItem.getImage());
        holder.type.setText(carItem.getType());
        holder.desc.setText(carItem.getDesc());
        holder.no.setText(carItem.getNo());
        holder.rating.setText(String.valueOf(carItem.getRating()));


    }

    @Override
    public int getItemCount() {
        return carList.size();
    }


    public static class CarViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView type, desc, no, rating;
        ImageView img;
        OnItemListener onItemListener;


        public CarViewHolder(@NonNull View itemView, OnItemListener onItemListener) {
            super(itemView);
            img = itemView.findViewById(R.id.car_image);
            type = itemView.findViewById(R.id.car_type);
            desc = itemView.findViewById(R.id.car_desc);
            no = itemView.findViewById(R.id.car_no);
            rating = itemView.findViewById(R.id.car_rating);
            this.onItemListener = onItemListener;
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            onItemListener.onItemClick(getAdapterPosition());
        }
    }
    public interface OnItemListener{
        void onItemClick(int position);
    }
}
