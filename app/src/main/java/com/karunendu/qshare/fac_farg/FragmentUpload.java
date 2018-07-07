package com.karunendu.qshare.fac_farg;

import android.Manifest;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
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
import com.karunendu.qshare.FacultyPanelActivity;
import com.karunendu.qshare.R;
import com.karunendu.qshare.adapters.ShareSpinnerAdapter;
import com.karunendu.qshare.util.ConstantIds;
import com.karunendu.qshare.util.GlobalData;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.util.ArrayList;
import java.util.Map;

import ar.com.daidalos.afiledialog.FileChooserDialog;

import static com.karunendu.qshare.R.id.share_title;

/**
 * Created by Karunendu Mishra on 11/6/2016.
 */
public class FragmentUpload extends Fragment implements View.OnClickListener,RequestManager.RequestListener{

    EditText editTitle,editSubject,editText;
    Spinner spinnerSem,spinnerCourse;
    Button attach_file,share;
    File attach;
    ProgressDialog pd;
    ArrayList<String> semIds;
    ArrayList<String> semVs;
    ArrayList<String> courseIds;
    ArrayList<String> courseVs;
    LayoutInflater inflater;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        this.inflater=inflater;
        View view=inflater.inflate(R.layout.fragment_fac_upload,container,false);
        editTitle=(EditText)view.findViewById(R.id.share_title);
        editSubject=(EditText)view.findViewById(R.id.share_subject);
        editText=(EditText)view.findViewById(R.id.share_text);
        spinnerSem=(Spinner)view.findViewById(R.id.spinnerSem);
        spinnerCourse=(Spinner)view.findViewById(R.id.spinnerCourse);

        attach=null;
        attach_file=(Button)view.findViewById(R.id.attache_file);
        attach_file.setOnClickListener(this);

        share=(Button)view.findViewById(R.id.share);
        share.setOnClickListener(this);

        semIds=new ArrayList<String>();
        semVs=new ArrayList<String>();
        courseIds=new ArrayList<String>();
        courseVs=new ArrayList<String>();
        String url= ConstantIds.BASE_URL+"get_course_sem.php";
        RequestManager.getInstance().get(url,this,1);
        setHasOptionsMenu(true);
        return view;
    }

    @Override
    public void onClick(View view) {
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M  && (view.getId()==R.id.attache_file)) {
            int result = ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.READ_EXTERNAL_STORAGE);
            if (result == PackageManager.PERMISSION_DENIED) {
                requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 1001);
            } else
            {
                FileChooserDialog dialog = new FileChooserDialog(getActivity());
                dialog.show();

             /*  Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("file*//*");
                startActivityForResult(intent, PICKFILE_REQUEST_CODE);*/
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
        }else if (view.getId()==R.id.attache_file)
        {
            FileChooserDialog dialog = new FileChooserDialog(getActivity() );
            dialog.show();
           /* Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
            intent.setType("file*//*");
            startActivityForResult(intent, PICKFILE_REQUEST_CODE);*/

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

        if(view.getId()==R.id.share)
        {
            String fid=String.valueOf(GlobalData.id);
            String title =editTitle.getText().toString();
            String subject =editSubject.getText().toString();
            String text =editText.getText().toString();

            String dep =semIds.get(spinnerSem.getSelectedItemPosition());
            String dsg =courseIds.get(spinnerCourse.getSelectedItemPosition());

            String url=ConstantIds.BASE_URL+"fac_share_material.php";
            RequestMap map=new RequestMap();
            map.put("fid",fid);
            map.put("title",title);
            map.put("subject",subject);

            map.put("sem",dep);
            map.put("course",dsg);
            map.put("text",text);

            if(attach!=null)
                map.put("file",attach);

            RequestManager.getInstance().post(url,map,this,2);
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
                JSONArray courseArray = obj.getJSONArray("course");
                JSONArray semesterArray = obj.getJSONArray("semester");
                for (int i = 0; i < courseArray.length(); i++) {
                    JSONObject sobj = courseArray.getJSONObject(i);
                    courseIds.add(sobj.getString("id"));
                    courseVs.add(sobj.getString("value"));
                }
                for (int i = 0; i < semesterArray.length(); i++) {
                    JSONObject sobj = semesterArray.getJSONObject(i);
                    semIds.add(sobj.getString("id"));
                    semVs.add(sobj.getString("value"));
                }

                ShareSpinnerAdapter adapter1 = new ShareSpinnerAdapter(courseVs, inflater);
                ShareSpinnerAdapter adapter2 = new ShareSpinnerAdapter(semVs, inflater);

                spinnerCourse.setAdapter(adapter1);
                spinnerSem.setAdapter(adapter2);

            } else if (actionId == 2) {

                JSONObject obj = new JSONObject(response);
                int status = obj.getInt("status");
                String msg = obj.getString("message");
                if (status == 1) {
                    Toast.makeText(getActivity(),msg,Toast.LENGTH_LONG).show();
                    Intent intent=new Intent(getActivity(), FacultyPanelActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                } else {
                    AlertDialog.Builder b = new AlertDialog.Builder(getActivity());
                    b.setTitle("Alert!");
                    b.setMessage(msg);
                    b.setPositiveButton("Ok", null);
                    b.show();
                }
            }

        }catch(Exception e){

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
