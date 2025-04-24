package com.example.dailydiettrackingapp.Database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.dailydiettrackingapp.Database.entities.Meal;

import java.util.List;
@Dao
public interface MealDAO {
    @Insert
    void insert(Meal meal);

    @Query("SELECT * FROM Meal")
    List<Meal> getAllMeals();
}
