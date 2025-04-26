package com.example.dailydiettrackingapp;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.example.dailydiettrackingapp.Database.AppDatabase;
import com.example.dailydiettrackingapp.Database.DietTrackingDAO;
import com.example.dailydiettrackingapp.Database.entities.DietTracking;

import java.util.List;
import android.os.Handler;
import android.os.Looper;

public class LandingPage extends AppCompatActivity {

    private LinearLayout dietTrackingContainer;
    private AppDatabase db;
    private DietTrackingDAO dietTrackingDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activiy_landing_page);

        // Get the username from the Intent
        String username = getIntent().getStringExtra("username");

        // Set the welcome message
        TextView welcomeTextView = findViewById(R.id.welcomeTextView);
        welcomeTextView.setText("Welcome back " + username + "!");

        // Find the container for diet tracking entries
        dietTrackingContainer = findViewById(R.id.dietTrackingContainer);

        // Initialize the database and DAO
        db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "app-database").build();
        dietTrackingDAO = db.dietTrackingDAO();

        // Load diet tracking data
        loadDietTrackingData();
    }

    private void loadDietTrackingData() {
        new Thread(() -> {
            List<DietTracking> dietTrackingList = dietTrackingDAO.getAllDietTrackingRecords();
            // Update the UI on the main thread
            new Handler(Looper.getMainLooper()).post(() -> {
                for (DietTracking dietTracking : dietTrackingList) {
                    TextView mealTextView = new TextView(this);
                    mealTextView.setText(dietTracking.getMealName() + " - Calories: " + dietTracking.getCalories());
                    mealTextView.setTextSize(16);
                    mealTextView.setPadding(0, 8, 0, 8);
                    dietTrackingContainer.addView(mealTextView);
                }
            });
        }).start();
    }
}