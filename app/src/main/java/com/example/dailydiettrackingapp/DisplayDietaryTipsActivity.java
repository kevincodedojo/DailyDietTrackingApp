package com.example.dailydiettrackingapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.example.dailydiettrackingapp.Database.AppDatabase;
import com.example.dailydiettrackingapp.Database.DietTipDAO;
import com.example.dailydiettrackingapp.Database.entities.DietTip;

import java.util.List;
import java.util.Random;

public class DisplayDietaryTipsActivity extends AppCompatActivity {

    private TextView dietTipTextView;
    private Button rerollButton, toggleAddTipButton, addTipButton;
    private LinearLayout addTipLayout;
    private EditText newTipTitleEditText, newTipDescriptionEditText;

    private DietTipDAO dietTipDAO;
    private List<DietTip> dietTips;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_dietary_tips);

        // Initialize UI components
        dietTipTextView = findViewById(R.id.dietTipTextView);
        rerollButton = findViewById(R.id.rerollButton);
        toggleAddTipButton = findViewById(R.id.toggleAddTipButton);
        addTipButton = findViewById(R.id.addTipButton);
        addTipLayout = findViewById(R.id.addTipLayout);
        newTipTitleEditText = findViewById(R.id.newTipTitleEditText);
        newTipDescriptionEditText = findViewById(R.id.newTipDescriptionEditText);

        // Initialize database and DAO
        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "app-database").allowMainThreadQueries().build();
        dietTipDAO = db.dietTipDAO();

        // Load all tips from the database
        dietTips = dietTipDAO.getAllRecords();
        showRandomTip();

        // Reroll button functionality
        rerollButton.setOnClickListener(v -> showRandomTip());

        // Toggle add tip layout visibility
        toggleAddTipButton.setOnClickListener(v -> {
            if (addTipLayout.getVisibility() == View.GONE) {
                addTipLayout.setVisibility(View.VISIBLE);
            } else {
                addTipLayout.setVisibility(View.GONE);
            }
        });

        // Add new tip to the database
        addTipButton.setOnClickListener(v -> {
            String title = newTipTitleEditText.getText().toString().trim();
            String description = newTipDescriptionEditText.getText().toString().trim();

            if (title.isEmpty() || description.isEmpty()) {
                Toast.makeText(this, "Please fill in both fields", Toast.LENGTH_SHORT).show();
            } else {
                DietTip newTip = new DietTip(title, description);
                dietTipDAO.insert(newTip);
                dietTips.add(newTip); // Update the local list
                Toast.makeText(this, "Tip added successfully!", Toast.LENGTH_SHORT).show();

                // Clear input fields
                newTipTitleEditText.setText("");
                newTipDescriptionEditText.setText("");
            }
        });
    }

    // Show a random tip from the list
    private void showRandomTip() {
        if (dietTips.isEmpty()) {
            dietTipTextView.setText("No tips available. Add a new tip!");
        } else {
            Random random = new Random();
            DietTip randomTip = dietTips.get(random.nextInt(dietTips.size()));
            dietTipTextView.setText(randomTip.getTitle() + ": " + randomTip.getDescription());
        }
    }
}