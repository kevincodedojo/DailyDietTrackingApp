package com.example.dailydiettrackingapp.Database;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.dailydiettrackingapp.Database.entities.DietTip;
import com.example.dailydiettrackingapp.Database.entities.DietTracking;
import com.example.dailydiettrackingapp.Database.entities.Meal;
import com.example.dailydiettrackingapp.Database.entities.User;


@Database(entities = {Meal.class, DietTip.class, User.class, DietTracking.class}, version = 4, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public static final String DIET_TIP_TABLE = "dietTipTable";

    public abstract MealDAO mealDAO();
    public abstract DietTipDAO dietTipDAO();
    public abstract UserDAO userDAO();
    public abstract DietTrackingDAO dietTrackingDAO();