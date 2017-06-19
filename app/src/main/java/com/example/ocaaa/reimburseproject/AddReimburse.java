package com.example.ocaaa.reimburseproject;

import android.app.ActionBar;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.icu.text.SimpleDateFormat;
import android.os.AsyncTask;
import android.os.Build;
import android.provider.MediaStore;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.NumberFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;

public class AddReimburse extends AppCompatActivity {


    private static final int CAMERA_REQUEST = 0;
    private static final int IMAGE_REQUEST = 1;
    private DatePickerDialog datePickerDialog;
    private Button btUpload;
    private EditText etBiaya;
    private Spinner spinnerJenis;
    private ImageButton btCamera;
    private EditText etKeterangan;
    private EditText etTanggal;
    private EditText etProject;
    private ImageView ivStruk;
    private SimpleDateFormat dateFormatter;
    private Button btBack;
    private Button btSave;
    private Button btCancel;
    private TextView tvJenis;
    private ProgressDialog pDialog;

    String id;
    String name;
    String username;
    String email;
    String token;
    int limit;
    User user;
//    Bitmap bitmap;
//    int success;
//    int PICK_IMAGE_REQUEST = 1;
//
//    private static final String TAG = MainActivity.class.getSimpleName();
//    private String UPLOAD_URL ="http://192.168.1.35/android/upload_image/upload.php";
//
//    private static final String TAG_SUCCESS = "success";
//    private static final String TAG_MESSAGE = "message";
//    private String KEY_IMAGE = "image";
//    private String KEY_NAME = "name";
//
//    String tag_json_obj = "json_obj_req";
//    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_reimburse);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        id = getIntent().getStringExtra("id");
        name = getIntent().getStringExtra("name");
        username = getIntent().getStringExtra("username");
        email = getIntent().getStringExtra("email");
        token = getIntent().getStringExtra("token");
        //limit = Integer.valueOf(getIntent().getStringExtra("limit"));
        user = new User(id, name, username, email, token, 0);

//        dateFormatter = new SimpleDateFormat("dd-MM-yy", Locale.US);
        tvJenis = (TextView) findViewById(R.id.tvJenis);
        btUpload = (Button) findViewById(R.id.btUpload);
        etTanggal = (EditText) findViewById(R.id.etTanggal);
        etTanggal.setTextColor(Color.BLACK);
        btCamera = (ImageButton) findViewById(R.id.btCamera);
        etBiaya = (EditText) findViewById(R.id.etBiaya);
        etBiaya.setTextColor(Color.BLACK);
        etKeterangan = (EditText) findViewById(R.id.etKeterangan);
        etKeterangan.setTextColor(Color.BLACK);
        etProject = (EditText) findViewById(R.id.etProject);
        etProject.setTextColor(Color.BLACK);

        spinnerJenis = (Spinner) findViewById(R.id.spinnerJenis);
        spinnerJenis.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            String firstitem = String.valueOf(spinnerJenis.getSelectedItem());
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    tvJenis.setText(spinnerJenis.getSelectedItem().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        etKeterangan = (EditText) findViewById(R.id.etKeterangan);
        ivStruk = (ImageView) findViewById(R.id.ivStruk);
        btSave = (Button) findViewById(R.id.btSave);
        btCancel = (Button) findViewById(R.id.btCancel);

        btCamera.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, CAMERA_REQUEST);
            }
        });


        btUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, IMAGE_REQUEST);
            }
        });

        btSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SaveReimburse sr = new SaveReimburse();
                sr.execute();
            }
        });
        btCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

    }
    private class SaveReimburse extends AsyncTask<Void, Void, Void> {

        String tanggal = etTanggal.getText().toString();
        String project = etProject.getText().toString();
        String type = spinnerJenis.getSelectedItem().toString();
        String total = etBiaya.getText().toString();
        String details = etKeterangan.getText().toString();
        String msg = "";

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(AddReimburse.this);
            pDialog.setMessage("Please wait...");
            pDialog.setCancelable(false);
            pDialog.show();

        }

        @Override
        protected Void doInBackground(Void... arg0) {
            String url = "/reimburse/new";

            HttpHandler sh = new HttpHandler();
            HashMap<String, String> stringMap = new HashMap<>();
            stringMap.put("token", user.getToken());
            stringMap.put("user_id", user.getId());
            stringMap.put("tanggal", tanggal);
            stringMap.put("nama_proyek", project);
            stringMap.put("jenis_pengeluaran", type);
            stringMap.put("jumlah_pengeluaran", total);
            stringMap.put("keterangan", details);

            String jsonStr = sh.performPostCall(url, stringMap);

            if (jsonStr != null) {
                try {
                    JSONObject u = new JSONObject(jsonStr);
                    msg=u.getString("message");

                } catch (final JSONException e) {

                }
            } else {

            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            if (pDialog.isShowing())
                pDialog.dismiss();
            Log.e("MSG", msg);
        }
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CAMERA_REQUEST && resultCode == Activity.RESULT_OK) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            ivStruk.setImageBitmap(photo);
        }
        if(requestCode == IMAGE_REQUEST && resultCode == Activity.RESULT_OK) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            ivStruk.setImageBitmap(photo);
        }
    }

}
