package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editWeight, editHeightFt, editHeightInch;
        Button calculateBmiButton;
        TextView txtResult;
        LinearLayout main;

        editWeight = findViewById(R.id.editWeight);
        editHeightFt = findViewById(R.id.editHeightFt);
        editHeightInch = findViewById(R.id.editHeightInch);
        calculateBmiButton = findViewById(R.id.calculateBmiButton);
        txtResult = findViewById(R.id.txtResult);
        main = findViewById(R.id.main);


        calculateBmiButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View V){
                int weight = Integer.parseInt(editWeight.getText().toString());
                int heightFt = Integer.parseInt(editHeightFt.getText().toString());
                int HeightInch = Integer.parseInt(editHeightInch.getText().toString());

                int totalInches = heightFt*12 + HeightInch;

                double totalCm = totalInches*2.53;
                double totalM = totalCm/100;

                double bmi = weight/(totalM*totalM);

                if(bmi>25){
                    txtResult.setText("You're OverWeight!");
                    main.setBackgroundColor(getResources().getColor(R.color.colorOw));
                }
                else if(bmi<18){
                    txtResult.setText("You're UnderWeight!");
                    main.setBackgroundColor(getResources().getColor(R.color.colorUw));
                } else {
                    txtResult.setText("You're Healthy!");
                    main.setBackgroundColor(getResources().getColor(R.color.colorHw));
                }


            }
        });

    }
}