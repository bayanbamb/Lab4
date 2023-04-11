package com.example.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // make a reference to buttons
    Button btn_add;
    EditText et_name, et_age;
    DataBaseHelper dataBaseHelper;
    Switch sw_activeCustomer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_add = findViewById(R.id.btn_add);

        et_age=findViewById(R.id.et_age);
        et_name = findViewById(R.id.et_name);


        dataBaseHelper = new DataBaseHelper(MainActivity.this);



        //Listeners:


        btn_add.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StudentMod studentMod;
                try {
                    studentMod = new StudentMod( et_name.getText().toString(),-1, Integer.parseInt(et_age.getText().toString()));
                    Toast.makeText(MainActivity.this, studentMod.toString(), Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, "Enter Valid input", Toast.LENGTH_SHORT).show();
                    studentMod = new StudentMod("ERROR", -1, 0);
                }

                DataBaseHelper dataBaseHelper = new DataBaseHelper(MainActivity.this);
                boolean b = dataBaseHelper.addOne(studentMod);
                Toast.makeText(MainActivity.this, "SUCCESS= "+ b, Toast.LENGTH_SHORT).show();

            }
        });



    }



}