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
import android.text.Html;
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
public class FragmentFacReg extends Fragment implements View.OnClickListener,RequestManager.RequestListener
{
    EditText editEmail,editPass,editName,editPhone;
    Button btnLogin;
    Spinner  spinnerDepart,spinnerDsg;
    ProgressDialog pd;
    ArrayList<String> depIds;
    ArrayList<String> depVs;
    ArrayList<String> dsgIds;
    ArrayList<String> dsgVs;
    LayoutInflater inflater;
    StringBuilder sb;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        this.inflater=inflater;
        View view=inflater.inflate(R.layout.fragment_fac_reg,container,false);
        editEmail=(EditText)view.findViewById(R.id.float_ca_email);
        editPass=(EditText)view.findViewById(R.id.float_login_pass);
        editName=(EditText)view.findViewById(R.id.float_ca_name);
        editPhone=(EditText)view.findViewById(R.id.float_ca_phone);
        spinnerDepart=(Spinner)view.findViewById(R.id.spinnerDepartment);
        spinnerDsg=(Spinner)view.findViewById(R.id.spinnerDSG);
        btnLogin=(Button) view.findViewById(R.id.btn_ca);
        btnLogin.setOnClickListener(this);
        depIds=new ArrayList<String>();
        depVs=new ArrayList<String>();
        dsgIds=new ArrayList<String>();
        dsgVs=new ArrayList<String>();

        String url=ConstantIds.BASE_URL+"fac_dep_dsg.php";
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
          String phone =editPhone.getText().toString();
          String pass =sb.toString();

          String dep =depIds.get(spinnerDepart.getSelectedItemPosition());
          String dsg =dsgIds.get(spinnerDsg.getSelectedItemPosition());

          String url=ConstantIds.BASE_URL+"fac_reg.php";
          RequestMap map=new RequestMap();
          map.put("name",name);
          map.put("email",email);
          map.put("phone",phone);
          map.put("pass",pass);
          map.put("dep",dep);
          map.put("dsg",dsg);

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
                JSONArray designationArray=obj.getJSONArray("designation");
                JSONArray departmentArray=obj.getJSONArray("department");
                for(int i=0;i<designationArray.length();i++)
                {
                    JSONObject sobj=designationArray.getJSONObject(i);
                    dsgIds.add(sobj.getString("id"));
                    dsgVs.add(sobj.getString("value"));
                }
                for(int i=0;i<departmentArray.length();i++)
                {
                    JSONObject sobj=departmentArray.getJSONObject(i);
                    depIds.add(sobj.getString("id"));
                    depVs.add(sobj.getString("value"));
                }

                SpinnersAdapter adapter1=new SpinnersAdapter(depVs,inflater);
                SpinnersAdapter adapter2=new SpinnersAdapter(dsgVs,inflater);

                spinnerDepart.setAdapter(adapter1);
                spinnerDsg.setAdapter(adapter2);

            }
            else if(actionId==2)
            {
                JSONObject obj=new JSONObject(response);
                int status=obj.getInt("status");
                String msg=obj.getString("message");
                if(status==1)
                {
                   // Toast.makeText(getActivity(),msg,Toast.LENGTH_LONG).show();
                    int fac_id=obj.getInt("fac_id");
                  /*  SharedPreferences  sp=getActivity().getSharedPreferences(ConstantIds.APP_PREF, Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor=sp.edit();

                    String name =editName.getText().toString();
                    String email =editEmail.getText().toString();
                    String phone =editPhone.getText().toString();
                    String depid =depIds.get(spinnerDepart.getSelectedItemPosition());
                    String dsgid =dsgIds.get(spinnerDsg.getSelectedItemPosition());
                    String dep =depVs.get(spinnerDepart.getSelectedItemPosition());
                    String dsg =dsgVs.get(spinnerDsg.getSelectedItemPosition());

                    GlobalData.id=fac_id;
                    GlobalData.userType=ConstantIds.FAC_LOGIN;
                    GlobalData.name=name;
                    GlobalData.email=email;
                    GlobalData.phone=phone;
                    GlobalData.dep=dep;
                    GlobalData.dsg=dsg;
                    GlobalData.depId=depid;
                    GlobalData.dsgId=dsgid;

                    editor.putInt(ConstantIds.FAC_ID,fac_id);
                    editor.putInt(ConstantIds.LOGIN_FLAG,ConstantIds.FAC_LOGIN);
                    editor.putString(ConstantIds.FAC_NAME,name);
                    editor.putString(ConstantIds.FAC_PHONE,phone);
                    editor.putString(ConstantIds.FAC_EMAIL,email);
                    editor.putString(ConstantIds.FAC_DEPID,depid);
                    editor.putString(ConstantIds.FAC_DEP,dep);
                    editor.putString(ConstantIds.FAC_DSGID,dsgid);
                    editor.putString(ConstantIds.FAC_DSG,dsg);
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