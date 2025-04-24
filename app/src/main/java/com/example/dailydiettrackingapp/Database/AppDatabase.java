package com.example.dailydiettrackingapp.Database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.dailydiettrackingapp.Database.entities.DietTip;
import com.example.dailydiettrackingapp.Database.entities.Meal;

@Database(entities = {Meal.class, DietTip.class}, version = 1,exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public static final String DIET_TIP_TABLE = ;

    public abstract MealDAO mealDAO();

    public abstract DietTipDAO dietTipDAO();
}
