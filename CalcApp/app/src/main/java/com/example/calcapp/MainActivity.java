package com.example.calcapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener {
    TextView textView;
    EditText enterNum1;
    EditText enterNum2;
    Button buttonSum;
    Button buttonMin;
    Button buttonMult;
    Button buttonPow;
    Button buttonDeMult;
    Button buttonRoot;
    double res = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.textVresult);
        enterNum1 = (EditText) findViewById(R.id.enterNum1);
        enterNum2 = (EditText) findViewById(R.id.enterNum2);
        Button buttonSum = (Button) findViewById(R.id.buttonSum);
        Button buttonMin = (Button) findViewById(R.id.buttonMin);
        Button buttonMult = (Button) findViewById(R.id.buttonMult);
        Button buttonPow =  (Button) findViewById(R.id.buttonPow);
        Button buttonDeMult = (Button) findViewById(R.id.buttonDeMult);
        Button buttonRoot = (Button) findViewById(R.id.buttonRoot);
        Button buttonNext = (Button) findViewById(R.id.buttonGetRes);
        Button buttonClean = (Button) findViewById(R.id.buttonDellAll);
        buttonSum.setOnClickListener(this);
        buttonMin.setOnClickListener(this);
        buttonMult.setOnClickListener(this);
        buttonPow.setOnClickListener(this);
        buttonDeMult.setOnClickListener(this);
        buttonRoot.setOnClickListener(this);
        buttonNext.setOnClickListener(this);
        buttonClean.setOnClickListener(this);
    }

    @Override
    public void onClick(View view){
        boolean cflag = false;
        boolean flag = false;
        double num1;
        double num2;
        String Mcout = null;
        if(enterNum1.getText().toString().equals(""))
            num1 = 0;
        else
            num1 = Double.parseDouble(enterNum1.getText().toString());
        if(enterNum2.getText().toString().equals(""))
            num2 = 0;
        else
            num2 = Double.parseDouble(enterNum2.getText().toString());
        switch (view.getId()){
            case R.id.buttonSum:
                Mcout = "+";
                res = Calculator.summa(num1,num2);
                break;
            case R.id.buttonMin:
                Mcout = "-";
                res = Calculator.minus(num1,num2);
                break;
            case R.id.buttonMult:
                Mcout = "X";
                res = Calculator.mult(num1,num2);
                break;
            case R.id.buttonDeMult:
                Mcout = ":";
                res = Calculator.deMult(num1,num2);
                break;
            case R.id.buttonPow:
                Mcout = "^";
                res = Calculator.pow(num1,num2);
                break;
            case R.id.buttonRoot:
                Mcout ="\u221A";
                res = Calculator.root(num1,num2);
                break;
            case R.id.buttonGetRes:
                enterNum2.setText("");
                enterNum1.setText(String.valueOf(res));
                num1 = num2 = res = 0;
                flag = true;
                break;
            case R.id.buttonDellAll:
                enterNum1.setText("");
                enterNum2.setText("");
                Mcout = "";
                cflag = true;
                break;
        }
        if(cflag)
            textView.setText("");
       else if(!flag)
        textView.setText(num1 + " " + Mcout + " " + num2 + "= " + res);
        else
            textView.setText("<<Result is got>>");
    }


}
