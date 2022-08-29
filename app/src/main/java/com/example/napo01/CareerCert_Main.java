package com.example.napo01;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CareerCert_Main extends AppCompatActivity {
    private ListView careercert_List;
    private CareerCertAdapter careerCertAdapter = new CareerCertAdapter();
    private Button btn_certPlus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.careercert);

        careercert_List = findViewById(R.id.careercert_List);
        btn_certPlus = findViewById(R.id.btn_certPlus);

        careercert_List.setAdapter(careerCertAdapter);
        careerCertAdapter.addItems("","","");
        careerCertAdapter.notifyDataSetChanged();

        btn_certPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView tv_ser = careercert_List.findViewById(R.id.certName);
                TextView tv_inst = careercert_List.findViewById(R.id.certInst);
                TextView tv_date = careercert_List.findViewById(R.id.certDate);

                String ser = tv_ser.getText().toString();
                String inst = tv_inst.getText().toString();
                String date = tv_date.getText().toString();

                careerCertAdapter.addItems(ser, inst, date);
                careercert_List.setAdapter(careerCertAdapter);
                careerCertAdapter.notifyDataSetChanged();
            }
        });



    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1234){
            if(resultCode == RESULT_OK){
                String choice = data.getStringExtra("choice");
                Log.d("확인", choice);

                TextView tv_ser = careercert_List.findViewById(R.id.certName);
                tv_ser.setText(choice);
            }
        }

    }
}
