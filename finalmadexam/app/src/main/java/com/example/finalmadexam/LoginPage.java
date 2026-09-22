package com.example.finalmadexam;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class LoginPage extends AppCompatActivity {

    private Button      btnSubmit;
    private EditText    etPhoneNumber;
    private LinearLayout btnBack;
    private DBHelper    myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        etPhoneNumber = findViewById(R.id.aadhar);
        btnSubmit     = findViewById(R.id.submit);
        btnBack       = findViewById(R.id.btn_back);
        myDB          = new DBHelper(this);

        btnBack.setOnClickListener(v -> {
            finish();
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneInput = etPhoneNumber.getText().toString().trim();

                if (phoneInput.isEmpty()) {
                    Toast.makeText(LoginPage.this,
                            "Please enter your registered phone number",
                            Toast.LENGTH_SHORT).show();
                    return;
                }

                Boolean exists = myDB.checkPhone(phoneInput);

                if (exists) {
                    Toast.makeText(LoginPage.this,
                            "Login Successful!",
                            Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginPage.this, CulturalHeritageActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(LoginPage.this,
                            "Phone number not found. Please register first.",
                            Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(LoginPage.this, RegisterPage.class));
                }
            }
        });
    }
}