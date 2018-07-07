package com.karunendu.qshare.std_farg;

import android.Manifest;
import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.manager.RequestManager;
import com.android.volley.manager.RequestMap;
import com.karunendu.qshare.R;
import com.karunendu.qshare.StdAskQuestionActivity;
import com.karunendu.qshare.adapters.FacultyNameAdapter;
import com.karunendu.qshare.adapters.ShareSpinnerAdapter;
import com.karunendu.qshare.util.ConstantIds;
import com.karunendu.qshare.util.GlobalData;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.util.ArrayList;
import java.util.Map;
import java.util.zip.Inflater;

import ar.com.daidalos.afiledialog.FileChooserActivity;
import ar.com.daidalos.afiledialog.FileChooserDialog;


/**
 * Created by Freeware Sys on 3/6/2017.
 */

public class StdAskQuestionFragment extends Fragment implements View.OnClickListener,RequestManager.RequestListener {

    EditText qns;
    Button post,attachFile;
    Spinner spinnerFaculty;
    ArrayList<String> facultyIds;
    ArrayList<String> facultyVs;
    LayoutInflater inflater;
    File attach;
    private final int PICKFILE_REQUEST_CODE=101;
    ProgressDialog pd;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view=inflater.inflate(R.layout.fragment_std_ask_question,container,false);

        qns=(EditText)view.findViewById(R.id.post_question);
        post=(Button) view.findViewById(R.id.button_bottom);
        this.inflater=inflater;
        spinnerFaculty=(Spinner)view.findViewById(R.id.spinnerFaculty);
        facultyIds=new ArrayList<String>();
        facultyVs=new ArrayList<String>();
        String url= ConstantIds.BASE_URL+"get_faculty.php";
        RequestManager.getInstance().get(url,this,1);
        setHasOptionsMenu(true);

        post.setOnClickListener(this);
        attach=null;
        attachFile=(Button)view.findViewById(R.id.button_attach_file);
        attachFile.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {

        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M  && (view.getId()==R.id.button_attach_file)) {
            int result = ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.READ_EXTERNAL_STORAGE);
            if (result == PackageManager.PERMISSION_DENIED) {
                requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 1001);
            } else
            {
                FileChooserDialog dialog = new FileChooserDialog(getActivity());
                dialog.show();
                dialog.addListener(new FileChooserDialog.OnFileSelectedListener() {
                    public void onFileSelected(Dialog source, File file) {
                        source.hide();
                        /*Toast toast = Toast.makeText(source.getContext(), "File selected: " + file.getName(), Toast.LENGTH_LONG);
                        toast.show();*/
                        showAlert(file);
                        attach=file;
                    }
                    public void onFileSelected(Dialog source, File folder, String name) {
                        source.hide();
                        Toast toast = Toast.makeText(source.getContext(), "File created: " + folder.getName() + "/" + name, Toast.LENGTH_LONG);
                        toast.show();
                    }
                });
            }
        }
        else if (view.getId()==R.id.button_attach_file)
        {
            FileChooserDialog dialog = new FileChooserDialog(getActivity() );
            dialog.show();
            dialog.addListener(new FileChooserDialog.OnFileSelectedListener() {
                public void onFileSelected(Dialog source, File file) {
                    source.hide();
                    Toast toast = Toast.makeText(source.getContext(), "File selected: " + file.getName(), Toast.LENGTH_LONG);
                    toast.show();
                    attach=file;
                }
                public void onFileSelected(Dialog source, File folder, String name) {
                    source.hide();
                    Toast toast = Toast.makeText(source.getContext(), "File created: " + folder.getName() + "/" + name, Toast.LENGTH_LONG);
                    toast.show();
                }
            });
        }
        if(view.getId()==R.id.button_bottom)
        {
            String em=qns.getText().toString();
            if(em.equals(""))
            {
                qns.setError("Rrquired Field Error!");
                qns.requestFocus();
            }
            else {

                String question = qns.getText().toString();
                int sid = GlobalData.id;
                String sem = GlobalData.sem;
                String course = GlobalData.courseID;
                String faculty=facultyIds.get(spinnerFaculty.getSelectedItemPosition());


                String url = ConstantIds.BASE_URL + "std_post_question.php";
                RequestMap map = new RequestMap();
                map.put("sid", String.valueOf(sid));
                map.put("faculty",faculty);
                map.put("qns", question);
                map.put("course", course);
                map.put("sem", sem);

                if (attach != null) {
                    map.put("file", attach);
                }
                RequestManager.getInstance().post(url, map, this, 2);
            }
        }

    }

    private void showAlert(File file)
    {
        AlertDialog.Builder b= new AlertDialog.Builder(getActivity());
        b.setTitle(file.getName());
        b.setMessage(file.getAbsolutePath());
        b.setPositiveButton("OK",null);
        ImageView imageView=new ImageView(getActivity());
        imageView.setImageBitmap(BitmapFactory.decodeFile(file.getAbsolutePath()));
        b.setView(imageView);
        b.show();
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
        try {
            if (actionId == 1) {
                JSONObject obj = new JSONObject(response);
                int status = obj.getInt("status");
                JSONArray courseArray = obj.getJSONArray("Faculty");

                for (int i = 0; i < courseArray.length(); i++) {
                    JSONObject sobj = courseArray.getJSONObject(i);
                    facultyIds.add(sobj.getString("id"));
                    facultyVs.add(sobj.getString("name"));
                }
                FacultyNameAdapter adapter1 = new FacultyNameAdapter(facultyVs, inflater);
                spinnerFaculty.setAdapter(adapter1);

            } else if(actionId==2) {
                JSONObject obj = new JSONObject(response);
                int status = obj.getInt("status");
                String msg = obj.getString("message");
                AlertDialog.Builder c = new AlertDialog.Builder(getActivity());
                c.setTitle("success!");
                c.setMessage(msg);
                c.setPositiveButton("OK", null);
                c.show();
                if (status == 1) {
                    JSONObject data = obj.getJSONObject("data");
                    String student_id = data.getString("sid");
                    String course = data.getString("course");
                    String sem = data.getString("sem");
                    String question = data.getString("qns");

                    Toast.makeText(getActivity(), "student ID" + student_id, Toast.LENGTH_LONG).show();
                    Toast.makeText(getActivity(), "Course" + course, Toast.LENGTH_LONG).show();
                    Toast.makeText(getActivity(), "semester" + sem, Toast.LENGTH_LONG).show();
                    Toast.makeText(getActivity(), "Question" + question, Toast.LENGTH_LONG).show();
                    //Toast.makeText(this,"Hi  Hello",Toast.LENGTH_LONG).show();
                } else {
                    AlertDialog.Builder b = new AlertDialog.Builder(getActivity());
                    b.setTitle("Alert!");
                    b.setMessage(msg);
                    b.setPositiveButton("OK", null);
                    b.show();
                }

            }
        } catch (Exception ex) {

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

    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M) {
            int result = ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.READ_EXTERNAL_STORAGE);
            if (result == PackageManager.PERMISSION_DENIED) {
                requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 1001);
            } else
            {

            }
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
 }
}