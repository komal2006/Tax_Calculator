package com.example.taxcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{

    private EditText sin_number;
    private EditText edtFirstName;
    private EditText edtLastName;
    private EditText txtAge;
    private RadioGroup rgMain;
    private RadioButton rbMale;
    private RadioButton rbFMale;
    private RadioButton rbOthers;
    String radio = "";

    private Button btnCalculate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCalculate = findViewById(R.id.btnCalculate);


        sin_number = findViewById(R.id.sin_number);
        edtLastName = findViewById(R.id.edtLastName);
        txtAge = findViewById(R.id.txtAge);
        rgMain = findViewById(R.id.rgGender);
        rbMale = findViewById(R.id.rbMale);
        rbFMale = findViewById(R.id.rbFemale);
        rbOthers = findViewById(R.id.rbOthers);
        edtFirstName = findViewById(R.id.edtFirstName);
        radioAction();


    }

    public void radioAction()
    {
        rgMain.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId)
            {

                if(checkedId==R.id.rbMale)
                {
                    radio = rbMale.getText().toString();
                    Toast.makeText(getApplicationContext(),"Male",Toast.LENGTH_SHORT).show();
                    rbMale.setSelected(true);
                }
                else if(checkedId==R.id.rbFemale)
                {

                    radio = rbFMale.getText().toString();
                    Toast.makeText(getApplicationContext(),"Female",Toast.LENGTH_SHORT).show();
                    rbFMale.setSelected(true);
                    
                }
                else if(checkedId==R.id.rbOthers)
                {

                    radio = rbOthers.getText().toString();
                    Toast.makeText(getApplicationContext(),"Others",Toast.LENGTH_SHORT).show();
                    rbOthers.setSelected(true);

                }
            }
        });
    }
}
