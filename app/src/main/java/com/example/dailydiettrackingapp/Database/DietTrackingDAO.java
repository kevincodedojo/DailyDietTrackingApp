package com.example.dailydiettrackingapp.Database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.dailydiettrackingapp.Database.entities.DietTracking;

import java.util.List;

@Dao
public interface DietTrackingDAO {

    @Insert
    void insert(DietTracking dietTracking);

    @Query("SELECT * FROM diet_tracking_table")
    List<DietTracking> getAllDietTrackingRecords();

    @Query("DELETE FROM diet_tracking_table WHERE id = :id")
    void deleteById(int id);
}