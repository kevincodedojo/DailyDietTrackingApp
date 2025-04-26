package com.example.dailydiettrackingapp.data;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Meal.class, Login.class}, version = 2)
public abstract class AppDatabase extends RoomDatabase {
    public abstract MealDAO mealDAO();
    public abstract LoginDAO loginDAO();
}
