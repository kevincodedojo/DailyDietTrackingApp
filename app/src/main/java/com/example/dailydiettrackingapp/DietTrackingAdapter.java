package com.example.dailydiettrackingapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dailydiettrackingapp.Database.entities.DietTracking;

import java.util.List;

public class DietTrackingAdapter extends RecyclerView.Adapter<DietTrackingAdapter.ViewHolder> {

    private final List<DietTracking> dietTrackingList;

    public DietTrackingAdapter(List<DietTracking> dietTrackingList) {
        this.dietTrackingList = dietTrackingList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_diet_tracking, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        DietTracking dietTracking = dietTrackingList.get(position);
        holder.mealNameTextView.setText(dietTracking.getMealName());
        holder.caloriesTextView.setText("Calories: " + dietTracking.getCalories());
    }

    @Override
    public int getItemCount() {
        return dietTrackingList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView mealNameTextView;
        TextView caloriesTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mealNameTextView = itemView.findViewById(R.id.mealNameTextView);
            caloriesTextView = itemView.findViewById(R.id.caloriesTextView);
        }
    }
}