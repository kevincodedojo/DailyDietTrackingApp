package com.example.dailydiettrackingapp.Database.entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "diet_tracking_table")
public class DietTracking {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String mealName;
    private String date;
    private int caloriesConsumed;

    public DietTracking(String mealName, String date, int caloriesConsumed) {
        this.mealName = mealName;
        this.date = date;
        this.caloriesConsumed = caloriesConsumed;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMealName() {
        return mealName;
    }

    public void setMealName(String mealName) {
        this.mealName = mealName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getCaloriesConsumed() {
        return caloriesConsumed;
    }

    public void setCaloriesConsumed(int caloriesConsumed) {
        this.caloriesConsumed = caloriesConsumed;
    }
}