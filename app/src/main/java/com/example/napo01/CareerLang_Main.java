package com.example.napo01;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

public class CareerLang_Main extends AppCompatActivity {
    private ListView careerLang_List, listview;
    private CareerLangAdapter careerLangAdapter = new CareerLangAdapter();
    private TextView btn_langPlus;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.careerlang);

        careerLang_List = findViewById(R.id.careerLang_List);
        btn_langPlus = findViewById(R.id.btn_langPluss);

        careerLang_List.setAdapter(careerLangAdapter);
        careerLangAdapter.addItems("","","","");
        careerLangAdapter.notifyDataSetChanged();


        btn_langPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText tv_kind = careerLang_List.findViewById(R.id.lang_kind);
                TextView tv_test = careerLang_List.findViewById(R.id.lang_test);
                EditText tv_score = careerLang_List.findViewById(R.id.lang_score);
                EditText tv_date = careerLang_List.findViewById(R.id.lang_date);

                String kind = tv_kind.getText().toString();
                String test = tv_test.getText().toString();
                String score = tv_score.getText().toString();
                String date = tv_date.getText().toString();

                careerLangAdapter.notifyDataSetChanged();
                careerLangAdapter.addItems(kind,test,score,date);
          }
        });

    }

    public void showDatePicker(View view) {
        DialogFragment newFragment = new DatePickerFragment(this, "CareerLang");
        newFragment.show(getSupportFragmentManager(),"datePicker");
    }

    public void processDatePickerResult(int year, int month, int day){
        String month_string = Integer.toString(month+1);
        String day_string = Integer.toString(day);
        String year_string = Integer.toString(year);
        String dateMessage = (year_string + "년 " + month_string + "월 " + day_string + "일");

        EditText lang_date = findViewById(R.id.lang_date);
        lang_date.setText(dateMessage);


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1234){
            if(resultCode == RESULT_OK){
                String choice = data.getStringExtra("choice");
                Log.d("확인", choice);

                TextView tv_test = careerLang_List.findViewById(R.id.lang_test);
                tv_test.setText(choice);

            }
        }
    }
}
