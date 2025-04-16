package com.example.dailydiettrackingapp.data;

import androidx.room.Database;
import androidx.room.RoomDatabase;
@Database(entities = {Meal.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract MealDAO mealDAO();
}
