package com.karunendu.qshare.fac_farg;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.TimePicker;
import android.widget.Toast;

import com.karunendu.qshare.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/**
 * Created by Karunendu Mishra on 11/6/2016.
 */
public class FragmentSchedule extends Fragment implements View.OnClickListener{

    Button btnDate,btnTime1,btnTime2,btnTime3,btnTime4,btnDone;
    LinearLayout lcontainer;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_fac_schedule,container,false);
        btnDate=(Button)view.findViewById(R.id.schedule_select_date);
        btnTime1=(Button)view.findViewById(R.id.schedule_time1);
        btnTime2=(Button)view.findViewById(R.id.schedule_time2);
        btnTime3=(Button)view.findViewById(R.id.schedule_time3);
        btnTime4=(Button)view.findViewById(R.id.schedule_time4);
        btnDone=(Button)view.findViewById(R.id.schedule_done);
        lcontainer=(LinearLayout)view.findViewById(R.id.schedule_container);
        btnDate.setOnClickListener(this);
        btnTime1.setOnClickListener(this);
        btnTime2.setOnClickListener(this);
        btnTime3.setOnClickListener(this);
        btnTime4.setOnClickListener(this);
        btnDone.setOnClickListener(this);

        return view;

        // return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onClick(View v)
    {
        if(v.equals(btnDate))
        {
            showDate();
        }
        else if(v.equals(btnDone))
        {
            onDone();
        }
        else if(v.equals(btnTime1))
        {
            showTime1();
        }
        else if(v.equals(btnTime2))
        {
            showTime2();
        }
        else if(v.equals(btnTime3))
        {
            showTime3();
        }
        else if(v.equals(btnTime4))
        {
            showTime4();
        }
    }

    private void showTime4() {
        TimePickerDialog tpd=new TimePickerDialog(getActivity(), new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                Calendar cur=Calendar.getInstance();
                cur.set(Calendar.HOUR_OF_DAY,hourOfDay);
                cur.set(Calendar.MINUTE,minute);
                cur.set(Calendar.SECOND,0);
                SimpleDateFormat fo=new SimpleDateFormat("hh:mm a",Locale.ENGLISH);
                btnTime4.setText(fo.format(cur.getTimeInMillis()));
            }
        }, 15, 0, false);
        tpd.show();
    }
    private void showTime3() {
        TimePickerDialog tpd=new TimePickerDialog(getActivity(), new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                Calendar cur=Calendar.getInstance();
                cur.set(Calendar.HOUR_OF_DAY,hourOfDay);
                cur.set(Calendar.MINUTE,minute);
                cur.set(Calendar.SECOND,0);
                SimpleDateFormat fo=new SimpleDateFormat("hh:mm a",Locale.ENGLISH);
                btnTime3.setText(fo.format(cur.getTimeInMillis()));
            }
        }, 13, 0, false);
        tpd.show();
    }
    private void showTime2() {
        TimePickerDialog tpd=new TimePickerDialog(getActivity(), new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                Calendar cur=Calendar.getInstance();
                cur.set(Calendar.HOUR_OF_DAY,hourOfDay);
                cur.set(Calendar.MINUTE,minute);
                cur.set(Calendar.SECOND,0);
                SimpleDateFormat fo=new SimpleDateFormat("hh:mm a",Locale.ENGLISH);
                btnTime2.setText(fo.format(cur.getTimeInMillis()));
            }
        }, 11, 0, false);
        tpd.show();
    }
    private void showTime1()
    {
        TimePickerDialog tpd=new TimePickerDialog(getActivity(), new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

                Calendar cur=Calendar.getInstance();
                cur.set(Calendar.HOUR_OF_DAY,hourOfDay);
                cur.set(Calendar.MINUTE,minute);
                cur.set(Calendar.SECOND,0);
                SimpleDateFormat fo=new SimpleDateFormat("hh:mm a",Locale.ENGLISH);
                btnTime1.setText(fo.format(cur.getTimeInMillis()));

            }
        }, 9, 0, false);
        tpd.show();
    }

    private void onDone() {
    }

    private void showDate()
    {
        final Calendar calendar=Calendar.getInstance();
        int year=calendar.get(Calendar.YEAR);
        int day=calendar.get(Calendar.DAY_OF_MONTH);
        int month=calendar.get(Calendar.MONTH);

        DatePickerDialog dpd=new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int y, int m, int d) {
                Calendar cur=Calendar.getInstance();
                cur.set(Calendar.YEAR,y);
                cur.set(Calendar.MONTH,m);
                cur.set(Calendar.DAY_OF_MONTH,d);

                if(cur.getTimeInMillis()>=calendar.getTimeInMillis())
                {
                    lcontainer.setVisibility(View.VISIBLE);
                    SimpleDateFormat fo=new SimpleDateFormat("dd-MM-yy", Locale.ENGLISH);
                    btnDate.setText(fo.format(cur.getTimeInMillis()));
                    btnDate.setTag(cur.getTimeInMillis());
                }
                else
                {
                    Toast.makeText(getActivity(),"Invalid Date",Toast.LENGTH_LONG).show();
                }

            }
        }, year, month, day);
        dpd.show();

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.faculty_schedule, menu);

    }
}
