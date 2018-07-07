package com.karunendu.qshare;

import android.Manifest;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.manager.RequestManager;
import com.android.volley.manager.RequestMap;
import com.karunendu.qshare.util.ConstantIds;
import com.karunendu.qshare.util.GlobalData;

import org.json.JSONObject;

import java.io.File;
import java.util.Map;

import ar.com.daidalos.afiledialog.FileChooserDialog;

public class StudentPostAnswer extends AppCompatActivity implements View.OnClickListener,RequestManager.RequestListener {
    TextView textView1;
    Button post, attachFile;
    EditText answer;
    File attach;
    Long qid;
    ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_post_answer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar ab = getSupportActionBar();
        ab.setDisplayShowTitleEnabled(false);
        ab.setDisplayShowCustomEnabled(true);
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#34495e")));

        View view = getLayoutInflater().inflate(R.layout.action_bar_home, null);
        TextView titleText = (TextView) view.findViewById(R.id.titleText);
        titleText.setText("Student Post Answer");
        ActionBar.LayoutParams lp = new ActionBar.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT,
                Gravity.CENTER
        );
        ab.setCustomView(view, lp);

        textView1 = (TextView) findViewById(R.id.tv1);
        post = (Button) findViewById(R.id.post_answer);
        attachFile = (Button) findViewById(R.id.button_attach_file);
        answer = (EditText) findViewById(R.id.answer);

        post.setOnClickListener(this);
        attachFile.setOnClickListener(this);

        Intent iin = getIntent();
        Bundle b = iin.getExtras();
        if (b != null) {
            String s1 = (String) b.get("question");
            qid = (Long) b.get("Id");
            textView1.setText(s1);
           // Toast.makeText(getApplicationContext(), "" + s1 + "ID==" + qid, Toast.LENGTH_LONG).show();
        }

    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && (view.getId() == R.id.button_attach_file)) {
            int result = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE);
            if (result == PackageManager.PERMISSION_DENIED) {
                requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 1001);
            } else {
                FileChooserDialog dialog = new FileChooserDialog(this);
                dialog.show();
                dialog.addListener(new FileChooserDialog.OnFileSelectedListener() {
                    public void onFileSelected(Dialog source, File file) {
                        source.hide();
                        Toast toast = Toast.makeText(source.getContext(), "File selected: " + file.getName(), Toast.LENGTH_LONG);
                        toast.show();
                        attach = file;
                    }

                    public void onFileSelected(Dialog source, File folder, String name) {
                        source.hide();
                        Toast toast = Toast.makeText(source.getContext(), "File created: " + folder.getName() + "/" + name, Toast.LENGTH_LONG);
                        toast.show();
                    }
                });
            }

        }

        if (view.getId() == R.id.post_answer) {
            String em = answer.getText().toString();
            if (em.equals("")) {
                answer.setError("Rrquired Field Error!");
                answer.requestFocus();
            } else {
                String ans = answer.getText().toString();
                int sid = GlobalData.id;
               // String attachFile = attach.getName();

                String url = ConstantIds.BASE_URL + "std_post_answer.php";
                RequestMap map = new RequestMap();
                map.put("sid", String.valueOf(sid));
                map.put("ans", ans);
                map.put("qid", String.valueOf(qid));
                if (attach != null)
                    map.put("file", attach);
                RequestManager.getInstance().post(url, map, this, 2);
            }
        }
    }

    private void showAlert(File file) {
        AlertDialog.Builder b = new AlertDialog.Builder(this);
        b.setTitle(file.getName());
        b.setMessage(file.getAbsolutePath());
        b.setPositiveButton("OK", null);
        ImageView imageView = new ImageView(this);
        imageView.setImageBitmap(BitmapFactory.decodeFile(file.getAbsolutePath()));
        b.setView(imageView);
        b.show();
    }

    @Override
    public void onRequest() {
        pd = new ProgressDialog(this);
        pd.setMessage("Loading...");
        pd.setCancelable(false);
        pd.show();
    }

    @Override
    public void onSuccess(String response, Map<String, String> headers, String url, int actionId) {
        pd.dismiss();
        try {

            if (actionId == 2) {
                JSONObject obj = new JSONObject(response);
                int status = obj.getInt("status");
                String msg = obj.getString("message");
                AlertDialog.Builder c = new AlertDialog.Builder(this);
                c.setTitle("success!");
                c.setMessage(msg);
                c.setPositiveButton("OK", null);
                c.show();

                if (status == 1) {
                    JSONObject data = obj.getJSONObject("data");
                    String student_id = data.getString("sid");
                    String qid = data.getString("id");
                    String sem = data.getString("sem");
                    String answer = data.getString("ans");
                     }
                else {
                    AlertDialog.Builder b = new AlertDialog.Builder(this);
                    b.setTitle("Alert!");
                    b.setMessage(msg);
                    b.setPositiveButton("OK", null);
                    b.show();
                }
            }

        } catch (Exception e) {

        }

    }
        @Override
        public void onError (String errorMsg, String url,int actionId){
            pd.dismiss();
            AlertDialog.Builder b=new AlertDialog.Builder(this);
            b.setTitle("Error!");
            b.setMessage(errorMsg);
            b.setPositiveButton("OK",null);
            b.show();

        }
    }

