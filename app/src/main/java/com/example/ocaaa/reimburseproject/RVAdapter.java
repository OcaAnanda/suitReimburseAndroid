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
 * Created by ocaaa on 09/06/17.
 */

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.ViewHolder> {

    private ArrayList<ReimburseMain> rvData;
    private Context context;

    public RVAdapter(Context context,ArrayList<ReimburseMain> inputData) {
        this.context = context;
        rvData = inputData;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // membuat view baru
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_list, parent, false);
        // mengeset ukuran view, margin, padding, dan parameter layout lainnya
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tvTitle;
        private TextView tvKategori;
        private TextView tvTanggal;
        private TextView tvHarga;
        private TextView tvStatus;
        private CardView cardViewReimburse;
        private Date tanggal;

        public ViewHolder(View v) {
            super(v);
            tvTitle = (TextView) v.findViewById(R.id.tv_title);
            tvKategori = (TextView) v.findViewById(R.id.tv_kategori);
            tanggal = new Date();
            tvTanggal = (TextView) v.findViewById(R.id.tv_tanggal);
            tvTanggal.setText(tanggal.toString());
            tvHarga = (TextView) v.findViewById(R.id.tv_prize);
            tvStatus = (TextView) v.findViewById(R.id.tv_status);
            cardViewReimburse = (CardView) v.findViewById(R.id.rv_main);
        }
    }

    @Override
    public void onBindViewHolder(RVAdapter.ViewHolder holder, final int position) {
        // - mengambil elemen dari dataset (ArrayList) pada posisi tertentu
        // - mengeset isi view dengan elemen dari dataset tersebut
        holder.tvTitle.setText(rvData.get(position).getTitle());
        holder.tvKategori.setText(rvData.get(position).getKategori());
        holder.tvTanggal.setText(rvData.get(position).getTanggal().toString());
        holder.tvHarga.setText("Rp "+ rvData.get(position).getHarga());
        holder.tvStatus.setText(rvData.get(position).getStatus());
        holder.cardViewReimburse.setCardBackgroundColor(rvData.indexOf(getItemCount()));
    }

    @Override
    public int getItemCount() {
        // menghitung ukuran dataset / jumlah data yang ditampilkan di RecyclerView
        return rvData.size();
    }


}