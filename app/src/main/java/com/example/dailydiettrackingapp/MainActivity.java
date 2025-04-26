package com.example.dailydiettrackingapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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

//*************temporary comment code to test database*************
//        AppDatabase db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "meal-db").allowMainThreadQueries().build();
//        MealDAO mealDao = db.mealDAO();
//
//        Meal meal = new Meal();
//        meal.name = "Test Meal";
//        meal.calories = 500;
//        meal.protein = 35;
//        meal.fat = 20;
//        meal.carbs = 45;
//
//        mealDao.insert(meal);
//        mealDao.getAllMeals();
//
//        AppDatabase dbase = Room.databaseBuilder(getApplicationContext(),
//                AppDatabase.class, "app-database").build();
//
//        DietTipDAO dietTipDAO = dbase.dietTipDAO();
//
//        new Thread(() -> {
//            DietTip newTip = new DietTip("Healthy Eating", "Eat more fruits and vegetables");
//
//            dietTipDAO.insert(newTip);
//
//            List<DietTip> dietTips = dietTipDAO.getAllRecords();
//
//
//        }).start();
        //*************temporary comment code to test database*************




        Button letsGetStartedButton = findViewById(R.id.myButton);
        letsGetStartedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LoginPage.class);
                startActivity(intent);
            }

        });
    }
}