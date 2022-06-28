package com.example.nutri.models;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.nutri.R;
import com.example.nutri.controllers.NutriTableController;

public class ShowFoodActivity extends AppCompatActivity {

    NutriTableController nutriTableController;
    Food food;

    TextView txtCategory;
    TextView txtFood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_food);

        int foodId = getIntent().getExtras().getInt("id");

        this.nutriTableController = new NutriTableController(getBaseContext());
        this.food = nutriTableController.getFoods().get(foodId);

        this.txtCategory = findViewById(R.id.txtCategory);
        this.txtFood = findViewById(R.id.txtFood);

        this.txtCategory.setText(this.food.getCategory());
        this.txtFood.setText(this.food.getName());
    }
}