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


       
    }
