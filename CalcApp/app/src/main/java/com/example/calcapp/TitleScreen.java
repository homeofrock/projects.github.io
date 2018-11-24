package com.example.calcapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class TitleScreen extends AppCompatActivity {
    EditText getDate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_title_screen);
    }
    protected void clickStart(View view){
        getDate = (EditText) findViewById(R.id.get_date);
        Intent start = new Intent(this,MainActivity.class);
        start.putExtra("date",getDate.getText().toString());
        startActivity(start);
    }
}
