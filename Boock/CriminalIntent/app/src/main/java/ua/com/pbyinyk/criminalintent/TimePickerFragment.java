//package ua.com.pbyinyk.criminalintent;
//
//import android.annotation.TargetApi;
//import android.app.Activity;
//import android.app.Dialog;
//import android.content.DialogInterface;
//import android.content.Intent;
//import android.os.Build;
//import android.os.Bundle;
//import android.support.annotation.NonNull;
//import android.support.v4.app.DialogFragment;
//import android.support.v4.app.FragmentManager;
//import android.support.v7.app.AlertDialog;
//import android.text.format.Time;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.widget.TimePicker;
//
//import java.util.Calendar;
//import java.util.Date;
//import java.util.TimeZone;
//
///**
// * Created by 1 on 09.06.2016.
// */
//public class TimePickerFragment extends DialogFragment implements TimePicker.OnTimeChangedListener{
//
//    public TimePickerFragment() {
//
//    }
//    private static final String ARG_TIME = "time";
//    public static final String EXTRA_TIME ="com.bignerdranch.android.criminalintent.time";
//    TimePicker timePicker;
//    @TargetApi(Build.VERSION_CODES.M)
//    @NonNull
//    @Override
//    public Dialog onCreateDialog(Bundle savedInstanceState) {
//
//        View v= LayoutInflater.from(getActivity()).inflate(R.layout.dialog_time,null);
//        timePicker=(TimePicker)v.findViewById(R.id.time_picker_dialog);
//
//        timePicker.getCurrentHour();
//        timePicker.getCurrentMinute();
//
//
//        return new AlertDialog.Builder(getActivity())
//                .setView(v)
//                .setTitle(R.string.time_picker_title)
//                .setPositiveButton(android.R.string.ok,
//                        new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//
//                                long  hour = timePicker.getHour();
//                                long minute = timePicker.getMinute();
//
//
//                                Date dt = new DateTime();
//                                sendResult(Activity.RESULT_OK, date);
//                            }
//                        })
//                .create();
//    }
//    private void sendResult(int resultCode, Date date) {
//        if (getTargetFragment() == null) {
//            return;
//        }
//        Intent intent = new Intent();
//        intent.putExtra(EXTRA_TIME, date);
//        getTargetFragment().onActivityResult(getTargetRequestCode(), resultCode, intent);
//    }
//
//    @Override
//    public void show(FragmentManager manager, String tag) {
//        super.show(manager, tag);
//    }
//
//    @Override
//    public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
//
//
//    }
//}
