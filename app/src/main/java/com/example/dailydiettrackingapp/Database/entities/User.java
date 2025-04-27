package com.example.dailydiettrackingapp.Database.entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * Entity class for the user
 * Stores the user's information, including name & password
 */

@Entity(tableName = "user_table")
public class User {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name;
    private String password; // todo: encrypt password before storing in database
    private boolean isAdmin;

    /**
     * Constructor to create a new user instance
     * @param name name of the user
     * @param password password for the user
     */
    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    /**
     * Sets user's id
     * @param id the new id for the user
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the user's name
     * @return the user's name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the user's name
     * @param name the new name for the user
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the user's password
     * @return the user's password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the user's password
     * @param password the new password for the user
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets if the user is an admin
     * @return true if admin, false otherwise
     */
    public boolean isAdmin() {
        return isAdmin;
    }

    /**
     * Sets the user as admin or not
     * @param admin whether the user is an admin
     */
    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }
}
