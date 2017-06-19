package com.example.ocaaa.reimburseproject;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView rvView;
    private ArrayList<ReimburseMain> dataSet = new ArrayList<>();
    private BottomNavigationView bottomNavigationView;
    private ProgressDialog pDialog;
    private String url = "";
    final ArrayList<Reimburse> list = new ArrayList<>();
    ListView listReimburse;
    private SwipeRefreshLayout swipeRefreshLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listReimburse = (ListView) findViewById(R.id.lv_Main);
        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.srl);
        String id = getIntent().getStringExtra("id");;
        String name = getIntent().getStringExtra("name");
        String username = getIntent().getStringExtra("username");
        String email = getIntent().getStringExtra("email");
        String token = getIntent().getStringExtra("token");
        int limit = getIntent().getIntExtra("limit", 0);
        final User user = new User(id, name, username, email, token, limit);

        url = "/user/get/"+id+"?token="+token;

        new getListReimburse().execute();

//
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
//        getSupportActionBar().setTitle("Reimbursement Project");


//        list.add(new Reimburse("1", "2017-06-18", "Project X", "Transportasi", 10000, 0, user));
//        list.add(new Reimburse("12", "2017-06-19", "Project S", "Akomodasi", 2000000, 2, user));
//        list.add(new Reimburse("132", "2017-06-18", "Project A", "Konsumsi", 199900, 1, user));

        ReimburseAdapter adapter = new ReimburseAdapter(MainActivity.this, list);
        listReimburse.setAdapter(adapter);

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                /**
                 * Showing Swipe Refresh animation on activity create
                 * As animation won't start on onCreate, post runnable is used
                 */
                swipeRefreshLayout.post(new Runnable() {
                                            @Override
                                            public void run() {
                                                swipeRefreshLayout.setRefreshing(true);

                                                new getListReimburse().execute();
                                            }
                                        }
                );
            }
        });


        bottomNavigationView = (BottomNavigationView) findViewById(R.id.btm_nav);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Intent intent = new Intent(MainActivity.this, AddReimburse.class);
                intent.putExtra("id", user.getId());
                intent.putExtra("name", user.getName());
                intent.putExtra("username", user.getUsername());
                intent.putExtra("email", user.getEmail());
                intent.putExtra("token", user.getToken());
                intent.putExtra("limit", user.getLimit());
                startActivity(intent);
                return true;
            }
        });
    }@Override
    public void onRestart() {
        super.onRestart();
        new getListReimburse().execute();
    }
    private class getListReimburse extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(MainActivity.this);
            pDialog.setMessage("Please wait...");
            pDialog.setCancelable(false);
            pDialog.show();

        }

        @Override
        protected Void doInBackground(Void... arg0) {
            HttpHandler sh = new HttpHandler();

            String jsonStr = sh.performGetCall(url);
            list.clear();

            if (jsonStr != null) {
                try {
                    JSONObject job = new JSONObject(jsonStr);
                    JSONObject job2 = new JSONObject(job.getString("result"));
                    JSONArray data = new JSONArray(job2.getString("reimburse_data"));

                    for (int i = 0; i < data.length(); i++) {
                        JSONObject c = data.getJSONObject(i);

                        String id = c.getString("id");
                        String date = c.getString("tanggal");
                        String project = c.getString("nama_proyek");
                        String type = c.getString("jenis_pengeluaran");
                        int total = c.getInt("jumlah_pengeluaran");
                        int status = c.getInt("status");

                        Reimburse r = new Reimburse(id, date, project, type, total, status);
                        list.add(r);
                        System.out.println(list.get(i));
                    }
                } catch (final JSONException e) {

                }
            } else {

            }

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            swipeRefreshLayout.setRefreshing(false);
            if (pDialog.isShowing())
                pDialog.dismiss();
            super.onPostExecute(result);
            ReimburseAdapter adapter = new ReimburseAdapter(MainActivity.this, list);
            listReimburse.setAdapter(adapter);
        }
    }
}
