package com.example.healthcare;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    EditText etName, etEmail, etMobile, etPassword, etConfirmPassword;
    Button btnRegister;
    TextView tvLogin;

    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etName = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etEmail);
        etMobile = findViewById(R.id.etMobile);
        etPassword = findViewById(R.id.etPassword);
        etConfirmPassword = findViewById(R.id.etConfirmPassword);

        btnRegister = findViewById(R.id.btnRegister);
        tvLogin = findViewById(R.id.tvLogin);

        databaseHelper = new DatabaseHelper(this);

        btnRegister.setOnClickListener(v -> {

            String name = etName.getText().toString().trim();
            String email = etEmail.getText().toString().trim();
            String mobile = etMobile.getText().toString().trim();
            String password = etPassword.getText().toString().trim();
            String confirmPassword =
                    etConfirmPassword.getText().toString().trim();

            if (name.isEmpty() || email.isEmpty() || mobile.isEmpty()
                    || password.isEmpty() || confirmPassword.isEmpty()) {

                Toast.makeText(this,
                        "Please fill all fields",
                        Toast.LENGTH_SHORT).show();

            } else if (!password.equals(confirmPassword)) {

                Toast.makeText(this,
                        "Passwords do not match",
                        Toast.LENGTH_SHORT).show();

            } else {

                boolean inserted = databaseHelper.insertUser(
                        name, email, mobile, password
                );

                if (inserted) {

                    Toast.makeText(this,
                            "Registration Successful",
                            Toast.LENGTH_SHORT).show();

                    Intent intent =
                            new Intent(RegisterActivity.this,
                                    LoginActivity.class);

                    startActivity(intent);
                    finish();

                } else {

                    Toast.makeText(this,
                            "Registration Failed",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        tvLogin.setOnClickListener(v -> {

            Intent intent =
                    new Intent(RegisterActivity.this,
                            LoginActivity.class);

            startActivity(intent);
            finish();
        });
    }
}