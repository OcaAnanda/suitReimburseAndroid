package com.example.ocaaa.reimburseproject;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by ocaaa on 09/06/17.
 */

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.ViewHolder> {

    private ArrayList<String> rvData;
    private Context context;

    public RVAdapter(Context context,ArrayList<String> inputData) {
        this.context=context;
        rvData = inputData;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tvTitle;
        private TextView tvKategori;
        private TextView tvTanggal;
        private TextView tvHarga;
        private TextView tvStatus;


        public ViewHolder(View v) {
            super(v);
            tvTitle = (TextView) v.findViewById(R.id.tv_title);
            tvKategori = (TextView) v.findViewById(R.id.tv_kategori);
            tvTanggal = (TextView) v.findViewById(R.id.tv_tanggal);
            tvHarga = (TextView) v.findViewById(R.id.tv_prize);
            tvStatus = (TextView) v.findViewById(R.id.tv_status);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // membuat view baru
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_list, parent, false);
        // mengeset ukuran view, margin, padding, dan parameter layout lainnya
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(RVAdapter.ViewHolder holder, int position) {
        // - mengambil elemen dari dataset (ArrayList) pada posisi tertentu
        // - mengeset isi view dengan elemen dari dataset tersebut
        holder.tvTitle.setText(rvData.get(position));
        holder.tvKategori.setText(rvData.get(position));
        holder.tvTanggal.setText(rvData.get(position));
        holder.tvHarga.setText("Rp "+ rvData.get(position));
        holder.tvStatus.setText(rvData.get(position));
    }

    @Override
    public int getItemCount() {
        // menghitung ukuran dataset / jumlah data yang ditampilkan di RecyclerView
        return rvData.size();
    }


}