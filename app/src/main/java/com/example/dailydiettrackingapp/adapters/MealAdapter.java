package com.example.dailydiettrackingapp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dailydiettrackingapp.R;
import com.example.dailydiettrackingapp.Database.entities.Meal;

import java.util.List;

public class MealAdapter extends RecyclerView.Adapter<MealAdapter.MealViewHolder> {

    private final List<Meal> mealList;

    public MealAdapter(List<Meal> mealList) {
        this.mealList = mealList;
    }

    @NonNull
    @Override
    public MealViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_meal, parent, false);
        return new MealViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MealViewHolder holder, int position) {
        Meal meal = mealList.get(position);
        holder.mealNameTextView.setText("Name: " + meal.name);
        holder.mealDetailsTextView.setText("Calories: " + meal.calories +
                ", Protein: " + meal.protein + "g, Fat: " + meal.fat + "g, Carbs: " + meal.carbs + "g");
    }

    @Override
    public int getItemCount() {
        return mealList.size();
    }

    static class MealViewHolder extends RecyclerView.ViewHolder {
        TextView mealNameTextView, mealDetailsTextView;

        public MealViewHolder(@NonNull View itemView) {
            super(itemView);
            mealNameTextView = itemView.findViewById(R.id.mealNameTextView);
            mealDetailsTextView = itemView.findViewById(R.id.mealDetailsTextView);
        }
    }
}