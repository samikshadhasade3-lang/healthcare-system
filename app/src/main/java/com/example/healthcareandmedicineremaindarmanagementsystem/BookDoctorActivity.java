package com.example.healthcare;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class BookDoctorActivity extends AppCompatActivity {

    Button btnBookAppointment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_doctor);

        btnBookAppointment = findViewById(R.id.btnBookAppointment);

        btnBookAppointment.setOnClickListener(v -> {

            Toast.makeText(
                    BookDoctorActivity.this,
                    "Appointment Booked Successfully!",
                    Toast.LENGTH_LONG
            ).show();

        });
    }
}
