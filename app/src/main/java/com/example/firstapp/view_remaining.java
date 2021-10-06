package com.example.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.ValueDataEntry;
import com.anychart.charts.Pie;
import com.shashank.sony.fancygifdialoglib.FancyGifDialog;
import com.shashank.sony.fancygifdialoglib.FancyGifDialogListener;

import java.util.ArrayList;
import java.util.List;

public class view_remaining extends AppCompatActivity {
    AnyChartView anyChartView;

    Button show;
    TextView default_text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_remaining);




        anyChartView = findViewById(R.id.pieChart);
        setUpPieChart();
        show = findViewById(R.id.button_show);
        default_text= findViewById(R.id.default_text);

        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences pref = getSharedPreferences("addExpense",MODE_PRIVATE);
                SharedPreferences.Editor  editor = pref.edit();
                float total_expence, budget, remaining;
                if(pref.contains("budget")&& pref.contains("t_expences")) {
                    budget = pref.getFloat("budget", 0.0f);
                    total_expence = pref.getFloat("t_expences", 0.0f);
                    remaining = budget - total_expence;
                    default_text.setText("");

                    new FancyGifDialog.Builder(view_remaining.this)
                            .setTitle("Remaining Amount of Budget") // You can also send title like R.string.from_resources
                            .setMessage("This is a remaining budget after expenditure\n The Total Budget is" + budget + "\n And Expenditure is " + total_expence + "\n and remaining amount is " + remaining) // or pass like R.string.description_from_resources
                            .setTitleTextColor(R.color.design_default_color_background)
                            .setDescriptionTextColor(R.color.black)
                            .setNegativeBtnText("Cancel") // or pass it like android.R.string.cancel
                            .setPositiveBtnBackground(R.color.purple_200)
                            .setPositiveBtnText("Ok") // or pass it like android.R.string.ok
                            .setNegativeBtnBackground(R.color.material_on_background_disabled)
                            .setGifResource(R.drawable.gif1)   //Pass your Gif here
                            .isCancellable(true)
                            .OnPositiveClicked(new FancyGifDialogListener() {
                                @Override
                                public void OnClick() {
                                    Toast.makeText(view_remaining.this, "Ok", Toast.LENGTH_SHORT).show();
                                }
                            })
                            .OnNegativeClicked(new FancyGifDialogListener() {
                                @Override
                                public void OnClick() {
                                    Toast.makeText(view_remaining.this, "Cancel", Toast.LENGTH_SHORT).show();
                                }
                            })
                            .build();
                }
                else {
                    default_text.setText("No Any Data Inserted yet");
                }

            }
        });
    }

    void setUpPieChart(){
        SharedPreferences pref = getSharedPreferences("addExpense",MODE_PRIVATE);
        SharedPreferences.Editor  editor = pref.edit();
        float total_expence, budget, remaining;
        if(pref.contains("budget")&& pref.contains("t_expences")){
            budget = pref.getFloat("budget",0.0f);
            total_expence =  pref.getFloat("t_expences",0.0f);
            remaining = budget-total_expence;
            String[] expense ={"Remaining Amount","Expenditure"};
            float [] values = {remaining, total_expence};
            Pie pie = AnyChart.pie();
            List<DataEntry> dataEntries = new ArrayList<>();

            for(int i=0; i <expense.length;i++){
                dataEntries.add(new ValueDataEntry(expense[i],values[i]));
            }
            pie.data(dataEntries);
            anyChartView.setChart(pie);

        }

    }

}