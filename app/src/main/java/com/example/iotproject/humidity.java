package com.example.iotproject;

import android.hardware.Sensor;

public interface humidity {
    void onAccuracyChanged(Sensor sensor, int accuracy);
}
