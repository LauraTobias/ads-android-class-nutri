package com.example.nutri;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.nutri.controllers.NutriTableController;
import com.example.nutri.models.ShowFoodActivity;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    NutriTableController nutriController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.listView = findViewById(R.id.listView);
        this.nutriController = new NutriTableController(getApplicationContext());

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                getApplicationContext(),
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                this.nutriController.getFoodNames());

        listView.setAdapter(adapter);
        listView.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(getApplicationContext(), ShowFoodActivity.class);
            intent.putExtra("id", position);
            startActivity(intent);
        });
    }
}