package com.example.iotproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextClock;

public class timezone extends AppCompatActivity {
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timezone);
    }

    public void onClickVietNam(View view) {
        TextClock clock = findViewById(R.id.my_clock);
        clock.setTimeZone("Asia/Ho_Chi_Minh");
        imageView = (ImageView)findViewById(R.id.vn_map);
        imageView.setVisibility(View.VISIBLE);
        imageView = (ImageView)findViewById(R.id.us_map);
        imageView.setVisibility(View.INVISIBLE);
        imageView = (ImageView)findViewById(R.id.uk_map);
        imageView.setVisibility(View.INVISIBLE);
        imageView = (ImageView)findViewById(R.id.jp_map);
        imageView.setVisibility(View.INVISIBLE);
    }

    public void onClickUS(View view) {
        TextClock clock = findViewById(R.id.my_clock);
        clock.setTimeZone("America/New_York");
        imageView = (ImageView)findViewById(R.id.vn_map);
        imageView.setVisibility(View.INVISIBLE);
        imageView = (ImageView)findViewById(R.id.us_map);
        imageView.setVisibility(View.VISIBLE);
        imageView = (ImageView)findViewById(R.id.uk_map);
        imageView.setVisibility(View.INVISIBLE);
        imageView = (ImageView)findViewById(R.id.jp_map);
        imageView.setVisibility(View.INVISIBLE);
    }

    public void onClickUK(View view) {
        TextClock clock = findViewById(R.id.my_clock);
        clock.setTimeZone("Europe/London");
        imageView = (ImageView)findViewById(R.id.vn_map);
        imageView.setVisibility(View.INVISIBLE);
        imageView = (ImageView)findViewById(R.id.us_map);
        imageView.setVisibility(View.INVISIBLE);
        imageView = (ImageView)findViewById(R.id.uk_map);
        imageView.setVisibility(View.VISIBLE);
        imageView = (ImageView)findViewById(R.id.jp_map);
        imageView.setVisibility(View.INVISIBLE);
    }

    public void onClickJP(View view) {
        TextClock clock = findViewById(R.id.my_clock);
        clock.setTimeZone("Asia/Tokyo");
        imageView = (ImageView)findViewById(R.id.vn_map);
        imageView.setVisibility(View.INVISIBLE);
        imageView = (ImageView)findViewById(R.id.us_map);
        imageView.setVisibility(View.INVISIBLE);
        imageView = (ImageView)findViewById(R.id.uk_map);
        imageView.setVisibility(View.INVISIBLE);
        imageView = (ImageView)findViewById(R.id.jp_map);
        imageView.setVisibility(View.VISIBLE);
    }
}