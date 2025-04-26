package com.example.dailydiettrackingapp;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.room.Room;

import com.example.dailydiettrackingapp.Database.AppDatabase;
import com.example.dailydiettrackingapp.Database.DietTipDAO;
import com.example.dailydiettrackingapp.Database.entities.DietTip;
import com.example.dailydiettrackingapp.Database.entities.Meal;
import com.example.dailydiettrackingapp.Database.MealDAO;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AppDatabase db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "app_database").allowMainThreadQueries().build();

        MealDAO mealDao = db.mealDAO();
        DietTipDAO dietTipDAO = db.dietTipDAO();


        Meal meal = new Meal();
        meal.name = "Test Meal";
        meal.calories = 500;
        meal.protein = 35;
        meal.fat = 20;
        meal.carbs = 45;

        mealDao.insert(meal);
        mealDao.getAllMeals();

        new Thread(() -> {
            mealDao.insert(meal);
            List<Meal> allMeals = mealDao.getAllMeals();
            // Do something with allMeals if needed
        }).start();



        new Thread(() -> {
            DietTip newTip = new DietTip("Healthy Eating", "Eat more fruits and vegetables");

            dietTipDAO.insert(newTip);

            List<DietTip> dietTips = dietTipDAO.getAllRecords();


        }).start();




    }
}