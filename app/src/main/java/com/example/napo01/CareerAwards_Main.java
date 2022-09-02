package com.example.napo01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class CareerAwards_Main extends AppCompatActivity {
    private ListView careerAwardsList;
    private CareerAwardsAdapter careerawardsAdapter = new CareerAwardsAdapter();
    private Button btn_plus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.careerawards);

        careerAwardsList = findViewById(R.id.careerAwardsList);
        btn_plus = findViewById(R.id.btn_plus);



        careerAwardsList.setAdapter(careerawardsAdapter);
        careerawardsAdapter.addItems("","","");

        careerawardsAdapter.notifyDataSetChanged();

        btn_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TextView tv_name = (TextView)careerAwardsList.findViewById(R.id.internName);
                TextView tv_inst = (TextView)careerAwardsList.findViewById(R.id.awardsInst);
                TextView tv_date = (TextView)careerAwardsList.findViewById(R.id.awardsDate);
                String name = tv_name.getText().toString();
                String inst = tv_inst.getText().toString();
                String date = tv_date.getText().toString();
                Log.e("tv_name", tv_name.getText().toString());
                Log.e("tv_name", tv_name.getText().toString());
                Log.e("tv_name", tv_name.getText().toString());

                careerawardsAdapter.addItems(name,inst,date);

                careerAwardsList.setAdapter(careerawardsAdapter);

            }
        });


    }
    public void showDatePicker(View view) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(),"datePicker");
    }

    public void processDatePickerResult(int year, int month, int day){
        String month_string = Integer.toString(month+1);
        String day_string = Integer.toString(day);
        String year_string = Integer.toString(year);
        //String dateMessage = (month_string + "/" + day_string + "/" + year_string);
        String dateMessage = (year_string + "년 " + month_string + "월 " + day_string + "일");

        EditText awardsDate = findViewById(R.id.awardsDate);
        awardsDate.setText(dateMessage);


    }
}