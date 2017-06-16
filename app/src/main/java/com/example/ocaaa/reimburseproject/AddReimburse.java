package com.example.ocaaa.reimburseproject;

import android.app.DatePickerDialog;
import android.graphics.Bitmap;
import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Locale;

public class AddReimburse extends AppCompatActivity {


    private DatePickerDialog datePickerDialog;
    private Button btTanggal;
    private Button btUpload;
    private EditText etBiaya;
    private Spinner spinnerJenis;
    private EditText etDeskripsi;
    private TextView tvTanggal;
    private ImageView ivStruk;
    private SimpleDateFormat dateFormatter;
    private Button btBack;
    private Button btSave;
    private Button btCancel;
    private TextView tvJenis;
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

//        dateFormatter = new SimpleDateFormat("dd-MM-yy", Locale.US);
        tvJenis = (TextView) findViewById(R.id.tvJenis);
        tvTanggal = (TextView) findViewById(R.id.tvTanggal);
        btUpload = (Button) findViewById(R.id.btUpload);
        etBiaya = (EditText) findViewById(R.id.etBiaya);
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

        etDeskripsi = (EditText) findViewById(R.id.etDeskripsi);
        ivStruk = (ImageView) findViewById(R.id.ivStruk);
        //btBack = (Button) findViewById(R.id.btBack);
        btSave = (Button) findViewById(R.id.btSave);
        btCancel = (Button) findViewById(R.id.btCancel);
        btTanggal = (Button) findViewById(R.id.btTanggal);

//        btTanggal.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View view){
//                showDateDialog();
//            }
//        });

        btUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        btCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

//        spinnerJenis.setOnItemSelectedListener(new CustomOnItemSelectedListener());
    }

//    public void CustomOnItemSelectedListener implements AdapterView.OnItemSelectedListener{
//
//        public void onItemSelected(AdapterView<> parent,View view,int pos,long id){
//            String firstItem = String.valueOf(spinnerJenis.getSelectedItem());
//            if (firstItem.equals(String.valueOf(spinnerJenis.getSelectedItem()))) {
//            } else {
//            Toast.makeText(parent.getContext(),
//                    "Kamu memilih : " + parent.getItemAtPosition(pos).toString(),
//                    Toast.LENGTH_LONG).show();
//            }
//        }
//    }

//    @RequiresApi(api = Build.VERSION_CODES.N)
//    private void showDateDialog(){
//
//        Calendar myCalendar = Calendar.getInstance();
//
//        datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
//            @Override
//            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
//                Calendar newDate = Calendar.getInstance();
//                newDate.set(year,month,dayOfMonth);
//                tvTanggal.setText(dateFormatter.format(newDate.getTime()));
//            }
//        },myCalendar.get(Calendar.YEAR),myCalendar.get(Calendar.MONTH),myCalendar.get(Calendar.DAY_OF_MONTH));
//        datePickerDialog.show();
//    }

}
