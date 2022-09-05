package com.example.napo01;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.ArrayList;

public class CareerInternAdapter extends BaseAdapter {

    private ArrayList<CareerInternVO> internItems = new ArrayList<CareerInternVO>();
    private Context context;

    @Override
    public int getCount() {
        return internItems.size();
    }

    @Override
    public Object getItem(int i) {
        return internItems.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        context = viewGroup.getContext();
        if(view==null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.careerintern_lv, viewGroup, false);
        }

        CareerInternVO vo = internItems.get(i);
        EditText internName = view.findViewById(R.id.internName);
        EditText internPer = view.findViewById(R.id.internPer);
        EditText internAct = view.findViewById(R.id.internAct);
        internName.setText(vo.getInternName());
        internPer.setText(vo.getInternPer());
        internAct.setText(vo.getInternAct());

        // 갤러리 가져오기
        ImageView intern_img = view.findViewById(R.id.intern_img);
        Button btn_intern = view.findViewById(R.id.btn_intern);
        btn_intern.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGallery();
            }
        });


        return view;
    }

    public void addItems(String name, String per, String act){
        CareerInternVO vo = new CareerInternVO(name, per, act);
        internItems.add(vo);
    }

    // 갤러리 창 여는 코드
    public void openGallery() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(intent.ACTION_GET_CONTENT);

        ((CareerIntern_Main)context).startActivityForResult(intent, 101);
    }
}
