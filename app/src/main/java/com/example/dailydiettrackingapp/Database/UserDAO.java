package com.example.dailydiettrackingapp.Database;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.dailydiettrackingapp.Database.entities.User;

import java.util.List;

@Dao
public interface UserDAO {

    @Insert
    void insert(User user);

    @Query("SELECT * FROM user_table")
    List<User> getAllUsers();

    @Query("SELECT * FROM user_table WHERE name = :username AND password = :password")
    User getUserByCredentials(String username, String password);
}