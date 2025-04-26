package com.example.dailydiettrackingapp;

import static org.junit.Assert.assertEquals;

import androidx.room.Room;

import com.example.dailydiettrackingapp.Database.AppDatabase;
import com.example.dailydiettrackingapp.Database.UserDAO;
import com.example.dailydiettrackingapp.Database.entities.User;

import org.junit.Before;
import org.junit.Test;

public class LoginActivityTest {

    private AppDatabase db;
    private UserDAO userDAO;

    @Before
    public void createDB() {
        db = Room.inMemoryDatabaseBuilder(
                ApplicationProvider.getApplicationContext(),
                AppDatabase.class).allowMainThreadQueries().build();
        userDAO = db.userDAO();
    }
}
