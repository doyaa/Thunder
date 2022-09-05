package com.example.napo01;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.io.InputStream;
import java.util.ArrayList;

public class CareerAwardsAdapter extends BaseAdapter {

    private ArrayList<CareerAwardsVO> awardsItems = new ArrayList<CareerAwardsVO>();
    private Context context;

    @Override
    public int getCount() {
        return awardsItems.size();
    }

    @Override
    public Object getItem(int i) {
        return awardsItems.get(i);
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
            view = inflater.inflate(R.layout.careerawards_lv, viewGroup, false);
        }

        CareerAwardsVO vo = awardsItems.get(i);
        ImageView award_img = view.findViewById(R.id.award_img);
        EditText awardsName = view.findViewById(R.id.internName);
        EditText awardsInst = view.findViewById(R.id.awardsInst);
        EditText awardsDate = view.findViewById(R.id.awardsDate);
        award_img.setImageDrawable(vo.getAward_img());
       awardsName.setText(vo.getName());
       awardsInst.setText(vo.getInst());
       awardsDate.setText(vo.getDate());

        // 갤러리 가져오기
        award_img = view.findViewById(R.id.award_img);
        Button btn_award = view.findViewById(R.id.btn_award);
        btn_award.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGallery();
            }
        });

        return view;
    }

        public void addItems(Drawable img, String name, String inst, String date){
            CareerAwardsVO vo = new CareerAwardsVO(img, name, inst, date);
            awardsItems.add(vo);
        }

    // 갤러리 창 여는 코드
    public void openGallery() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(intent.ACTION_GET_CONTENT);

        ((CareerAwards_Main)context).startActivityForResult(intent, 101);
    }



}
