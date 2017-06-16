package com.example.ocaaa.reimburseproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Date;

public class ReimburseActivity extends AppCompatActivity {

    private TextView tvJenis;
    private ImageView ivJenis;
    private TextView tvHarga;
    private TextView tvKeterangan;
    private TextView tvtanggal;
    private TextView jumlahStruk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reimburse);

        tvJenis = (TextView) findViewById(R.id.tv_jenis);
        ivJenis = (ImageView) findViewById(R.id.logo_jenis_reimburse);
        tvHarga = (TextView) findViewById(R.id.tv_harga);
        tvKeterangan = (TextView) findViewById(R.id.tv_keterangan);
        tvtanggal = (TextView) findViewById(R.id.tv_tanggal2);
        jumlahStruk = (TextView) findViewById(R.id.tv_struk);



    }
}
