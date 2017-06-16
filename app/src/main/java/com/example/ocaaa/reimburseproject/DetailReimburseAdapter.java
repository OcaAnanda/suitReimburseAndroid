package com.example.ocaaa.reimburseproject;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by ocaaa on 13/06/17.
 */

public class DetailReimburseAdapter extends RecyclerView.Adapter<DetailReimburseAdapter.ViewHolder>{

    private ArrayList<Detailreimburse> detail_reimburse_list;
    private Context context;

    public DetailReimburseAdapter(Context context,ArrayList<Detailreimburse> inputData) {
        this.context = context;
        detail_reimburse_list = inputData;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.detil_reimburse_list, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
        }

public class ViewHolder extends RecyclerView.ViewHolder {

    private TextView tvJenis;
    private TextView tvKeterangan;
    private TextView tvTanggal;
    private TextView tvHarga;
    private TextView tvJmlStruk;
    private CardView cvDetailReimburse;
    private Date tanggal;

    public ViewHolder(View v) {
        super(v);
        tvJenis = (TextView) v.findViewById(R.id.tv_jenis);
        tvKeterangan = (TextView) v.findViewById(R.id.tv_keterangan);
        tanggal = new Date();
        tvTanggal = (TextView) v.findViewById(R.id.tv_tanggal);
        tvTanggal.setText(tanggal.toString());
        tvHarga = (TextView) v.findViewById(R.id.tv_harga);
        tvJmlStruk = (TextView) v.findViewById(R.id.tv_struk);
        cvDetailReimburse = (CardView) v.findViewById(R.id.cv_reimburse);
    }
}

    @Override
    public void onBindViewHolder(DetailReimburseAdapter.ViewHolder holder, final int position) {
        holder.tvJenis.setText(detail_reimburse_list.get(position).getJenis());
        holder.tvKeterangan.setText(detail_reimburse_list.get(position).getKeterangan());
        holder.tvTanggal.setText(detail_reimburse_list.get(position).getTanggal().toString());
        holder.tvHarga.setText("Rp "+ detail_reimburse_list.get(position).getHarga());
        holder.tvJmlStruk.setText(Integer.toString(detail_reimburse_list.get(position).getJml_struk())+" Struk");
        holder.cvDetailReimburse.setCardBackgroundColor(detail_reimburse_list.indexOf(getItemCount()));
    }

    @Override
    public int getItemCount() {
        // menghitung ukuran dataset / jumlah data yang ditampilkan di RecyclerView
        return detail_reimburse_list.size();
    }




}