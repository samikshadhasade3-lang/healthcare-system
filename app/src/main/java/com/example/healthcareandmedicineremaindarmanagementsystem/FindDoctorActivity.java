package com.example.healthcare;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class FindDoctorActivity extends AppCompatActivity {

    Button btnSearchDoctor;
    Button btnDoctor1;
    Button btnDoctor2;
    Button btnDoctor3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_doctor);

        btnSearchDoctor = findViewById(R.id.btnSearchDoctor);
        btnDoctor1 = findViewById(R.id.btnDoctor1);
        btnDoctor2 = findViewById(R.id.btnDoctor2);
        btnDoctor3 = findViewById(R.id.btnDoctor3);

        // Doctor 1
        btnDoctor1.setOnClickListener(v -> {
            Intent intent = new Intent(
                    FindDoctorActivity.this,
                    BookDoctorActivity.class
            );
            startActivity(intent);
        });

        // Doctor 2
        btnDoctor2.setOnClickListener(v -> {
            Intent intent = new Intent(
                    FindDoctorActivity.this,
                    BookDoctorActivity.class
            );
            startActivity(intent);
        });

        // Doctor 3
        btnDoctor3.setOnClickListener(v -> {
            Intent intent = new Intent(
                    FindDoctorActivity.this,
                    BookDoctorActivity.class
            );
            startActivity(intent);
        });
    }
}
