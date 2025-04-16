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

public class WelcomeUser1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_welcome_user);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button logDietButton = findViewById(R.id.btn_log_diet);
        Button trackingDietButton = findViewById(R.id.btn_tracking_diet);
        Button dietaryTipsButton = findViewById(R.id.btn_dietary_tips);

        logDietButton.setOnClickListener(v -> {
            // Add intent to navigate to Log Diet Activity
        });

        trackingDietButton.setOnClickListener(v -> {
            // Add intent to navigate to Tracking Diet Activity
        });

        dietaryTipsButton.setOnClickListener(v -> {
            // Add intent to navigate to Dietary Tips Activity
        });
    }
}
