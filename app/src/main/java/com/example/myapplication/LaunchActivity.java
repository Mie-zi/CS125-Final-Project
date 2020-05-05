package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.google.android.gms.maps.GoogleMap;

public class LaunchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);
        Button start = findViewById(R.id.button);
        final EditText latitude = findViewById(R.id.latitude);
        final EditText longitude = findViewById(R.id.longitude);
        final ToggleButton ns = findViewById(R.id.ns);
        final ToggleButton we = findViewById(R.id.we);
        final Intent intent = new Intent(this, MapsActivity.class);
        start.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (latitude.getText().toString().length() == 0 || longitude.getText().toString().length() == 0) {
                    Toast.makeText(getApplicationContext(), "Invalid Input", Toast.LENGTH_LONG).show();
                    return;
                }
                double lat = Double.parseDouble(latitude.getText().toString());
                double lon = Double.parseDouble(longitude.getText().toString());
                if (lat < 0 || lat > 90 || lon < 0 || lon > 180) {
                    Toast.makeText(getApplicationContext(), "Invalid Input", Toast.LENGTH_LONG).show();
                    return;
                }
                if (ns.isChecked()) {
                    lat = -lat;
                }
                if (we.isChecked()) {
                    lon = -lon;
                }
                intent.putExtra("latitude", lat);
                intent.putExtra("longitude", lon);
                startActivity(intent);
            }
        });
    }
}
