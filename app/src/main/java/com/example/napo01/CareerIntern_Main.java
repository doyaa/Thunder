package com.example.napo01;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

public class CareerIntern_Main extends AppCompatActivity {
    private ListView internList;
    private CareerInternAdapter careerInternAdapter = new CareerInternAdapter();
    private TextView btn_intern;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.careerintern);

        internList = findViewById(R.id.internList);
        btn_intern = findViewById(R.id.btn_intern);

        internList.setAdapter(careerInternAdapter);
        careerInternAdapter.addItems("","","");
        careerInternAdapter.notifyDataSetChanged();

        btn_intern.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView tv_name = internList.findViewById(R.id.internName);
                TextView tv_per = internList.findViewById(R.id.internPer);
                TextView tv_act = internList.findViewById(R.id.internAct);
                String name = tv_name.getText().toString();
                String per = tv_per.getText().toString();
                String act = tv_per.getText().toString();


                careerInternAdapter.addItems(name,per,act);
                internList.setAdapter(careerInternAdapter);

            }
        });
    }
    public void showDatePicker(View view) {
        DialogFragment newFragment = new DatePickerFragment(this, "CareerIntern");
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }

    public void processDatePickerResult(int year, int month, int day) {
        String month_string = Integer.toString(month + 1);
        String day_string = Integer.toString(day);
        String year_string = Integer.toString(year);
        String dateMessage = (year_string + "년 " + month_string + "월 " + day_string + "일");

        EditText awardsDate = findViewById(R.id.internPer);
        awardsDate.setText(dateMessage);
    }
}
