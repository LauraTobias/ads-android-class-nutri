package com.example.nutri.models;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class NutriTableDAO {

    SQLiteDatabase database;

    public NutriTableDAO(Context context) {
        database = context.openOrCreateDatabase("nutri_db", context.MODE_PRIVATE, null);

        try { openArchiveSQL(context); }
        catch (IOException e) { e.printStackTrace(); }
    }

    private void openArchiveSQL(Context context) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(context.getAssets().open("taco_4___edicao.sql"), "UTF-8"));
        String line;

        while ((line = reader.readLine()) != null) {
            String lineSQL = line;
            this.database.execSQL(lineSQL);
        }
    }

    public ArrayList<Food> getFoods() {

        ArrayList<Food> foodList = new ArrayList<>();

        Cursor cursor;
        cursor = database.rawQuery("SELECT * FROM taco_4", null,null);
        cursor.moveToFirst();

        while(!cursor.isAfterLast())
        {
            Food food = new Food();
            food.setCategory(cursor.getString(cursor.getColumnIndexOrThrow("Category")));
            food.setName(cursor.getString(cursor.getColumnIndexOrThrow("Name")));
            foodList.add(food);
            cursor.moveToNext();
        }

        return foodList;
    }
}