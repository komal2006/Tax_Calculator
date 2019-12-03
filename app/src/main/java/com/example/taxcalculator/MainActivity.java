package com.example.taxcalculator;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

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
import java.time.LocalDate;
import java.time.Period;
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
    private Button btnCalculate;
    private String selectedGender = "";
    private TextView txtAge;
    int dDay;
    int dMonth;
    int dYear;

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
        rdMale = findViewById(R.id.rbMale);
        rdFemale = findViewById(R.id.rbFemale);
        rdOther = findViewById(R.id.rbOthers);
       // txtTaxFilingDate = findViewById(R.id.txt_D_taxFilingDate);
        edtGrossIncome = findViewById(R.id.edtGrossIncome);
        btnCalculate = findViewById(R.id.btnCalculate);
        txtBirthDate = findViewById(R.id.txtBirthDate);
        edtRRSPcontri = findViewById(R.id.edtRRSP);
        txtAge=findViewById(R.id.txtAge);

        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {

                calendar.set(Calendar.YEAR, year);
                calendar.set(Calendar.MONTH, monthOfYear);
                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                 dateFormat();
            }
        };
        txtBirthDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new DatePickerDialog(MainActivity.this, date, calendar
                        .get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
        //radio button
        rgGender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.rbMale){
                    selectedGender = rdMale.getText().toString();
                }else if(checkedId == R.id.rbFemale){
                    selectedGender = rdFemale.getText().toString();
                }else {
                    selectedGender = rdOther.getText().toString();
                }
            }

        });
        // button to navigate to next activity
        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double grossIncome = Double.parseDouble(edtGrossIncome.getText().toString());
                Double rrsp = Double.parseDouble(edtRRSPcontri.getText().toString());
                customer = new CRACustomer(edtSinNumber.getText().toString(),
                        edtFirstName.getText().toString(),
                        edtLastName.getText().toString(),
                        txtAge.getText().toString(),
                        selectedGender, grossIncome, rrsp);
                Intent mIntent = new Intent(MainActivity.this, TaxCalculated.class);
                mIntent.putExtra("CRACustomer", customer);
                startActivity(mIntent);
            }
        });

    };
    @RequiresApi(api = Build.VERSION_CODES.O)
     private String dateFormat() {
        String myFormat = "dd-MMM-yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
        txtBirthDate.setText(sdf.format(calendar.getTime()));

        LocalDate l = LocalDate.of(calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
        LocalDate now = LocalDate.now(); //gets localDate
        Period diff = Period.between(l, now); //difference between the dates is calculated
        System.out.println(diff.getYears() + "years" + diff.getMonths() + "months" + diff.getDays() + "days");

        String n1=String.valueOf(diff.getYears());
        String n2=String.valueOf(diff.getMonths());
        String n3=String.valueOf(diff.getDays());
        String age="Age: "+n1+"Years"+n2+"Months"+n3+"Days";


        txtAge.setText(age);
        return  n1;
    }
    private  void currentDate(){
        // for tax filing date

        String todayDateFormat = "EEE, MMM d, yyyy";
        java.text.SimpleDateFormat td = new SimpleDateFormat(todayDateFormat, Locale.CANADA);
        txtTaxFilingDate.setText(td.format(calendar.getTime()));

    }
    public  void checkedButton(View view){
        int radioId = rgGender.getCheckedRadioButtonId();
        rgGender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.rbMale){
                    selectedGender = rdMale.getText().toString();
                }else if(checkedId == R.id.rbFemale)
                {
                    selectedGender = rdFemale.getText().toString();
                }else
                    {
                    selectedGender = rdOther.getText().toString();
                    }
            }
        });
        radioGender = findViewById(radioId);
        txtGender.setText(selectedGender);
        Toast.makeText(this, "Gender:" + radioGender.getText(), Toast.LENGTH_SHORT).show();
    }
    }
