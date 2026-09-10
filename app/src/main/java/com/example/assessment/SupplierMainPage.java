package com.example.assessment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SupplierMainPage extends AppCompatActivity {

    CardView cvAddProperty, cvMyProperties, cvBookingRequests;
    ImageButton ibSupplierProfile;
    TextView tvPropertyCount, tvRequestCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_supplier_main_page);

        cvAddProperty = findViewById(R.id.cv_addProperty);
        cvMyProperties = findViewById(R.id.cv_myProperties);
        cvBookingRequests = findViewById(R.id.cv_bookingRequests);
        ibSupplierProfile = findViewById(R.id.ib_supplierProfile);
        tvPropertyCount = findViewById(R.id.tv_propertyCount);
        tvRequestCount = findViewById(R.id.tv_requestCount);

        loadPropertyCount();

        cvAddProperty.setOnClickListener(v -> {
            Toast.makeText(getApplicationContext(),
                    "Add Property Selected",
                    Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(getApplicationContext(),
                    SupplierAddProperty.class);
            startActivity(intent);
        });

        cvMyProperties.setOnClickListener(v -> {
            Toast.makeText(getApplicationContext(),
                    "Loading properties...",
                    Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(getApplicationContext(),
                    SupplierMyProperties.class);
            startActivity(intent);
        });

    }

    public void btnLogout(View view) {
        Toast.makeText(getApplicationContext(),
                "Going Back to Main Page",
                Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(getApplicationContext(),
                Login.class);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadPropertyCount();
    }

    private void loadPropertyCount() {
        SharedPreferences preferences = getSharedPreferences(
                "SupplierData", MODE_PRIVATE );

        int propertyCount = preferences.getInt(
                "propertyCount", 0);

        tvPropertyCount.setText(
                String.valueOf(propertyCount));
    }
}