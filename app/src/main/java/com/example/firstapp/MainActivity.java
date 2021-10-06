package com.example.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button add_expense;
    Button reports;
    Button budget;
    Button analysis;
    Button home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        database d = new database(this);
        SQLiteDatabase db = d.getReadableDatabase();



    }

    public void  addExpense(View view){
        Intent expense = new Intent(this,AddExpense.class);
        startActivity(expense);

    }

    public void  report(View view){
        Intent report = new Intent(this,Report.class);
        startActivity(report);

    }

    public void  budget(View view){
        Intent budget = new Intent(this,Budget.class);
        startActivity(budget);

    }

    public void  analysis(View view){
        Intent analysis = new Intent(this,Analysis.class);
        startActivity(analysis);

    }

//    public void  home(View view){
//        Intent home = new Intent(this,MainActivity.class);
//        startActivity(home);
//
//    }

}