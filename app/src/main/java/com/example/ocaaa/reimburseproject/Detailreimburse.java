package com.example.ocaaa.reimburseproject;

import java.util.Date;

/**
 * Created by ocaaa on 13/06/17.
 */

public class Detailreimburse {
    private String jenis,keterangan;
    private int icon,harga,jml_struk;
    private Date tanggal;

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public int getJml_struk() {
        return jml_struk;
    }

    public void setJml_struk(int jml_struk) {
        this.jml_struk = jml_struk;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }
}
