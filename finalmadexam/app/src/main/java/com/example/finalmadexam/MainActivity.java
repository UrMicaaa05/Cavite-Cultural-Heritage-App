package com.example.finalmadexam;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.register);
        button.setOnClickListener(v -> openRegister());

        button1 = findViewById(R.id.login);
        button1.setOnClickListener(v -> openLogin());
    }

    public void openRegister() {
        Intent intent = new Intent(getApplicationContext(), RegisterPage.class);
        startActivity(intent);
    }

    public void openLogin() {
        Intent intent = new Intent(getApplicationContext(), LoginPage.class);
        startActivity(intent);
    }
}