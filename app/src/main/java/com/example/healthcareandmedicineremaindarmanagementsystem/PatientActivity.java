package com.example.healthcare;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class PatientActivity extends AppCompatActivity {

    Button btnPatientProfile;
    Button btnFindDoctor;
    Button btnPatientAppointments;
    Button btnMedicineReminder;
    Button btnLabTests;
    Button btnMedicalReports;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient);

        // Connect buttons
        btnPatientProfile = findViewById(R.id.btnPatientProfile);
        btnFindDoctor = findViewById(R.id.btnFindDoctor);
        btnPatientAppointments = findViewById(R.id.btnPatientAppointments);
        btnMedicineReminder = findViewById(R.id.btnMedicineReminder);
        btnLabTests = findViewById(R.id.btnLabTests);
        btnMedicalReports = findViewById(R.id.btnMedicalReports);

        // My Profile
        btnPatientProfile.setOnClickListener(v -> {
            Intent intent = new Intent(
                    PatientActivity.this,
                    PatientProfileActivity.class
            );
            startActivity(intent);
        });

        // Find / Book Doctor
        btnFindDoctor.setOnClickListener(v -> {
            Intent intent = new Intent(
                    PatientActivity.this,
                    FindDoctorActivity.class
            );
            startActivity(intent);
        });

        // My Appointments
        btnPatientAppointments.setOnClickListener(v -> {
            Intent intent = new Intent(
                    PatientActivity.this,
                    MyAppointmentsActivity.class
            );
            startActivity(intent);
        });

        // Medicine Reminder
        btnMedicineReminder.setOnClickListener(v -> {
            // Medicine Reminder page will be added next
        });

        // Lab Test Booking
        btnLabTests.setOnClickListener(v -> {
            // Lab Test page will be added next
        });

        // Medical Reports
        btnMedicalReports.setOnClickListener(v -> {
            // Medical Reports page will be added next
        });
    }
}