package com.karunendu.qshare.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.karunendu.qshare.LoginRegActivity;
import com.karunendu.qshare.R;

/**
 * Created by Karunendu Mishra on 10/16/2016.
 */
public class FragmentForgotPassword extends Fragment implements View.OnClickListener
{

    EditText editEmail;
    Button btnSubmit,btnBTL;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_forgot_password,container,false);
        editEmail=(EditText)view.findViewById(R.id.float_login_email);
        btnBTL=(Button)view.findViewById(R.id.btn_btl);
        btnSubmit=(Button)view.findViewById(R.id.btn_submit);
        btnSubmit.setOnClickListener(this);
        btnBTL.setOnClickListener(this);
        return  view;
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btn_submit)
        {

        }
        else if(v.getId()==R.id.btn_btl)
        {
            LoginRegActivity activity=(LoginRegActivity)getActivity();
            activity.BTLClicked();
        }
    }
}
