package com.example.taruc.lab21loancalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final String MONTHLY_PAYMENT = "payment";
    public static final String LOAN_STATUS = "status";

    private EditText editTextPrice, editTextDownpayment, editTextInterest ,editTextRepayment, editTextSalary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextPrice = (EditText) findViewById(R.id.editTextPrice);
        editTextDownpayment = (EditText) findViewById(R.id.editTextDownpayment);
        editTextInterest = (EditText) findViewById(R.id.editTextInterest);
        editTextRepayment = (EditText) findViewById(R.id.editTextRepayment);
        editTextSalary = (EditText) findViewById(R.id.editTextSalary);
    }

    public void calculateLoan(View view){
        //TODO: calculate monthly payment and determine the loan status
        double monthlyPayment = 0;
        String status = "Approved";

        monthlyPayment=((Double.parseDouble(editTextPrice.getText().toString())-Double.parseDouble(editTextDownpayment.getText().toString()))
                +((Double.parseDouble(editTextPrice.getText().toString())-Double.parseDouble(editTextDownpayment.getText().toString()))
                *(Double.parseDouble(editTextInterest.getText().toString())/100)*(Double.parseDouble(editTextRepayment.getText().toString())/12)))/
                (Double.parseDouble(editTextRepayment.getText().toString()));

        if(monthlyPayment > Double.parseDouble(editTextSalary.getText().toString())* 0.3)
            status = "Rejected";

        //Create an Explicit Intent
        Intent intent = new Intent(this, ResultActivity.class);
        //TODO: passing data using putExtra method
        //format: putExtra(TAG, value)
        intent.putExtra(MONTHLY_PAYMENT, monthlyPayment);
        intent.putExtra(LOAN_STATUS, status);
        startActivity(intent);
    }
}
