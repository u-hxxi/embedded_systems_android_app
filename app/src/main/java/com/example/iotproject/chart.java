package com.example.iotproject;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.util.ArrayList;

public class chart extends AppCompatActivity {

    LineChart mpLineChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart);

        mpLineChart = (LineChart) findViewById(R.id.line_chart);
        LineDataSet lineDataTemp = new LineDataSet(dataTemp(), "Temperature");
        LineDataSet lineDataHumid = new LineDataSet(dataHumid(), "Humidity");
        ArrayList<ILineDataSet> dataSets = new ArrayList<>();
        dataSets.add(lineDataTemp);
        lineDataTemp.setColor(Color.RED);
        dataSets.add(lineDataHumid);
        lineDataHumid.setColor(Color.BLUE);

        LineData data = new LineData(dataSets);
        mpLineChart.setData(data);
        mpLineChart.invalidate();
    }

    private ArrayList<Entry> dataTemp()
    {
        ArrayList<Entry> dataVals = new ArrayList<Entry>();
        dataVals.add(new Entry(1,32));
        dataVals.add(new Entry(2,31));
        dataVals.add(new Entry(3,29));
        dataVals.add(new Entry(4,30));
        dataVals.add(new Entry(5,28));
        dataVals.add(new Entry(6,26));

        return dataVals;
    }

    private ArrayList<Entry> dataHumid()
    {
        ArrayList<Entry> dataVals = new ArrayList<Entry>();
        dataVals.add(new Entry(1,77));
        dataVals.add(new Entry(2,70));
        dataVals.add(new Entry(3,70));
        dataVals.add(new Entry(4,65));
        dataVals.add(new Entry(5,80));
        dataVals.add(new Entry(6,60));

        return dataVals;
    }
}