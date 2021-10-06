package com.example.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class AddExpense extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_expense);


        Button button;
        Button showData;
        button = findViewById(R.id.showData);
        showData = findViewById(R.id.showData);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                SharedPreferences pref = getSharedPreferences("addExpense",MODE_PRIVATE);
//                SharedPreferences.Editor editor = pref.edit();
                String title, comment, category;
                float amount;
                EditText etitle = findViewById(R.id.etitle);
                EditText ecomment = findViewById(R.id.ecomment);
                EditText ecategory = findViewById(R.id.ecategory);
                EditText eamount = findViewById(R.id.eamount);
                title = etitle.getText().toString();
                comment = ecomment.getText().toString();
                category = ecategory.getText().toString();
                amount = Float.parseFloat(eamount.getText().toString());

                Expense expense = new Expense();
                expense.setTitle(title);
                expense.setCategory(category);
                expense.setComment(comment);
                expense.setAmount(amount);

                DBHelper db = new DBHelper(AddExpense.this);
                db.addExpense(expense);
                Toast.makeText(AddExpense.this, "Data Added Successfully", Toast.LENGTH_SHORT).show();

//                editor.putString("ae_title",title);
//                editor.putString("ae_comment",comment);
//                editor.putString("ae_category",category);
//                editor.putFloat("ae_amount",amount);
//                float t_expences=0.0f;
//                if(pref.contains("t_expences")){
//                    t_expences= pref.getFloat("t_expences",0.0f);
//                    t_expences=t_expences+amount;
//                    editor.putFloat("t_expences",t_expences);
//                }
//                else {
//                    editor.putFloat("t_expences",amount);
//                }
//                editor.apply();
//
//                String a_title,a_comment,a_category = "";
//                float a_amount;
//                a_title = pref.getString("ae_title",null);
//                a_comment = pref.getString("ae_comment",null);
//                a_category = pref.getString("ae_category",null);
//                a_amount = pref.getFloat("ae_amount",0.0f);
//
//                Toast.makeText(AddExpense.this, "Item details are "+ a_title +"\n"+a_comment + "\n" + a_category + "\n" + a_amount +"\n Total is "+t_expences, Toast.LENGTH_SHORT).show();
            }


        });

        showData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBHelper db = new DBHelper(AddExpense.this);
                db.fetchData();
                Toast.makeText(AddExpense.this, "Executed Successfully", Toast.LENGTH_SHORT).show();
            }
        });

    }


}