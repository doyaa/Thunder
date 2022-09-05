package com.example.napo01;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.SearchView;
import android.widget.TextView;

import java.util.ArrayList;

public class CareerCertAdapter extends BaseAdapter {
    private ArrayList<CareerCertVO> certItems = new ArrayList<CareerCertVO>();

    public ArrayList<CareerCertVO> getCertItems(){
        return certItems;
    }


    @Override
    public int getCount() {
        return certItems.size();
    }

    @Override
    public Object getItem(int i) {
        return certItems.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Context context = viewGroup.getContext();
        if(view==null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.careercert_lv, viewGroup, false);
        }


        CareerCertVO vo = certItems.get(i);
        TextView certName = view.findViewById(R.id.certName);
        EditText certInst = view.findViewById(R.id.certInst);
        EditText certDate = view.findViewById(R.id.certDate);

        certName.setText(vo.getCertName());
        certInst.setText(vo.getCertInst());
        certDate.setText(vo.getCertDate());

        certName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((Activity)context).startActivityForResult(new Intent(context.getApplicationContext(), CareerCertSearch.class), 1234);
            }
        });

        return view;
    }

    public void addItems(String cert_ser, String certInst, String certDate){
        CareerCertVO vo = new CareerCertVO(cert_ser, certInst, certDate);
        certItems.add(vo);
    }
}
