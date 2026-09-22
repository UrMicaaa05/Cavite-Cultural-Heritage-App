package com.example.finalmadexam;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class RegisterPage extends AppCompatActivity {

    private EditText    etName, etDob, etAadhar, etCity, etState, etPincode, etPhone;
    private Button      btnSubmit;
    private LinearLayout btnBack;
    private DBHelper    myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page);

        etName    = findViewById(R.id.name);
        etDob     = findViewById(R.id.dob);
        etAadhar  = findViewById(R.id.aadhar);
        etCity    = findViewById(R.id.city);
        etState   = findViewById(R.id.state);
        etPincode = findViewById(R.id.pincode);
        etPhone   = findViewById(R.id.phonenumber);
        btnSubmit = findViewById(R.id.submit);
        btnBack   = findViewById(R.id.btn_back);

        myDB = new DBHelper(this);

        btnBack.setOnClickListener(v -> {
            finish();
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String namee    = etName.getText().toString().trim();
                String dobb     = etDob.getText().toString().trim();
                String aadharr  = etAadhar.getText().toString().trim();
                String cityy    = etCity.getText().toString().trim();
                String statee   = etState.getText().toString().trim();
                String pincodee = etPincode.getText().toString().trim();
                String phonee   = etPhone.getText().toString().trim();

                if (namee.isEmpty() || dobb.isEmpty() || aadharr.isEmpty() ||
                        cityy.isEmpty() || statee.isEmpty() || pincodee.isEmpty() ||
                        phonee.isEmpty()) {
                    Toast.makeText(RegisterPage.this,
                            "Please fill all the fields",
                            Toast.LENGTH_SHORT).show();
                    return;
                }

                if (myDB.checkPhone(phonee)) {
                    Toast.makeText(RegisterPage.this,
                            "Phone number already registered. Please login.",
                            Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(RegisterPage.this, LoginPage.class));
                    finish();
                    return;
                }

                if (myDB.checkaadhar(aadharr)) {
                    Toast.makeText(RegisterPage.this,
                            "Passcode already in use. Please login.",
                            Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(RegisterPage.this, LoginPage.class));
                    finish();
                    return;
                }

                Boolean res = myDB.insertData(namee, dobb, aadharr,
                        cityy, statee, pincodee, phonee);
                if (res) {
                    Toast.makeText(RegisterPage.this,
                            "Registration Successful!",
                            Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(RegisterPage.this, LoginPage.class));
                    finish();
                } else {
                    Toast.makeText(RegisterPage.this,
                            "Registration Failed. Please try again.",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}