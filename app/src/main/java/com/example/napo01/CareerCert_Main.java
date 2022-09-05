package com.example.napo01;

import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CareerCert_Main extends AppCompatActivity {
    private ListView careercert_List;
    private CareerCertAdapter careerCertAdapter = new CareerCertAdapter();
    private TextView btn_certPlus;

    private RequestQueue queue;
    private StringRequest stringRequest;

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

                // 자격증 값 받아오기
                ArrayList<CareerCertVO> list = careerCertAdapter.getCertItems();
                for(int i = 0; i < list.size(); i++){
                    Log.v("ttttt" , list.get(i).getCertName());
                    Log.v("ttttt" , list.get(i).getCertInst());
                    Log.v("ttttt" , list.get(i).getCertDate());
                }

                sendRequest();
            }


        });
    }

    public void sendRequest(){

        queue = Volley.newRequestQueue(this);
        String url = "http://192.168.21.173:5001/join";
        stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                Log.v("resultValue",response);
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        }) {
            @Override
            protected Response<String> parseNetworkResponse(NetworkResponse response) {
                try {
                    String utf8String = new String(response.data, "UTF-8");
                    return Response.success(utf8String, HttpHeaderParser.parseCacheHeaders(response));
                } catch (UnsupportedEncodingException e) {

                    return Response.error(new ParseError(e));
                } catch (Exception e) {

                    return Response.error(new ParseError(e));
                }
            }

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();

//
//                        params.put("id",id);
//                        params.put("pw",pw);
//                        params.put("name",name);
//                        params.put("phone",phone);

                return params;

            }
        };

        String TAG = "duud";
        stringRequest.setTag(TAG);
        queue.add(stringRequest);
    }

    public void showDatePicker(View view) {
        DialogFragment newFragment = new DatePickerFragment(this, "CareerCert");
        newFragment.show(getSupportFragmentManager(),"datePicker");
    }

    public void processDatePickerResult(int year, int month, int day){
        String month_string = Integer.toString(month+1);
        String day_string = Integer.toString(day);
        String year_string = Integer.toString(year);
        String dateMessage = (year_string + "년 " + month_string + "월 " + day_string + "일");

        EditText certDate = findViewById(R.id.certDate);
        certDate.setText(dateMessage);

    }




//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (requestCode == 1234){
//            if(resultCode == RESULT_OK){
//                String choice = data.getStringExtra("choice");
//                Log.d("확인", choice);
//
//                TextView tv_ser = careercert_List.findViewById(R.id.certName);
//                tv_ser.setText(choice);
//            }
//        }
//
//    }
}
