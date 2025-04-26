package com.example.dailydiettrackingapp.data;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Meal {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public String name;

    public int calories;
    public int protein;
    public int fat;//x`x`x`
    public int carbs;
}
