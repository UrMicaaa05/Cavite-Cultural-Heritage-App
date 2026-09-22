package com.example.finalmadexam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.hbb20.CountryCodePicker;

public class LoginPage extends AppCompatActivity {

    private Button btnSubmit;

    private EditText etPhoneNumber;

    private LinearLayout btnBack;

    private DBHelper myDB;

    private CountryCodePicker ccp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        // INIT VIEWS
        etPhoneNumber = findViewById(R.id.phonenumber);

        btnSubmit = findViewById(R.id.submit);
        btnBack = findViewById(R.id.btn_back);

        ccp = findViewById(R.id.countryCodePicker);

        myDB = new DBHelper(this);

        // BACK BUTTON
        btnBack.setOnClickListener(v -> {

            finish();

            overridePendingTransition(
                    android.R.anim.fade_in,
                    android.R.anim.fade_out
            );
        });

        // LOGIN BUTTON
        btnSubmit.setOnClickListener(v -> {

            String phoneNumber =
                    etPhoneNumber.getText().toString().trim();

            // EMPTY CHECK
            if (phoneNumber.isEmpty()) {

                Toast.makeText(
                        LoginPage.this,
                        "Please enter your phone number",
                        Toast.LENGTH_SHORT
                ).show();

                return;
            }

            // FULL PHONE NUMBER
            String fullPhoneNumber =
                    "+" + ccp.getSelectedCountryCode()
                            + phoneNumber;

            // CHECK PHONE
            Boolean exists =
                    myDB.checkPhone(fullPhoneNumber);

            if (exists) {

                Toast.makeText(
                        LoginPage.this,
                        "Login Successful!",
                        Toast.LENGTH_SHORT
                ).show();

                startActivity(
                        new Intent(
                                LoginPage.this,
                                CulturalHeritageActivity.class
                        )
                );

                finish();

            } else {

                Toast.makeText(
                        LoginPage.this,
                        "Phone number not found",
                        Toast.LENGTH_SHORT
                ).show();
            }
        });
    }
}