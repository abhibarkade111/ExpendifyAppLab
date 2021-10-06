package com.example.firstapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context) {
        super(context, "ExpendifyDB", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String expenseTbl = "CREATE TABLE \"Expense\" (\n" +
                "\t\"id\"\tINTEGER NOT NULL,\n" +
                "\t\"title\"\tTEXT NOT NULL,\n" +
                "\t\"category\"\tTEXT NOT NULL,\n" +
                "\t\"comment\"\tTEXT,\n" +
                "\t\"amount\"\tINTEGER NOT NULL,\n" +
                "\tPRIMARY KEY(\"id\" AUTOINCREMENT)\n" +
                ");";
        db.execSQL(expenseTbl);

        String budgetTbl = "CREATE TABLE \"BudgetTbl\" (\n" +
                "\t\"id\"\tINTEGER NOT NULL,\n" +
                "\t\"budgetAmount\"\tINTEGER NOT NULL,\n" +
                "\tPRIMARY KEY(\"id\" AUTOINCREMENT)\n" +
                ");";
        db.execSQL(budgetTbl);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public  void addExpense(Expense expense){
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put("title",expense.getTitle());
        values.put("category",expense.getCategory());
        values.put("comment",expense.getComment());
        values.put("amount",expense.getAmount());
        db.insert("Expense",null,values);
        db.close();

    }

    public  void add_Budget(BudgetDB budgetDB){
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put("budgetAmount",budgetDB.getAmount());
        db.insert("BudgetTbl",null,values);
        db.close();
    }

    public void fetchData(){
        Log.d("TAG","Hello bhaii mai tag huin");
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from Expense", null, null);
        while (cursor.moveToFirst()){
            Log.d("TAG","Hey i am in loop");
            Log.d("TAG","Data from Expense table is \n"+"Title is :"+cursor.getString(1)+"\n category is :" + cursor.getString(2)+"\n comment is :" + cursor.getString(3)+"\n amount is :" + cursor.getString(4));
        }
        cursor.close();
    }
}
