package com.example.constraintlayout_nicolasbarcha;

import com.example.constraintlayout_nicolasbarcha.contacts.Contact;
import com.example.constraintlayout_nicolasbarcha.contacts.ContactListAdapter;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ContactListAdapter adapter;
    private List<Contact> contactList;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize SharedPreferences
        sharedPreferences = getSharedPreferences("LoginPrefs", MODE_PRIVATE);

        // Get username from SharedPreferences and display it
        TextView userName = findViewById(R.id.userName);
        String username = sharedPreferences.getString("username", "Admin");
        userName.setText("Welcome back! " + username);

        // Initialize RecyclerView and Contacts List
        recyclerView = findViewById(R.id.recyclerView);
        contactList = new ArrayList<>();

        // Set up RecyclerView adapter and layout manager
        adapter = new ContactListAdapter(contactList, new ContactListAdapter.OnContactClickListener() {
            @Override
            public void onItemClick(Contact contact) {
                // Handle item click (e.g., display details or edit contact)
            }

            @Override
            public void onRemoveClick(Contact contact) {
                // Remove contact from list
                contactList.remove(contact);
                adapter.notifyDataSetChanged();
            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        // Example: Adding sample contacts
        contactList.add(new Contact("John Doe", "123-456-7890", R.drawable.man));
        contactList.add(new Contact("James Smith", "098-765-4321",R.drawable.gamer));
        contactList.add(new Contact("Clara Paul", "378-091-5490",R.drawable.women2));
        contactList.add(new Contact("Mikael Will", "973-781-0163", R.drawable.man2));
        contactList.add(new Contact("Phil Jones", "072-338-0381",R.drawable.man3));
        contactList.add(new Contact("Lea Spenser", "288-125-6720",R.drawable.women));
        adapter.notifyDataSetChanged();

        // Handle Logout Button Click
        Button logoutButton = findViewById(R.id.logoutButton);
        logoutButton.setOnClickListener(v -> {
            // Clear the login status in SharedPreferences
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean("isLoggedIn", false);  // Set isLoggedIn to false
            editor.apply();

            // Redirect to LoginActivity and clear the activity stack
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();  // Close MainActivity
        });
    }
}
