package com.example.dailydiettrackingapp.data;

import androidx.room.Database;
import androidx.room.RoomDatabase;
@Database(entities = {Meal.class,DietTip.class}, version = 1,exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract MealDAO mealDAO();

    public abstract DietTipDAO dietTipDAO();
}
