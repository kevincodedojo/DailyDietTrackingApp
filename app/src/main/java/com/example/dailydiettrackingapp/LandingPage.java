package com.example.dailydiettrackingapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.example.dailydiettrackingapp.Database.AppDatabase;
import com.example.dailydiettrackingapp.Database.DietTrackingDAO;
import com.example.dailydiettrackingapp.Database.entities.DietTracking;

import java.util.List;
import android.os.Handler;
import android.os.Looper;

public class LandingPage extends AppCompatActivity {

    private RecyclerView dietTrackingRecyclerView;
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

        // Find the RecyclerView for diet tracking entries
        dietTrackingRecyclerView = findViewById(R.id.dietTrackingRecyclerView);
        dietTrackingRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Initialize the database and DAO
        db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "app-database").build();
        dietTrackingDAO = db.dietTrackingDAO();

        // Load diet tracking data
        loadDietTrackingData();

        // Add button functionality
        Button goToWelcomeUserButton = findViewById(R.id.btn_go_to_welcome_user);
        goToWelcomeUserButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LandingPage.this, WelcomeUser1.class);
                startActivity(intent);
            }
        });
    }

    private void loadDietTrackingData() {
        new Thread(() -> {
            List<DietTracking> dietTrackingList = dietTrackingDAO.getAllDietTrackingRecords();
            new Handler(Looper.getMainLooper()).post(() -> {
                DietTrackingAdapter adapter = new DietTrackingAdapter(dietTrackingList);
                dietTrackingRecyclerView.setAdapter(adapter);
            });
        }).start();
    }
}