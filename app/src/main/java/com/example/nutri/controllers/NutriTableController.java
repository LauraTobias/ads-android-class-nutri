package com.example.nutri.controllers;

import android.content.Context;

import com.example.nutri.models.Food;
import com.example.nutri.models.NutriTableDAO;

import java.util.ArrayList;

public class NutriTableController {

    NutriTableDAO nutriTableDao;
    Context mContext;

    public NutriTableController(Context context) {
        this.mContext = context;
        this.nutriTableDao = new NutriTableDAO(mContext);
    }

    public ArrayList<String> getFoodNames() {
        ArrayList<String> foodNames = new ArrayList<>();

        for (Food food : this.nutriTableDao.getFoods()) {
            foodNames.add(food.getName());
        }

        return foodNames;
    }

    public ArrayList<Food> getFoods() {
        return this.nutriTableDao.getFoods();
    }
}