package com.karunendu.qshare.fragments;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.manager.RequestManager;
import com.android.volley.manager.RequestMap;
import com.karunendu.qshare.FacultyPanelActivity;
import com.karunendu.qshare.R;
import com.karunendu.qshare.StudentPanelActivity;
import com.karunendu.qshare.UserTypeActivity;
import com.karunendu.qshare.adapters.SpinnersAdapter;
import com.karunendu.qshare.util.ConstantIds;
import com.karunendu.qshare.util.GlobalData;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

/**
 * Created by Karunendu Mishra on 10/2/2016.
 */
public class FragmentStdReg extends Fragment implements View.OnClickListener,RequestManager.RequestListener
{
    EditText editEmail,editPass,editName,editRoll;
    Button btnLogin;
    Spinner  spinnerCourse,spinnerSemester;
    ProgressDialog pd;
    ArrayList<String> courseIds;
    ArrayList<String> courseVs;
    ArrayList<String> semIds;
    ArrayList<String> semVs;
    LayoutInflater inflater;
    StringBuilder sb;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        this.inflater=inflater;
        View view=inflater.inflate(R.layout.fragment_std_reg,container,false);
        editEmail=(EditText)view.findViewById(R.id.float_ca_email);
        editPass=(EditText)view.findViewById(R.id.float_login_pass);
        editName=(EditText)view.findViewById(R.id.float_ca_name);
        editRoll=(EditText)view.findViewById(R.id.float_ca_roll);
        spinnerCourse=(Spinner)view.findViewById(R.id.spinnerCourse);
        spinnerSemester=(Spinner)view.findViewById(R.id.spinnerSemester);

        btnLogin=(Button) view.findViewById(R.id.btn_ca);
        btnLogin.setOnClickListener(this);
        courseIds=new ArrayList<String>();
        courseVs=new ArrayList<String>();
        semIds=new ArrayList<String>();
        semVs=new ArrayList<String>();

        String url=ConstantIds.BASE_URL+"get_course_sem.php";
        RequestManager.getInstance().get(url,this,1);


        char[] chars="qwertyuiopasdfghjklzxcvbnm".toCharArray();
        sb=new StringBuilder();
        Random random=new Random();
        for(int i=0;i<=6;i++)
        {
            char c=chars[random.nextInt(chars.length)];
            sb.append(c);
        }

        return view;

    }

    @Override
    public void onClick(View v)
    {
      if(v.getId()==R.id.btn_ca)
      {
          String name =editName.getText().toString();
          String email =editEmail.getText().toString();
          String roll =editRoll.getText().toString();
          String pass =sb.toString();

          String course =courseIds.get(spinnerCourse.getSelectedItemPosition());
          String sem=semIds.get(spinnerSemester.getSelectedItemPosition());

          String url=ConstantIds.BASE_URL+"std_reg.php";
          RequestMap map=new RequestMap();
          map.put("roll",roll);
          map.put("name",name);
          map.put("email",email);

          map.put("pass",pass);
          map.put("course",course);
          map.put("sem",sem);

          RequestManager.getInstance().post(url,map,this,2);


      }

    }

    @Override
    public void onRequest() {
        pd=new ProgressDialog(getActivity());
        pd.setMessage("Please wait...");
        pd.show();
    }

    @Override
    public void onSuccess(String response, Map<String, String> headers, String url, int actionId) {
        pd.dismiss();

        try
        {
            if(actionId==1)
            {
                JSONObject obj=new JSONObject(response);
                int status=obj.getInt("status");
                JSONArray designationArray=obj.getJSONArray("course");
                JSONArray departmentArray=obj.getJSONArray("semester");
                for(int i=0;i<designationArray.length();i++)
                {
                    JSONObject sobj=designationArray.getJSONObject(i);
                    courseIds.add(sobj.getString("id"));
                    courseVs.add(sobj.getString("value"));
                }
                for(int i=0;i<departmentArray.length();i++)
                {
                    JSONObject sobj=departmentArray.getJSONObject(i);
                    semIds.add(sobj.getString("id"));
                    semVs.add(sobj.getString("value"));
                }

                SpinnersAdapter adapter1=new SpinnersAdapter(courseVs,inflater);
                SpinnersAdapter adapter2=new SpinnersAdapter(semVs,inflater);
                spinnerCourse.setAdapter(adapter1);
                spinnerSemester.setAdapter(adapter2);


            }
            else if(actionId==2)
            {
                JSONObject obj=new JSONObject(response);
                int status=obj.getInt("status");
                String msg=obj.getString("message");

                if(status==1)
                {
                   // Toast.makeText(getActivity(),msg,Toast.LENGTH_LONG).show();


                    int std_id=obj.getInt("id");
                   /* SharedPreferences  sp=getActivity().getSharedPreferences(ConstantIds.APP_PREF, Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor=sp.edit();

                    String name =editName.getText().toString();
                    String email =editEmail.getText().toString();
                    String roll =editRoll.getText().toString();
                    String courseid =courseIds.get(spinnerCourse.getSelectedItemPosition());
                    String course =courseVs.get(spinnerCourse.getSelectedItemPosition());
                    String semid =semIds.get(spinnerCourse.getSelectedItemPosition());
                    String sem =semVs.get(spinnerCourse.getSelectedItemPosition());


                    GlobalData.id=std_id;
                    GlobalData.userType=ConstantIds.STD_LOGIN;
                    GlobalData.name=name;
                    GlobalData.email=email;
                    GlobalData.roll=roll;
                    GlobalData.course=course;
                    GlobalData.courseID=courseid;
                    GlobalData.sem=sem;
                    GlobalData.semID=semid;

                    editor.putInt(ConstantIds.STD_ID,std_id);
                    editor.putInt(ConstantIds.LOGIN_FLAG,GlobalData.userType);
                    editor.putString(ConstantIds.STD_NAME,name);
                    editor.putString(ConstantIds.STD_ROLL,roll);
                    editor.putString(ConstantIds.STD_EMAIL,email);
                    editor.putString(ConstantIds.STD_COURSE,course);
                    editor.putString(ConstantIds.STD_COURSEID,courseid);
                    editor.putString(ConstantIds.STD_SEM,sem);
                    editor.putString(ConstantIds.STD_SEMID,semid);
                    editor.commit();*/
                    String s = "Registration Successful ... Please Contact CCE office for your Password";
                    AlertDialog.Builder k=new AlertDialog.Builder(getActivity());
                    k.setTitle("Alert!");
                    k.setMessage(s);
                    k.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface arg0, int arg1) {
                            Intent intent = new Intent(getContext(), UserTypeActivity.class);
                            startActivity(intent);
                        }});
                   // b.setPositiveButton("Ok",startActivity(new Intent(getContext(),UserTypeActivity.class)));
                    k.show();




                }
                else
                {
                    AlertDialog.Builder b=new AlertDialog.Builder(getActivity());
                    b.setTitle("Alert!");
                    b.setMessage(msg);
                    b.setPositiveButton("Ok",null);
                    b.show();
                }
            }
        }
        catch (Exception ex)
        {

        }
    }

    @Override
    public void onError(String errorMsg, String url, int actionId) {
        pd.dismiss();
    }
}
