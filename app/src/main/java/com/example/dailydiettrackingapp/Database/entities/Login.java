package com.example.dailydiettrackingapp.Database.entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity
public class Login {
    @PrimaryKey(autoGenerate = true)
    public int user_id;

    public String username;
    public boolean admin_access;
    public Date created_at;
    public String first_name;
    public String last_name;
    public String password;
}