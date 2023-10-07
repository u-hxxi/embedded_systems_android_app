package com.example.iotproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class humid extends AppCompatActivity implements SensorEventListener {

    private TextView textView;
    private SensorManager sensorManager;
    private Sensor humidSensor;
    private boolean isHumiditySensorAvailable;
    private AlertDialog dialog;
    private Context context;
    private ImageView imageView;
    private TextView tvHumid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_humid);
        textView = findViewById(R.id.textView);
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        if(sensorManager.getDefaultSensor(Sensor.TYPE_RELATIVE_HUMIDITY)!=null) {
            humidSensor = sensorManager.getDefaultSensor(Sensor.TYPE_RELATIVE_HUMIDITY);
            isHumiditySensorAvailable = true;

        } else {
            textView.setText("Humidity Sensor is not Available!");
            isHumiditySensorAvailable = false;
        }
    }

    public void onSensorChanged(SensorEvent event) {

        float humid = (float) event.values[0];
        textView.setText( humid + "%" );

        if ( 40 < humid && humid < 70 ) {
            CharSequence text = "Humidity stability!";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(this, text, duration);
            toast.show();
            imageView = (ImageView)findViewById(R.id.humid_low);
            imageView.setVisibility(View.INVISIBLE);
            imageView = (ImageView)findViewById(R.id.humid_mid);
            imageView.setVisibility(View.VISIBLE);
            imageView = (ImageView)findViewById(R.id.humid_high);
            imageView.setVisibility(View.INVISIBLE);
            tvHumid = findViewById(R.id.wet);
            tvHumid.setVisibility(View.INVISIBLE);
            tvHumid = findViewById(R.id.good);
            tvHumid.setVisibility(View.VISIBLE);
            tvHumid = findViewById(R.id.dry);
            tvHumid.setVisibility(View.INVISIBLE);
            imageView = (ImageView)findViewById(R.id.dry_iv);
            imageView.setVisibility(View.INVISIBLE);
            imageView = (ImageView)findViewById(R.id.good_iv);
            imageView.setVisibility(View.VISIBLE);
            imageView = (ImageView)findViewById(R.id.wet_iv);
            imageView.setVisibility(View.INVISIBLE);
        } else if ( humid > 70) {
            CharSequence text = "High humidity";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(this, text, duration);
            toast.show();
            imageView = (ImageView)findViewById(R.id.humid_low);
            imageView.setVisibility(View.INVISIBLE);
            imageView = (ImageView)findViewById(R.id.humid_mid);
            imageView.setVisibility(View.INVISIBLE);
            imageView = (ImageView)findViewById(R.id.humid_high);
            imageView.setVisibility(View.VISIBLE);
            tvHumid = findViewById(R.id.wet);
            tvHumid.setVisibility(View.VISIBLE);
            tvHumid = findViewById(R.id.good);
            tvHumid.setVisibility(View.INVISIBLE);
            tvHumid = findViewById(R.id.dry);
            tvHumid.setVisibility(View.INVISIBLE);
            imageView = (ImageView)findViewById(R.id.dry_iv);
            imageView.setVisibility(View.INVISIBLE);
            imageView = (ImageView)findViewById(R.id.good_iv);
            imageView.setVisibility(View.INVISIBLE);
            imageView = (ImageView)findViewById(R.id.wet_iv);
            imageView.setVisibility(View.VISIBLE);
        } else if ( 40 > humid ) {
            CharSequence text = "Low humidity";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(this, text, duration);
            toast.show();
            imageView = (ImageView)findViewById(R.id.humid_low);
            imageView.setVisibility(View.VISIBLE);
            imageView = (ImageView)findViewById(R.id.humid_mid);
            imageView.setVisibility(View.INVISIBLE);
            imageView = (ImageView)findViewById(R.id.humid_high);
            imageView.setVisibility(View.INVISIBLE);
            tvHumid = findViewById(R.id.wet);
            tvHumid.setVisibility(View.INVISIBLE);
            tvHumid = findViewById(R.id.good);
            tvHumid.setVisibility(View.INVISIBLE);
            tvHumid = findViewById(R.id.dry);
            tvHumid.setVisibility(View.VISIBLE);
            imageView = (ImageView)findViewById(R.id.dry_iv);
            imageView.setVisibility(View.VISIBLE);
            imageView = (ImageView)findViewById(R.id.good_iv);
            imageView.setVisibility(View.INVISIBLE);
            imageView = (ImageView)findViewById(R.id.wet_iv);
            imageView.setVisibility(View.INVISIBLE);
        }
    }



    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    @Override
    protected void onResume() {
        super.onResume();
        if(isHumiditySensorAvailable) {
            sensorManager.registerListener((SensorEventListener) this, humidSensor, SensorManager.SENSOR_DELAY_NORMAL);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if(isHumiditySensorAvailable) {
            sensorManager.unregisterListener(this);
        }
    }
}