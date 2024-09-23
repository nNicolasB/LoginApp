package com.example.constraintlayout_nicolasbarcha; // Use your actual package name

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Use the correct layout file (activity_main.xml)

        // Get references to the views
        EditText edUserName = findViewById(R.id.edUserName);
        EditText edPassword = findViewById(R.id.edPassword);
        Button buttonLogin = findViewById(R.id.buttonLogin);

        // Hardcoded credentials for validation
        final String validUsername = "admin";
        final String validPassword = "1234";

        // Set up the login button click listener
        buttonLogin.setOnClickListener(v -> {
            // Get input from the EditText fields
            String username = edUserName.getText().toString().trim();
            String password = edPassword.getText().toString().trim();

            // Check if the input matches hardcoded credentials
            if (username.equals(validUsername) && password.equals(validPassword)) {
                // Credentials are valid, go to MainActivity
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
                finish(); // Close the LoginActivity
            } else {
                // Invalid credentials, show an error message
                Toast.makeText(LoginActivity.this, "Invalid username or password", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
