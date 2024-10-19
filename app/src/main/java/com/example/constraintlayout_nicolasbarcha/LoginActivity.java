package com.example.constraintlayout_nicolasbarcha;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private EditText edUserName, edPassword;
    private Button buttonLogin;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Initialize SharedPreferences
        sharedPreferences = getSharedPreferences("LoginPrefs", MODE_PRIVATE);

        // Check if user is already logged in
        boolean isLoggedIn = sharedPreferences.getBoolean("isLoggedIn", false);
        if (isLoggedIn) {
            openMainActivity();  // If already logged in, go straight to MainActivity
            return;
        }

        // Get references to views
        edUserName = findViewById(R.id.edUserName);
        edPassword = findViewById(R.id.edPassword);
        buttonLogin = findViewById(R.id.buttonLogin);

        // Set up login button click listener
        buttonLogin.setOnClickListener(v -> {
            String username = edUserName.getText().toString().trim();
            String password = edPassword.getText().toString().trim();

            // Simple hardcoded check for valid credentials
            if (username.equals("admin") && password.equals("1234")) {
                // Save login status to SharedPreferences
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putBoolean("isLoggedIn", true);  // Set logged-in status to true
                editor.apply();  // Apply changes

                openMainActivity();  // Go to MainActivity
            } else {
                Toast.makeText(LoginActivity.this, "Invalid username or password", Toast.LENGTH_SHORT).show();
            }
        });
    }

    // Function to open MainActivity
    private void openMainActivity() {
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
        finish();  // Close LoginActivity
    }
}
