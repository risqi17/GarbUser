package com.risqi17.drawer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PilihPesanan extends AppCompatActivity {
    private Button celana;
    private Button kemeja;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pilih_pesanan);
        getSupportActionBar().setTitle("Pilih Pesanan");

        celana = (Button)findViewById(R.id.btCelana);
        kemeja = (Button)findViewById(R.id.btKemeja);
        celana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Celana.class);
                startActivity(i);
            }
        });
        kemeja.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Kemeja.class);
                startActivity(i);
            }
        });
    }
}
