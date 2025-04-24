package com.example.dailydiettrackingapp.Database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.dailydiettrackingapp.Database.entities.DietTip;

import java.util.List;

@Dao
public interface DietTipDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(DietTip dietTip);

    @Query("Select * from " + AppDatabase.DIET_TIP_TABLE + " ORDER BY title ")
    List<DietTip> getAllRecords();
}
