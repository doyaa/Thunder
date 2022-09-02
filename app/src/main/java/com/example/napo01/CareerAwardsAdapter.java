package com.example.napo01;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.ArrayList;

public class CareerAwardsAdapter extends BaseAdapter {

    private ArrayList<CareerAwardsVO> awardsItems = new ArrayList<CareerAwardsVO>();

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
        // 갤러리 가져오기
        ImageView award_img = view.findViewById(R.id.award_img);
        Button btn_award = view.findViewById(R.id.btn_award);
//        btn_award.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                openGallery();
//            }
//        });

        Context context = viewGroup.getContext();
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.careerawards_lv, viewGroup, false);
        }

        CareerAwardsVO vo = awardsItems.get(i);
        EditText awardsName = view.findViewById(R.id.internName);
        EditText awardsInst = view.findViewById(R.id.awardsInst);
        EditText awardsDate = view.findViewById(R.id.awardsDate);
        awardsName.setText(vo.getName());
        awardsInst.setText(vo.getInst());
        awardsDate.setText(vo.getDate());

        return view;
    }

    public void addItems(String name, String inst, String date) {
        CareerAwardsVO vo = new CareerAwardsVO(name, inst, date);
        awardsItems.add(vo);
    }

//    갤러리 창 여는 코드
//    public void openGallery() {
//        Intent intent = new Intent();
//        intent.setType("image/*");
//        intent.setAction(intent.ACTION_GET_CONTENT);
//
//        startActivityForResult(intent, 101);
//    }


    //사진 선택 후 메서드로 결과 값 받기
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//
//        if (requestCode == 101) {
//            if (resultCode == RESULT_OK) {
//                Uri fileUri = data.getData();
//
//                ContentResolver resolver = getContentResolver();  //ContentResolver 객체 참조하기
//
//                try {
//                    InputStream instream = resolver.openInputStream(fileUri);
//                    Bitmap imgBitmap = BitmapFactory.decodeStream(instream);
//                    award_img.setImageBitmap(imgBitmap);
//
//                    instream.close();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }

}
