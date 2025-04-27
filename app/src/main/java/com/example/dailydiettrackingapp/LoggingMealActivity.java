package com.example.dailydiettrackingapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.example.dailydiettrackingapp.Database.AppDatabase;
import com.example.dailydiettrackingapp.Database.MealDAO;
import com.example.dailydiettrackingapp.Database.entities.Meal;

public class LoggingMealActivity extends AppCompatActivity {

    private EditText mealNameEditText, caloriesEditText, proteinEditText, fatEditText, carbsEditText;
    private Button saveMealButton;
    private TextView mealLogTextView;
    private MealDAO mealDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logging_meal);

        // Initialize UI components
        mealNameEditText = findViewById(R.id.mealNameEditText);
        caloriesEditText = findViewById(R.id.caloriesEditText);
        proteinEditText = findViewById(R.id.proteinEditText);
        fatEditText = findViewById(R.id.fatEditText);
        carbsEditText = findViewById(R.id.carbsEditText);
        saveMealButton = findViewById(R.id.saveMealButton);
        mealLogTextView = findViewById(R.id.mealLogTextView);

        // Initialize database and DAO
        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "app-database").allowMainThreadQueries().build();
        mealDAO = db.mealDAO();

        // Set up button click listener
        saveMealButton.setOnClickListener(v -> {
            String mealName = mealNameEditText.getText().toString().trim();
            String calories = caloriesEditText.getText().toString().trim();
            String protein = proteinEditText.getText().toString().trim();
            String fat = fatEditText.getText().toString().trim();
            String carbs = carbsEditText.getText().toString().trim();

            if (mealName.isEmpty() || calories.isEmpty() || protein.isEmpty() || fat.isEmpty() || carbs.isEmpty()) {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
            } else {
                Meal meal = new Meal();
                meal.name = mealName;
                meal.calories = Integer.parseInt(calories);
                meal.protein = Integer.parseInt(protein);
                meal.fat = Integer.parseInt(fat);
                meal.carbs = Integer.parseInt(carbs);

                mealDAO.insert(meal);

                // Append meal details to the log
                String logEntry = "Name: " + mealName + ", Calories: " + calories +
                        ", Protein: " + protein + "g, Fat: " + fat + "g, Carbs: " + carbs + "g\n";
                mealLogTextView.append(logEntry);

                // Clear input fields
                mealNameEditText.setText("");
                caloriesEditText.setText("");
                proteinEditText.setText("");
                fatEditText.setText("");
                carbsEditText.setText("");
            }
        });
    }
}