package com.risqi17.drawer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class PilihPesanan extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pilih_pesanan);
        getSupportActionBar().setTitle("Pilih Pesanan");
    }
}