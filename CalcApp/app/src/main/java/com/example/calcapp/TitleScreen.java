package com.example.calcapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

public class TitleScreen extends AppCompatActivity {
   DatePicker datePicker;
    EditText getDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_title_screen);


        Calendar today = Calendar.getInstance();
        datePicker = (DatePicker) findViewById(R.id.date_picker);

        datePicker.init(today.get(Calendar.YEAR), today.get(Calendar.MONTH), today.get(Calendar.DAY_OF_MONTH), new DatePicker.OnDateChangedListener(){
                @Override
                public void onDateChanged(DatePicker view, int year, int mounthOfYear, int dayOfMounth){
                    Toast.makeText(getApplicationContext(),"onDateChanged",Toast.LENGTH_SHORT).show();
                }
        });
        Button changingDateButton = (Button) findViewById(R.id.button_set_date);
       changingDateButton.setOnLongClickListener(new View.OnLongClickListener(){

           @Override
           public boolean onLongClick(View v) {
               setCurrentDateOnView();
               return true;
           }
       });


    }


    public void setCurrentDateOnView(){
        final Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int mounth = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
         datePicker.init(year, mounth, day,    null);
         Intent inSetDate  = new Intent(this,MainActivity.class);
         inSetDate.putExtra("num",(day + ":" + mounth + ":" + year).toString());
         startActivity(inSetDate);
    }

    protected void clickStart(View view){
        getDate = (EditText) findViewById(R.id.get_date);
        if(getDate.getText().equals(""))
            getDate.setText(" ");
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("date",getDate.getText().toString());
        startActivity(intent);
    }
}
