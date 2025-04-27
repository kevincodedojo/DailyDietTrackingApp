package com.example.dailydiettrackingapp;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.example.dailydiettrackingapp.Database.AppDatabase;
import com.example.dailydiettrackingapp.Database.UserDAO;
import com.example.dailydiettrackingapp.Database.entities.User;

import java.util.List;

public class LoginActivity extends AppCompatActivity {

    private EditText usernameEditText, passwordEditText;
    private Button loginButton;
    private UserDAO userDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usernameEditText = findViewById(R.id.editTextUsername);
        passwordEditText = findViewById(R.id.editTextPassword);
        loginButton = findViewById(R.id.buttonLogin);

        AppDatabase db = Room.databaseBuilder(
                getApplicationContext(),
                AppDatabase.class,
                "app-database").allowMainThreadQueries().build();
        userDAO = db.userDAO();

        loginButton.setOnClickListener(v -> {
            String username = usernameEditText.getText().toString();
            String password = passwordEditText.getText().toString();

            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please enter username and password", Toast.LENGTH_SHORT).show();
            } else {
                List<User> users = userDAO.getAllUsers();
                boolean userFound = false;

                for (User u : users) {
                    if (u.getName().equals(username)) {
                        userFound = true;
                        if (u.getPassword().equals(password)) {
                            Toast.makeText(this, "Login successful!", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(this, "Incorrect password", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    }
                }

                if (!userFound) {
                    User newUser = new User(username, password);
                    userDAO.insert(newUser);
                    Toast.makeText(this, "New user registered successfully!", Toast.LENGTH_SHORT).show();
                }

                // Debugging output (optional)
                for (User u : userDAO.getAllUsers()) {
                    Log.d("LoginActivity", "User: " + u.getName() + " Password: " + u.getPassword());
                }
            }
        });
    }
}