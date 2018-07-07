package com.karunendu.qshare.std_farg;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.manager.RequestManager;
import com.android.volley.manager.RequestMap;
import com.github.rubensousa.bottomsheetbuilder.BottomSheetBuilder;
import com.github.rubensousa.bottomsheetbuilder.BottomSheetMenuDialog;
import com.github.rubensousa.bottomsheetbuilder.adapter.BottomSheetItemClickListener;
import com.karunendu.qshare.FacultyPanelActivity;
import com.karunendu.qshare.R;
import com.karunendu.qshare.StudentPanelActivity;
import com.karunendu.qshare.util.ConstantIds;
import com.karunendu.qshare.util.Constants;
import com.karunendu.qshare.util.GlobalData;
import com.mikhaellopez.circularimageview.CircularImageView;
import com.nostra13.universalimageloader.core.ImageLoader;

import org.json.JSONObject;

import java.io.File;
import java.util.Map;

/**
 * Created by Freeware Sys on 7/31/2017.
 */

public class StdProfileFragment extends Fragment implements View.OnClickListener,RequestManager.RequestListener {

    CircularImageView profilePic;
    EditText phone;
    Button btn_ca;
    ProgressDialog pd;
    Uri uri;


    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // return super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_std_profile, container, false);

        profilePic=(CircularImageView)view.findViewById(R.id.std_profile_pic);

        SharedPreferences sp=getActivity().getSharedPreferences(ConstantIds.APP_PREF,Context.MODE_PRIVATE);
        String url1=sp.getString(ConstantIds.STD_PROFILE_PIC,null);
       if(url1!=null) {
           ImageLoader imageLoader = ImageLoader.getInstance();
           imageLoader.displayImage(url1, profilePic);
       }

        phone=(EditText)view.findViewById(R.id.std_phone);
        btn_ca=(Button)view.findViewById(R.id.btn_ca);
        profilePic.setOnClickListener(this);
        btn_ca.setOnClickListener(this);
        uri=null;

        return view;
    }
    public void onClick(View v) {
        if(v.equals(profilePic))
        {
            showImagePicker();
        }
        if(v.getId()==R.id.btn_ca)
        {
            String phone1 = phone.getText().toString().trim();
            RequestMap map=new RequestMap();
            map.put("name",phone1);
            map.put("sid",String.valueOf(GlobalData.id));
            if(uri==null) {
                File f = new File(android.os.Environment.getExternalStorageDirectory(), "temp.jpg");
                map.put("image", new File(f.getAbsolutePath()));
            }
            else{
                String path = getPath(uri);
                map.put("image",new File(path));
            }
            RequestManager.getInstance().post(Constants.STD_PROFILE,map,this,2);
        }
    }

    private void showImagePicker()
    {
        BottomSheetMenuDialog dialog = new BottomSheetBuilder(getActivity(), R.style.AppTheme_BottomSheetDialog)
                .setMode(BottomSheetBuilder.MODE_LIST)
                .setMenu(R.menu.menu_image_picker)
                .setItemClickListener(new BottomSheetItemClickListener() {
                    @Override
                    public void onBottomSheetItemClick(MenuItem item)
                    {
                        int id=item.getItemId();
                        if(id==R.id.item_camera)
                        {
                            fromCamera();
                        }
                        else
                        {
                            fromGallery();
                        }
                    }
                })
                .createDialog();
        dialog.show();
    }
    private void fromCamera()
    {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        File f = new File(android.os.Environment.getExternalStorageDirectory(), "temp.jpg");
        intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(f));
        //pic = f;
        startActivityForResult(intent, 1002);
    }
    private void fromGallery()
    {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), 1001);
       // startActivityForResult(intent,1001);
    }
    public String getPath(Uri uri) {
        Cursor cursor = getActivity().getContentResolver().query(uri, null, null, null, null);
        cursor.moveToFirst();
        String document_id = cursor.getString(0);
        document_id = document_id.substring(document_id.lastIndexOf(":") + 1);
        cursor.close();

        cursor = getActivity().getContentResolver().query(
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                null, MediaStore.Images.Media._ID + " = ? ", new String[]{document_id}, null);
        cursor.moveToFirst();
        String path = cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DATA));
        cursor.close();

        return path;
    }
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode== Activity.RESULT_OK)
        {
            if(requestCode==1001)
            {
                uri=data.getData();
                profilePic.setImageURI(uri);
                // Toast.makeText(getActivity(),"URI : "+uri,Toast.LENGTH_LONG).show();
            }
            else if(requestCode==1002)
            {
                File f = new File(android.os.Environment.getExternalStorageDirectory(), "temp.jpg");
                uri=Uri.fromFile(f);
                profilePic.setImageURI(uri);
                uri=null;
                //   Toast.makeText(getActivity(),"URI : "+uri,Toast.LENGTH_LONG).show();
            }

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
        try{
            if (actionId == 2) {

                JSONObject obj = new JSONObject(response);
                int status = obj.getInt("status");
                String msg = obj.getString("message");

                if (status == 1) {
                   String profile=obj.getString("url");
                    GlobalData.std_profile_pic=profile;
                    SharedPreferences sp=getActivity().getSharedPreferences(ConstantIds.APP_PREF, Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor=sp.edit();
                    editor.putString(ConstantIds.STD_PROFILE_PIC,profile);
                    editor.commit();
                    String url1=profile;
                    ImageLoader imageLoader=ImageLoader.getInstance();
                    imageLoader.displayImage(url1,profilePic);


                    Toast.makeText(getActivity(),msg,Toast.LENGTH_LONG).show();
                    Intent intent=new Intent(getActivity(), StudentPanelActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                } else {
                    AlertDialog.Builder b = new AlertDialog.Builder(getActivity());
                    b.setTitle("Alert!");
                    b.setMessage(msg);
                    b.setPositiveButton("Ok", null);
                    b.show();
                }
            }}
        catch (Exception e){

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
