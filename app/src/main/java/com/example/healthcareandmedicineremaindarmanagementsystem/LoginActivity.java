package com.example.healthcare;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    EditText etLoginEmail, etLoginPassword;
    Button btnLogin;
    TextView tvForgotPassword, tvCreateAccount;

    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etLoginEmail = findViewById(R.id.etLoginEmail);
        etLoginPassword = findViewById(R.id.etLoginPassword);

        btnLogin = findViewById(R.id.btnLogin);
        tvForgotPassword = findViewById(R.id.tvForgotPassword);
        tvCreateAccount = findViewById(R.id.tvCreateAccount);

        databaseHelper = new DatabaseHelper(this);

        // Login Button
        btnLogin.setOnClickListener(v -> {

            String email = etLoginEmail.getText().toString().trim();
            String password = etLoginPassword.getText().toString().trim();

            if (email.isEmpty() || password.isEmpty()) {

                Toast.makeText(this,
                        "Please enter email and password",
                        Toast.LENGTH_SHORT).show();

                return;
            }

            Cursor cursor = databaseHelper.checkLogin(email, password);
            if (databaseHelper.checkLogin(email, password)) {

                Intent intent = new Intent(LoginActivity.this, DashboardActivity.class);
                startActivity(intent);
                finish();

            } else {
                Toast.makeText(this,
                        "Invalid Email or Password",
                        Toast.LENGTH_SHORT).show();
            }

            if (cursor != null && cursor.moveToFirst()) {

                Toast.makeText(this,
                        "Login Successful",
                        Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(
                        LoginActivity.this,
                        DashboardActivity.class
                );

                startActivity(intent);
                finish();

            } else {

                Toast.makeText(this,
                        "Invalid Email or Password",
                        Toast.LENGTH_SHORT).show();
            }

            if (cursor != null) {
                cursor.close();
            }
        });

        // Create Account
        tvCreateAccount.setOnClickListener(v -> {

            Intent intent = new Intent(
                    LoginActivity.this,
                    com.example.healthcare.RegisterActivity.class
            );

            startActivity(intent);
        });

        // Forgot Password
        tvForgotPassword.setOnClickListener(v -> {

            Intent intent = new Intent(
                    LoginActivity.this,
                    ForgotPasswordActivity.class
            );

            startActivity(intent);
        });
    }
}
