package com.example.dailydiettrackingapp.Database.entities;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "user_table")
public class User {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name;
    private String password; // todo: encrypt password before storing in database

    /**
     * constructor to create a new user instance
     * @param name name of the user
     * @param password password for the user
     */
    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    /**
     * gets user's id
     * @return the user's id
     */
    public int getId() {
        return id;
    }

    /**
     * sets user's id
     * @param id the new id for the user
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * gets the user's name
     * @return the user's name
     */
    public String getName() {
        return name;
    }

    /**
     * sets the user's name
     * @param name the new name for the user
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * gets the user's password
     * @return the user's password
     */
    public String getPassword() {
        return password;
    }

    /**
     * sets the user's password
     * @param password the new password for the user
     */
    public void setPassword(String password) {
        this.password = password;
    }
}