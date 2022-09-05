package com.example.napo01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;

import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.io.InputStream;

public class CareerAwards_Main extends AppCompatActivity {
    private ListView careerAwardsList;
    private CareerAwardsAdapter careerawardsAdapter = new CareerAwardsAdapter();
    private TextView btn_plus;
    private ImageView award_img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.careerawards);



        careerAwardsList = findViewById(R.id.careerAwardsList);
        btn_plus = findViewById(R.id.btn_plus);


        careerAwardsList.setAdapter(careerawardsAdapter);
        careerawardsAdapter.addItems(ContextCompat.getDrawable(getApplicationContext(), R.drawable.clean),"", "", "");

        careerawardsAdapter.notifyDataSetChanged();

        btn_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView tv_name = (TextView) careerAwardsList.findViewById(R.id.internName);
                TextView tv_inst = (TextView) careerAwardsList.findViewById(R.id.awardsInst);
                TextView tv_date = (TextView) careerAwardsList.findViewById(R.id.awardsDate);
                String name = tv_name.getText().toString();
                String inst = tv_inst.getText().toString();
                String date = tv_date.getText().toString();
                Log.e("tv_name", tv_name.getText().toString());
                Log.e("tv_name", tv_name.getText().toString());
                Log.e("tv_name", tv_name.getText().toString());

                careerawardsAdapter.addItems(ContextCompat.getDrawable(getApplicationContext(),R.drawable.img_5),name, inst, date);

                careerAwardsList.setAdapter(careerawardsAdapter);

            }
        });

    }
    public void showDatePicker(View view) {
        DialogFragment newFragment = new DatePickerFragment(this, "CareerAwards");
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }

    public void processDatePickerResult(int year, int month, int day) {
        String month_string = Integer.toString(month + 1);
        String day_string = Integer.toString(day);
        String year_string = Integer.toString(year);
        String dateMessage = (year_string + "년 " + month_string + "월 " + day_string + "일");

        EditText awardsDate = findViewById(R.id.awardsDate);
        awardsDate.setText(dateMessage);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 101) {
            if (resultCode == RESULT_OK) {
                Uri fileUri = data.getData();

                ContentResolver resolver = getContentResolver();  //ContentResolver 객체 참조하기

                try {
                    InputStream instream = resolver.openInputStream(fileUri);
                    Bitmap imgBitmap = BitmapFactory.decodeStream(instream);
                    award_img = findViewById(R.id.award_img);
                    award_img.setImageBitmap(imgBitmap);

                    instream.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

}