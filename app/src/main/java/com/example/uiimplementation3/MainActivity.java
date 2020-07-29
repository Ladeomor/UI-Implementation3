package com.example.uiimplementation3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements CarAdapter.OnItemListener {
    RecyclerView carRecycler;
    RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        carRecycler = findViewById(R.id.Car_recycler);
        carRecycler();
    }

    private void carRecycler(){
        carRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        ArrayList<CarItem>carList = new ArrayList<>();
        carList.add(new CarItem(R.drawable.car_three, 4.5, "Blue Kia Cerato", "From $199/day", "18 deals"));
        carList.add(new CarItem(R.drawable.car_two, 4.3,"Red Tesla", "From $179/day", "10 deals"));
        carList.add(new CarItem(R.drawable.car_one,4.0,"Orange Audi", "From $200/day", "20 deals"));
        adapter = new CarAdapter(carList, this);
        carRecycler.setAdapter(adapter);

    }


    @Override
    public void onItemClick(int position) {
        Toast.makeText(this,"Check details", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, CarDetailsActivity.class);
        startActivity(intent);
    }
}