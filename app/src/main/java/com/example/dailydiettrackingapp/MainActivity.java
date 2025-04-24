package com.example.dailydiettrackingapp;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.room.Room;

import com.example.dailydiettrackingapp.Database.AppDatabase;
import com.example.dailydiettrackingapp.Database.Meal;
import com.example.dailydiettrackingapp.Database.MealDAO;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        AppDatabase db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "meal-db").allowMainThreadQueries().build();
        MealDAO mealDao = db.mealDAO();

        Meal meal = new Meal();
        meal.name = "Test Meal";
        meal.calories = 500;
        meal.protein = 35;
        meal.fat = 20;
        meal.carbs = 45;

        mealDao.insert(meal);
        mealDao.getAllMeals();
    }
}