package com.example.dailydiettrackingapp.Database;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.dailydiettrackingapp.Database.entities.Login;

import java.util.List;
@Dao
public interface LoginDAO {
    @Insert
    void insert(Login login);

    @Query("SELECT * FROM Login")
    List<Login> getAllLogins();

    @Query("SELECT * FROM Login WHERE username = :username AND password = :password")
    Login getLoginByUsernameAndPassword(String username, String password);

    @Query("SELECT * FROM Login WHERE user_id = :userId")
    Login getLoginById(int userId);

}
