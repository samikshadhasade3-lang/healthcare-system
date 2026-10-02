package com.example.healthcare;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class DashboardActivity extends AppCompatActivity {

    Button btnDoctor, btnPatient, btnLaboratory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        btnDoctor = findViewById(R.id.btnDoctor);
        btnPatient = findViewById(R.id.btnPatient);
        btnLaboratory = findViewById(R.id.btnLaboratory);

        btnDoctor.setOnClickListener(v -> {
            Intent intent = new Intent(DashboardActivity.this, DoctorActivity.class);
            startActivity(intent);
        });

        btnPatient.setOnClickListener(v -> {
            Intent intent = new Intent(DashboardActivity.this, PatientActivity.class);
            startActivity(intent);
        });

        btnLaboratory.setOnClickListener(v -> {
            Intent intent = new Intent(DashboardActivity.this, LaboratoryActivity.class);
            startActivity(intent);
        });
    }
}