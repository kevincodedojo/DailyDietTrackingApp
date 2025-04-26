package com.example.dailydiettrackingapp;

import static org.junit.Assert.assertEquals;

import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;

import com.example.dailydiettrackingapp.Database.AppDatabase;
import com.example.dailydiettrackingapp.Database.UserDAO;
import com.example.dailydiettrackingapp.Database.entities.User;

import org.jetbrains.annotations.TestOnly;
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

    @Test
    public void testUserInsert() {
        User user = new User("testuser", "testpassword");
        userDAO.insert(user);
        User savedUser = userDAO.getAllUsers().get(0);
        assertEquals(savedUser.getName(), "testuser");
        assertEquals(savedUser.getPassword(), "testpassword");
    }

    @Test
    public void testEmptyFields() {
        User user = new User("", "");
        userDAO.insert(user);
        assertEquals(userDAO.getAllUsers().size(), 0);
    }
}
