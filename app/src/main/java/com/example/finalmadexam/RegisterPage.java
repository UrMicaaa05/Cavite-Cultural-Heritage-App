package com.example.finalmadexam;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.hbb20.CountryCodePicker;

import java.util.Calendar;

public class RegisterPage extends AppCompatActivity {

    private EditText etName, etDob, etAadhar, etCity,
            etState, etPincode, etPhone;

    private Button btnSubmit;
    private LinearLayout btnBack;

    private DBHelper myDB;
    private CountryCodePicker ccp;

    private CheckBox showPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page);

        // INIT VIEWS
        etName = findViewById(R.id.name);
        etDob = findViewById(R.id.dob);
        etAadhar = findViewById(R.id.aadhar);
        etCity = findViewById(R.id.city);
        etState = findViewById(R.id.state);
        etPincode = findViewById(R.id.pincode);
        etPhone = findViewById(R.id.phonenumber);

        btnSubmit = findViewById(R.id.submit);
        btnBack = findViewById(R.id.btn_back);

        ccp = findViewById(R.id.countryCodePicker);
        myDB = new DBHelper(this);
        showPassword = findViewById(R.id.cbShowPassword);

        showPassword.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                etAadhar.setInputType(android.text.InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
            } else {
                etAadhar.setInputType(android.text.InputType.TYPE_CLASS_TEXT |
                        android.text.InputType.TYPE_TEXT_VARIATION_PASSWORD);
            }

            etAadhar.setSelection(etAadhar.length());
        });

        btnBack.setOnClickListener(v -> {
            finish();
            overridePendingTransition(
                    android.R.anim.fade_in,
                    android.R.anim.fade_out
            );
        });

        etDob.setOnClickListener(v -> {

            Calendar calendar = Calendar.getInstance();

            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            int day = calendar.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog datePickerDialog =
                    new DatePickerDialog(
                            RegisterPage.this,
                            (view, selectedYear, selectedMonth, selectedDay) -> {

                                String dob =
                                        (selectedMonth + 1) + "/" +
                                                selectedDay + "/" +
                                                selectedYear;

                                etDob.setText(dob);
                            },
                            year, month, day
                    );

            datePickerDialog.show();
        });


        btnSubmit.setOnClickListener(view -> {

            String namee = etName.getText().toString().trim();
            String dobb = etDob.getText().toString().trim();
            String aadharr = etAadhar.getText().toString().trim();
            String cityy = etCity.getText().toString().trim();
            String statee = etState.getText().toString().trim();
            String pincodee = etPincode.getText().toString().trim();
            String phoneNumber = etPhone.getText().toString().trim();

            String fullPhoneNumber = "+" + ccp.getSelectedCountryCode() + phoneNumber;

            // EMPTY CHECK
            if (namee.isEmpty() || dobb.isEmpty() || aadharr.isEmpty() ||
                    cityy.isEmpty() || statee.isEmpty() ||
                    pincodee.isEmpty() || phoneNumber.isEmpty()) {

                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                return;
            }

            if (phoneNumber.length() < 10) {
                Toast.makeText(this, "Invalid phone number", Toast.LENGTH_SHORT).show();
                return;
            }
            if (aadharr.length() < 8) {
                Toast.makeText(this, "Password must be at least 8 characters", Toast.LENGTH_SHORT).show();
                return;
            }

            if (!aadharr.matches(".*[a-zA-Z].*")) {
                Toast.makeText(this, "Password must contain at least one letter", Toast.LENGTH_SHORT).show();
                return;
            }

            if (pincodee.length() < 4 || pincodee.length() > 6) {
                Toast.makeText(this, "Pincode must be 4 to 6 digits", Toast.LENGTH_SHORT).show();
                return;
            }

            if (myDB.checkPhone(fullPhoneNumber)) {
                Toast.makeText(this, "Phone already registered", Toast.LENGTH_SHORT).show();
                return;
            }

            if (myDB.checkaadhar(aadharr)) {
                Toast.makeText(this, "Password already used", Toast.LENGTH_SHORT).show();
                return;
            }

            boolean res = myDB.insertData(
                    namee, dobb, aadharr, cityy,
                    statee, pincodee, fullPhoneNumber
            );

            if (res) {
                Toast.makeText(this, "Registration Successful!", Toast.LENGTH_SHORT).show();

                startActivity(new Intent(this, LoginPage.class));
                finish();
            } else {
                Toast.makeText(this, "Registration Failed", Toast.LENGTH_SHORT).show();
            }
        });
    }
}