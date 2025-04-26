package com.example.dailydiettrackingapp;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.example.dailydiettrackingapp.Database.AppDatabase;
import com.example.dailydiettrackingapp.Database.DietTrackingDAO;
import com.example.dailydiettrackingapp.Database.entities.DietTracking;
import com.example.dailydiettrackingapp.adapters.DietTrackingAdapter;

import java.util.List;
import android.os.Handler;
import android.os.Looper;

public class LandingPage extends AppCompatActivity {

    private RecyclerView recyclerView;
    private DietTrackingAdapter adapter;
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

        // Set up RecyclerView
        recyclerView = findViewById(R.id.dietTrackingRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new DietTrackingAdapter(null);
        recyclerView.setAdapter(adapter);

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
            // Update the RecyclerView on the main thread
            new Handler(Looper.getMainLooper()).post(() ->
                    adapter.setDietTrackingList(dietTrackingList)
            );
        }).start();
    }
}