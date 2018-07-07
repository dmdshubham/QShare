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

import com.android.volley.manager.RequestManager;
import com.android.volley.manager.RequestMap;
import com.karunendu.qshare.FacultyPanelActivity;
import com.karunendu.qshare.LoginRegActivity;
import com.karunendu.qshare.R;
import com.karunendu.qshare.util.ConstantIds;
import com.karunendu.qshare.util.GlobalData;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Map;

/**
 * Created by Karunendu Mishra on 10/2/2016.
 */
public class FragmentFacLogin extends Fragment implements View.OnClickListener,RequestManager.RequestListener
{
    EditText editEmail,editPass;
    Button btnLogin,btnFP;
    ProgressDialog pd;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_fac_login,container,false);
        editEmail=(EditText)view.findViewById(R.id.float_login_email);
        editPass=(EditText)view.findViewById(R.id.float_login_pass);
        btnLogin=(Button) view.findViewById(R.id.btn_login);
        btnFP=(Button) view.findViewById(R.id.btn_fp);
        btnFP.setOnClickListener(this);
        btnLogin.setOnClickListener(this);


        String text="<u>"+btnFP.getText()+"</u>";
        btnFP.setText(Html.fromHtml(text));
        return view;
    }

    @Override
    public void onClick(View v)
    {
      if(v.getId()==R.id.btn_login)
      {
          String em=editEmail.getText().toString();
          String ps=editPass.getText().toString();
          if(em.equals(""))
          {
              editEmail.setError("Required field*");
              editEmail.requestFocus();
          }
          else if(ps.equals(""))
          {
              editPass.setError("Required field*");
              editPass.requestFocus();
          }
          else
          {
              //Endpoint, req, parameter,resp
              String url=ConstantIds.BASE_URL+"fac_login.php";
              RequestMap map=new RequestMap();
              map.put("email",em);
              map.put("pass",ps);
              RequestManager.getInstance().post(url,map,this,1);
          }

      }
      else if(v.getId()==R.id.btn_fp)
      {
          LoginRegActivity activity=(LoginRegActivity)getActivity();
          activity.frogotPasswordClicked();
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
            JSONObject obj=new JSONObject(response);
            int status=obj.getInt("status");
            String msg=obj.getString("message");
            if(status==1)
            {
                JSONObject data=obj.getJSONObject("data");
                int id=data.getInt("id");
                String name=data.getString("name");
                String email=data.getString("email");
                String phone=data.getString("phone");
                String depId=data.getString("department");
                String dsgId=data.getString("designation");
                String dep=data.getString("dep");
                String dsg=data.getString("dsg");
                String profile=data.getString("profile_pic");

                GlobalData.id=id;
                GlobalData.userType=ConstantIds.FAC_LOGIN;
                GlobalData.name=name;
                GlobalData.email=email;
                GlobalData.phone=phone;
                GlobalData.dep=dep;
                GlobalData.dsg=dsg;
                GlobalData.depId=depId;
                GlobalData.dsgId=dsgId;
                GlobalData.profile_pic=profile;

                SharedPreferences sp=getActivity().getSharedPreferences(ConstantIds.APP_PREF, Context.MODE_PRIVATE);
                SharedPreferences.Editor editor=sp.edit();
                editor.putInt(ConstantIds.FAC_ID,id);
                editor.putInt(ConstantIds.LOGIN_FLAG,ConstantIds.FAC_LOGIN);
                editor.putString(ConstantIds.FAC_NAME,name);
                editor.putString(ConstantIds.FAC_PHONE,phone);
                editor.putString(ConstantIds.FAC_EMAIL,email);
                editor.putString(ConstantIds.FAC_DEPID,depId);
                editor.putString(ConstantIds.FAC_DEP,dep);
                editor.putString(ConstantIds.FAC_DSGID,dsgId);
                editor.putString(ConstantIds.FAC_DSG,dsg);
                editor.putString(ConstantIds.FAC_PROFILE,profile);
                editor.commit();

                AlertDialog.Builder b=new AlertDialog.Builder(getActivity());
                b.setTitle("Congrats!");
                b.setMessage(msg);
                b.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent=new Intent(getActivity(), FacultyPanelActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intent);
                    }
                });
                b.setCancelable(false);
                b.show();
            }
            else
            {
                AlertDialog.Builder b=new AlertDialog.Builder(getActivity());
                b.setTitle("Alert!");
                b.setMessage(msg);
                b.setPositiveButton("OK",null);
                b.show();
            }

        }
        catch (Exception ex)
        {

        }

    }

    @Override
    public void onError(String errorMsg, String url, int actionId) {
        pd.dismiss();
        AlertDialog.Builder b=new AlertDialog.Builder(getActivity());
        b.setTitle("Error!");
        b.setMessage(errorMsg);
        b.setPositiveButton("OK",null);
        b.show();
    }
}
