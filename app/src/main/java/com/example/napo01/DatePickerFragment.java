package com.example.napo01;
//수상일자 달력
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.DatePicker;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import java.util.Calendar;

/**
 * A simple {@link Fragment} subclass.
 */
public class DatePickerFragment extends DialogFragment
        implements DatePickerDialog.OnDateSetListener {

    Context context;
    String activty_name;

    public DatePickerFragment(Context context, String activty_name){
        this.context = context;
        this.activty_name = activty_name;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        return new DatePickerDialog(getActivity(), this, year, month, day);
    }

    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
        // activity를 나누는 로직 작성 필요

        if(activty_name.equals("CareerAwards")){
//            CareerAwards_Main activity = (CareerAwards_Main)getActivity();
//            activity.processDatePickerResult(year,month,day);

            ((CareerAwards_Main)context).processDatePickerResult(year, month,day);
        }else if(activty_name.equals("CareerCert")){
//            CareerAwards_Main activity = (CareerAwards_Main)getActivity();
//            activity.processDatePickerResult(year,month,day);

            ((CareerCert_Main)context).processDatePickerResult(year, month,day);
        }else if(activty_name.equals("CareerIntern")){

            ((CareerCert_Main)context).processDatePickerResult(year, month,day);
        }





//        CareerCert_Main activity2 = (CareerCert_Main) getActivity();
//        activity2.processDatePickerResult(year, month, day);
    }

}