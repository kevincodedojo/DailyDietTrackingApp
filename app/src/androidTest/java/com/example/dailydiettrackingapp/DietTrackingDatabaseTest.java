package com.example.dailydiettrackingapp;

import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.example.dailydiettrackingapp.Database.AppDatabase;
import com.example.dailydiettrackingapp.Database.DietTrackingDAO;
import com.example.dailydiettrackingapp.Database.entities.DietTracking;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(AndroidJUnit4.class)
public class DietTrackingDatabaseTest {

    private AppDatabase db;
    private DietTrackingDAO dietTrackingDAO;

    @Before
    public void createDb() {
        db = Room.inMemoryDatabaseBuilder(
                ApplicationProvider.getApplicationContext(),
                AppDatabase.class
        ).allowMainThreadQueries().build();
        dietTrackingDAO = db.dietTrackingDAO();
    }

    @After
    public void closeDb() throws IOException {
        db.close();
    }

    @Test
    public void testInsertDietTracking() {
        DietTracking dietTracking = new DietTracking("Breakfast", "2023-10-01", 300);
        dietTrackingDAO.insert(dietTracking);

        List<DietTracking> records = dietTrackingDAO.getAllDietTrackingRecords();
        assertEquals(1, records.size());
        assertEquals("Breakfast", records.get(0).getMealName());
        assertEquals("2023-10-01", records.get(0).getDate());
        assertEquals(300, records.get(0).getCaloriesConsumed());
    }

    @Test
    public void testRetrieveAllDietTrackingRecords() {
        DietTracking entry1 = new DietTracking("Breakfast", "2023-10-01", 300);
        DietTracking entry2 = new DietTracking("Lunch", "2023-10-01", 600);

        dietTrackingDAO.insert(entry1);
        dietTrackingDAO.insert(entry2);

        List<DietTracking> records = dietTrackingDAO.getAllDietTrackingRecords();
        assertEquals(2, records.size());
        assertEquals("Lunch", records.get(1).getMealName());
        assertEquals(600, records.get(1).getCaloriesConsumed());
    }
}