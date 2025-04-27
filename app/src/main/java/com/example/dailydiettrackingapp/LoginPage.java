package com.example.dailydiettrackingapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;

public class LoginPage extends AppCompatActivity {

    private HashMap<String, String> userPasswordMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        // Initialize the HashMap with username-password pairs
        userPasswordMap = new HashMap<>();
        userPasswordMap.put("admin", "admin123"); // Example admin user
        userPasswordMap.put("user1", "password1"); // Example regular user

        EditText usernameInput = findViewById(R.id.usernameInput);
        EditText passwordInput = findViewById(R.id.passwordInput);
        Button loginButton = findViewById(R.id.loginButton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameInput.getText().toString().trim();
                String password = passwordInput.getText().toString().trim();

                if (username.isEmpty() || password.isEmpty()) {
                    Toast.makeText(LoginPage.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
                } else if (userPasswordMap.containsKey(username) && userPasswordMap.get(username).equals(password)) {
                    if (username.equals("admin")) {
                        // Navigate to WelcomeAdmin activity
                        Intent intent = new Intent(LoginPage.this, WelcomAdmin.class);
                        startActivity(intent);
                    } else {
                        // Navigate to WelcomeUser1 activity
                        Intent intent = new Intent(LoginPage.this, WelcomeUser1.class);
                        startActivity(intent);
                    }
                } else {
                    Toast.makeText(LoginPage.this, "INVALID! USER / PASSWORD combination does not exist", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}