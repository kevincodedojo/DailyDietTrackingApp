package com.example.dailydiettrackingapp;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.example.dailydiettrackingapp.Database.AppDatabase;
import com.example.dailydiettrackingapp.Database.MealDAO;
import com.example.dailydiettrackingapp.Database.entities.Meal;
import com.example.dailydiettrackingapp.adapters.MealAdapter;

import java.util.List;

public class TrackingDietActivity extends AppCompatActivity {

    private RecyclerView mealRecyclerView;
    private MealAdapter mealAdapter;
    private MealDAO mealDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tracking_diet);

        // Initialize RecyclerView
        mealRecyclerView = findViewById(R.id.mealRecyclerView);
        mealRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Initialize database and DAO
        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "app-database").allowMainThreadQueries().build();
        mealDAO = db.mealDAO();

        // Fetch meals and set up the adapter
        List<Meal> meals = mealDAO.getAllMeals();
        mealAdapter = new MealAdapter(meals);
        mealRecyclerView.setAdapter(mealAdapter);
    }
}