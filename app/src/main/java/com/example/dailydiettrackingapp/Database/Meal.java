package com.example.dailydiettrackingapp.Database;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Meal {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public String name;

    public int calories;
    public int protein;
    public int fat;
    public int carbs;
}
