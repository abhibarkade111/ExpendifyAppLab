package com.example.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.ValueDataEntry;
import com.anychart.charts.Pie;

import java.util.ArrayList;
import java.util.List;

public class Report extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);
        TextView report;
        report = findViewById(R.id.report_text2);

        float reportAmount;
        SharedPreferences pref = getSharedPreferences("addExpense",MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        if(pref.contains("t_expences")){
            reportAmount = pref.getFloat("t_expences",0.0f);
            report.setText(reportAmount+"");
        }
    }


}