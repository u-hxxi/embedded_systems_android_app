package com.example.iotproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class tempurate extends AppCompatActivity implements SensorEventListener {

    private TextView textView;
    private SensorManager sensorManager;
    private Sensor tempSensor;
    private boolean isTemperatureSensorAvailable;
    private AlertDialog dialog;
    private Context context;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tempurate);

        textView = findViewById(R.id.textView);
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        if(sensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE)!=null) {
            tempSensor = sensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE);
            isTemperatureSensorAvailable = true;
        } else {
            textView.setText("Temperature Sensor is not Available!");
            isTemperatureSensorAvailable = false;
        }
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        float tempinC = (float) event.values[0];
        float tempinF = (float) (tempinC*1.8 + 32);

        textView.setText(tempinC + "°C / " +tempinF + "°F " );
        if ( 20 <= tempinC && tempinC <= 35 ) {
            CharSequence text = "Temperature stability!";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(this, text, duration);
            toast.show();
            imageView = (ImageView)findViewById(R.id.temp_hot3);
            imageView.setVisibility(View.INVISIBLE);
            imageView = (ImageView)findViewById(R.id.temp_hot2);
            imageView.setVisibility(View.VISIBLE);
            imageView = (ImageView)findViewById(R.id.temp_hot1);
            imageView.setVisibility(View.INVISIBLE);
            imageView = (ImageView)findViewById(R.id.temp_hot);
            imageView.setVisibility(View.INVISIBLE);
            imageView = (ImageView)findViewById(R.id.temp_fresh);
            imageView.setVisibility(View.VISIBLE);
            imageView = (ImageView)findViewById(R.id.temp_snow);
            imageView.setVisibility(View.INVISIBLE);
        } else if (35 < tempinC && tempinC <= 40) {
            CharSequence text = "Temperature is slightly high!";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(this, text, duration);
            toast.show();
            imageView = (ImageView)findViewById(R.id.temp_hot3);
            imageView.setVisibility(View.INVISIBLE);
            imageView = (ImageView)findViewById(R.id.temp_hot2);
            imageView.setVisibility(View.VISIBLE);
            imageView = (ImageView)findViewById(R.id.temp_hot1);
            imageView.setVisibility(View.INVISIBLE);
            imageView = (ImageView)findViewById(R.id.temp_hot);
            imageView.setVisibility(View.VISIBLE);
            imageView = (ImageView)findViewById(R.id.temp_fresh);
            imageView.setVisibility(View.INVISIBLE);
            imageView = (ImageView)findViewById(R.id.temp_snow);
            imageView.setVisibility(View.INVISIBLE);
        } else if (tempinC > 40 ) {
            imageView = (ImageView)findViewById(R.id.temp_hot3);
            imageView.setVisibility(View.VISIBLE);
            imageView = (ImageView)findViewById(R.id.temp_hot2);
            imageView.setVisibility(View.INVISIBLE);
            imageView = (ImageView)findViewById(R.id.temp_hot1);
            imageView.setVisibility(View.INVISIBLE);
            imageView = (ImageView)findViewById(R.id.temp_hot);
            imageView.setVisibility(View.VISIBLE);
            imageView = (ImageView)findViewById(R.id.temp_fresh);
            imageView.setVisibility(View.INVISIBLE);
            imageView = (ImageView)findViewById(R.id.temp_snow);
            imageView.setVisibility(View.INVISIBLE);
            AlertDialog alertDialog = new AlertDialog.Builder(tempurate.this).create();
            alertDialog.setTitle("WARNING");
            alertDialog.setIcon(R.drawable.hot);
            alertDialog.setMessage("High temperature \n The heat has increased to " + tempinC + "°C");
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
            alertDialog.show();
        } else if ( 10 <= tempinC && tempinC < 20) {
            CharSequence text = "Temperature is slightly low!";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(this, text, duration);
            toast.show();
            imageView = (ImageView)findViewById(R.id.temp_hot1);
            imageView.setVisibility(View.VISIBLE);
            imageView = (ImageView)findViewById(R.id.temp_hot2);
            imageView.setVisibility(View.INVISIBLE);
            imageView = (ImageView)findViewById(R.id.temp_hot3);
            imageView.setVisibility(View.INVISIBLE);
            imageView = (ImageView)findViewById(R.id.temp_hot);
            imageView.setVisibility(View.INVISIBLE);
            imageView = (ImageView)findViewById(R.id.temp_fresh);
            imageView.setVisibility(View.INVISIBLE);
            imageView = (ImageView)findViewById(R.id.temp_snow);
            imageView.setVisibility(View.VISIBLE);
        } else if ( tempinC < 10) {
            imageView = (ImageView)findViewById(R.id.temp_hot1);
            imageView.setVisibility(View.VISIBLE);
            imageView = (ImageView)findViewById(R.id.temp_hot2);
            imageView.setVisibility(View.INVISIBLE);
            imageView = (ImageView)findViewById(R.id.temp_hot3);
            imageView.setVisibility(View.INVISIBLE);
            imageView = (ImageView)findViewById(R.id.temp_hot);
            imageView.setVisibility(View.INVISIBLE);
            imageView = (ImageView)findViewById(R.id.temp_fresh);
            imageView.setVisibility(View.INVISIBLE);
            imageView = (ImageView)findViewById(R.id.temp_snow);
            imageView.setVisibility(View.VISIBLE);
            AlertDialog alertDialog = new AlertDialog.Builder(tempurate.this).create();
            alertDialog.setTitle("WARNING");
            alertDialog.setIcon(R.drawable.cold);
            alertDialog.setMessage("Low temperature \n The temperature has decreased to " + tempinC + "°C");
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
            alertDialog.show();

        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        if (sensor.getType() == Sensor.TYPE_AMBIENT_TEMPERATURE) {
            if (accuracy == SensorManager.SENSOR_STATUS_ACCURACY_HIGH) {
                // Xử lý khi độ chính xác cao
            } else if (accuracy == SensorManager.SENSOR_STATUS_ACCURACY_MEDIUM) {
                // Xử lý khi độ chính xác trung bình
            } else if (accuracy == SensorManager.SENSOR_STATUS_ACCURACY_LOW) {
                // Xử lý khi độ chính xác thấp
            } else if (accuracy == SensorManager.SENSOR_STATUS_UNRELIABLE) {
                // Xử lý khi độ chính xác không đáng tin cậy
            }
        } else if (sensor.getType() == Sensor.TYPE_RELATIVE_HUMIDITY) {
            if (sensor.getType() == Sensor.TYPE_RELATIVE_HUMIDITY) {
                if (accuracy == SensorManager.SENSOR_STATUS_ACCURACY_HIGH) {
                    // Xử lý khi độ chính xác cao
                } else if (accuracy == SensorManager.SENSOR_STATUS_ACCURACY_MEDIUM) {
                    // Xử lý khi độ chính xác trung bình
                } else if (accuracy == SensorManager.SENSOR_STATUS_ACCURACY_LOW) {
                    // Xử lý khi độ chính xác thấp
                } else if (accuracy == SensorManager.SENSOR_STATUS_UNRELIABLE) {
                    // Xử lý khi độ chính xác không đáng tin cậy
                }
            }
        }
    }


    @Override
    protected void onResume() {
        super.onResume();
        if(isTemperatureSensorAvailable) {
            sensorManager.registerListener(this, tempSensor, SensorManager.SENSOR_DELAY_NORMAL);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if(isTemperatureSensorAvailable){
            sensorManager.unregisterListener(this);
        }
    }
}