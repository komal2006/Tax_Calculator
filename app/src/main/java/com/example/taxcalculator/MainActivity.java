package com.example.taxcalculator;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity
{


        CRACustomer customer;
        final Calendar calendar = Calendar.getInstance();
        DatePickerDialog datePickerDialog;
        private TextView txtTitle;
        private EditText edtSinNumber, edtFirstName, edtLastName,txtBirthDate,edtGrossIncome, edtRRSPcontri;
        private TextView txtFullName,txtGender, txtTaxFilingDate;
        private RadioGroup rgGender;
        private RadioButton radioGender,rdMale,rdFemale,rdOther;
        private Button btnShow;
        private String selectedGender = "";


    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtSinNumber = findViewById(R.id.edtSin_number);
        edtFirstName = findViewById(R.id.edtFirstName);
        edtLastName = findViewById(R.id.edtLastName);
        txtGender = findViewById(R.id.txtGender);
        rgGender = findViewById(R.id.rgGender);
        rdMale = findViewById(R.id.rdMale);
        rdFemale = findViewById(R.id.rdFemale);
        rdOther = findViewById(R.id.rdOthers);
        txtTaxFilingDate = findViewById(R.id.txt_D_taxFilingDate);
        edtGrossIncome = findViewById(R.id.edtGrossIncome);
        btnShow = findViewById(R.id.btnShow);
        txtBirthDate = findViewById(R.id.txtBirthDate);
        edtRRSPcontri = findViewById(R.id.edtRRSP);

        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                calendar.set(Calendar.YEAR, year);
                calendar.set(Calendar.MONTH, monthOfYear);
                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                dateFormat();
            }
        };
        txtBirthDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(MainActivity.this, date, calendar
                        .get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
        //radio button
        rgGender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.rdMale){
                    selectedGender = rdMale.getText().toString();
                }else if(checkedId == R.id.rdFemale){
                    selectedGender = rdFemale.getText().toString();
                }else {
                    selectedGender = rdOther.getText().toString();
                }
            }

        });


        // button to navigate to next activity
        btnShow.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Double grossIncome = Double.parseDouble(edtGrossIncome.getText().toString());
//                Double rrsp = Double.parseDouble(edtRRSPcontri.getText().toString());
//                customer = new CRACustomer(edtSinNumber.getText().toString(),
//                        edtFirstName.getText().toString(),
//                        edtLastName.getText().toString(),
//                        selectedGender, grossIncome, rrsp);
//                Intent mIntent = new Intent(MainActivity.this, TaxCalculated.class);
//                mIntent.putExtra("CRACustomer", customer);
//                startActivity(mIntent);
//            }
//        });

        private void dateFormat() {
            String myFormat = "dd-MMM-yyyy"; //In which you need put here
            java.text.SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
            txtBirthDate.setText(sdf.format(calendar.getTime()));
        }
    }
