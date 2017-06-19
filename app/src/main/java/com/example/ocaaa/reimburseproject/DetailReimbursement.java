package com.example.ocaaa.reimburseproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by ocaaa on 12/06/17.
 */

public class DetailReimbursement extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView1;
    private RecyclerView rvView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<Detailreimburse> dataSet = new ArrayList<>();
    private ImageButton editReimburse;
    private TextView tvJenis;
    private TextView tvHarga;



    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_reimbursement);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(false);

        rvView = (RecyclerView) findViewById(R.id.reimburse_detail_rv);
        rvView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        rvView.setLayoutManager(layoutManager);

        adapter = new DetailReimburseAdapter(DetailReimbursement.this,dataSet);
        rvView.setAdapter(adapter);

        editReimburse = (ImageButton) findViewById(R.id.edit_reimburse);
        editReimburse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailReimbursement.this,AddReimburse.class);
                startActivity(intent);
            }
        });

        bottomNavigationView1 = (BottomNavigationView) findViewById(R.id.btm_nav_detail_reimburse);
        bottomNavigationView1.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.action_transport :
                        Toast.makeText(DetailReimbursement.this, "Transportasi", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_akomodasi :
                        Toast.makeText(DetailReimbursement.this, "Akomodasi", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_konsum :
                        Toast.makeText(DetailReimbursement.this, "Konsumsi", Toast.LENGTH_SHORT).show();
                        break;
                }

                return true;
            }
        });

        super.onCreate(savedInstanceState);
    }
}
