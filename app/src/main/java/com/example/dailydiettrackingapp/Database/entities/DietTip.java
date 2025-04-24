package com.example.dailydiettrackingapp.Database.entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.dailydiettrackingapp.Database.AppDatabase;

import java.util.Objects;

@Entity(tableName = AppDatabase.DIET_TIP_TABLE)
public class DietTip {
    @PrimaryKey(autoGenerate = true)

    private String title;
    private String description;



public DietTip(String title, String description){
    this.title = title;
    this.description = description;
}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DietTip dietTip = (DietTip) o;
        return Objects.equals(title, dietTip.title) && Objects.equals(description, dietTip.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, description);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


}