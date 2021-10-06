package com.example.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.shashank.sony.fancygifdialoglib.FancyGifDialog;
import com.shashank.sony.fancygifdialoglib.FancyGifDialogListener;

public class Budget extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_budget);
        Button addBudget;
        Button view = findViewById(R.id.view_remaining);
        addBudget = findViewById(R.id.budget_add_expense);
        TextView viewBudget = findViewById(R.id.textViewShowB);




        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent view_remaining = new Intent(Budget.this,view_remaining.class);
                startActivity(view_remaining);
            }
        });




        addBudget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText budget;
                budget = findViewById(R.id.budget_text);
                float addBudgetAmount;
                addBudgetAmount = Float.parseFloat(budget.getText().toString());
                BudgetDB budgetDB = new BudgetDB();
                budgetDB.setAmount(addBudgetAmount);
                DBHelper db = new DBHelper(Budget.this);
                db.add_Budget(budgetDB);
                Toast.makeText(Budget.this, "Added Successfully", Toast.LENGTH_SHORT).show();


//                editor.putFloat("budget",addBudgetAmount);
//                editor.apply();
//                float budgetN;
//                if(pref.contains("budget")){
//                    budgetN = pref.getFloat("budget",0.0f);
//                    viewBudget.setText("Total Budget is  "+budgetN+"/-");
//                }





            }
        });
    }
}