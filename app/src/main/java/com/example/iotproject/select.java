package com.example.iotproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class select extends AppCompatActivity {

    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);

        Button timezone = findViewById(R.id.btn_timezone);
        timezone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(select.this, timezone.class));
            }
        });

        Button chart = findViewById(R.id.btn_chart);
        chart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(select.this, chart.class));
            }
        });

        Button temp = findViewById(R.id.btn_ther);
        temp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(select.this, tempurate.class));
            }
        });

        Button humid = findViewById(R.id.btn_humid);
        humid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(select.this, humid.class));
            }
        });

    }

}