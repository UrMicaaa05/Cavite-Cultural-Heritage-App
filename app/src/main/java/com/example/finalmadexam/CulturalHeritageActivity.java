package com.example.finalmadexam;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

/**
 * STEP 3 — Cultural Heritage Landing Page.
 * Shown immediately after a successful login.
 * Logout button → MainActivity.
 * "OPEN THE ARCHIVE" → LocationPickerActivity.
 */
public class CulturalHeritageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cultural_heritage);

        // Open archive
        AppCompatButton btnExplore = findViewById(R.id.btn_explore);
        btnExplore.setOnClickListener(v -> {
            startActivity(new Intent(this, LocationPickerActivity.class));
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        });

        // Logout — go back to MainActivity and clear the back stack
        LinearLayout btnLogout = findViewById(R.id.btn_logout);
        btnLogout.setOnClickListener(v -> {
            Intent intent = new Intent(this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        });
    }

    @Override
    public void onBackPressed() {
        // Do nothing — prevent going back to login after logging in
    }
}