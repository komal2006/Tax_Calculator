package com.example.taxcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class TaxCalculated extends AppCompatActivity {

    CRACustomer customer;
    TextView txtDsin, txtDfullName, txtDgender, txtDgrossIncome,
            txtDtaxFilingDate, txtDfederalTax, txtDprovincialTax, lblcpp,
            lblEmpInsurance, lblRRSPcontri, lblCfRRSP,
            lblTaxableIncome, lblTaxPaid;
    double cpp = 0, ei = 0;  double rrsp = 0, rrspCf = 0, taxableIncome, federalTax,
            provincialTax, totalTaxPaid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculated_details);
        txtDsin = findViewById(R.id.txt_D_SIN);
        txtDfullName = findViewById(R.id.txt_D_fullName);
        txtDgender =   findViewById(R.id.txt_D_Gender);
        txtDgrossIncome = findViewById(R.id.txt_D_grossIncome);
        lblRRSPcontri = findViewById(R.id.txt_D_RRSPContri);
        lblcpp = findViewById(R.id.txt_D_Cpp);
        lblEmpInsurance = findViewById(R.id.txt_D_empInsurance);
        lblCfRRSP = findViewById(R.id.txt_D_cfRRSP);
        lblTaxableIncome = findViewById(R.id.txt_D_taxableIncome);
        txtDfederalTax = findViewById(R.id.txt_D_federalTax);
        txtDprovincialTax = findViewById(R.id.txt_D_provincialTax);
        lblTaxPaid = findViewById(R.id.txt_D_taxPayed);


        //collecting intent
        Intent mIntent = getIntent();
        CRACustomer customer = mIntent.getParcelableExtra("CRACustomer");

        txtDsin.setText(" SIN: \t" + customer.getSinNumber());
        txtDfullName.setText(" FULL NAME: \t" + customer.getFullName());
        txtDgender.setText(" GENDER: \t" + customer.getGender());
        txtDgrossIncome.setText(" GROSS INCOME: \t" + customer.getGrossIncome());
        lblRRSPcontri.setText("RRSP Contributed: \t" + customer.getRrspContri());

        // calculate  cpp
        double grossIncome = customer.getGrossIncome();
        if(grossIncome > 57400.00){
            cpp = (57400.00 * 0.051); //5.10%
        } else {
            cpp = (grossIncome * 0.051);
        }
        lblcpp.setText("CPP COntribution in Year:\t" + cpp);
        // calculate employement insurance
        if(grossIncome > 53100){
            ei = (53100 * 0.0162); //1.62%
        }else{
            ei = (grossIncome * (1.62/100));
        }
        lblEmpInsurance.setText("Employeement Insurance: \t" + ei);
        // calculate RRSP
        rrsp = customer.getRrspContri();
        double maxRRSP = (grossIncome * 0.18); //18%
        if(rrsp > maxRRSP ){
            rrspCf = rrsp - maxRRSP;
            rrsp = maxRRSP;
        }else{
            rrsp = rrsp;
        }
        lblCfRRSP.setText("RRSP Carry forward: \t"+ rrspCf);
        //taxable income
        taxableIncome = grossIncome - (cpp + ei + rrsp);
        //Toast.makeText(this, "(Double)taxableIncome" + taxableIncome, Toast.LENGTH_SHORT).show();
        lblTaxableIncome.setText("Taxable income:\t" + (double) taxableIncome);
        //federal tax
        double calFederal = calcFedralTax();
        txtDfederalTax.setText("Federal Tax: \t" + calFederal);
        // Provincial Tax
        double calProvincial = calcProvincialTax();
        txtDprovincialTax.setText("Provincial Tax:\t" + calProvincial);
        // total tax paid
        double taxpaid = calTaxPaid();
        lblTaxPaid.setText("Total tax Paid:\t" + taxpaid);


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }
    public double calcCpp(){
        // calculate  cpp
        if(customer.getGrossIncome() > 57400.00){
            cpp = (57400.00 * 0.051);
        } else {
            cpp = (customer.getGrossIncome() * 0.051);
        }
        return cpp;
    }

}
