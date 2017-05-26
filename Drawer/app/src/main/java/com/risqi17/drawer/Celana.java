package com.risqi17.drawer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

public class Celana extends AppCompatActivity {
    private RadioButton radioPj, radioPd;
    private Spinner spUkuran, spWarna;
    private EditText etKeterangan, etJumlah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_celana);

        getSupportActionBar().setTitle("Celana");

        radioPj = (RadioButton)findViewById(R.id.radioPj);
        radioPd = (RadioButton)findViewById(R.id.radioPd);

        spUkuran = (Spinner)findViewById(R.id.spUkuran);
        spWarna = (Spinner)findViewById(R.id.spWarna);

        etKeterangan = (EditText)findViewById(R.id.etKeterangan);
        etJumlah = (EditText)findViewById(R.id.etJumlah);

        String [] ukuran = {"26","27","28","29","30","31","32","33","34","35"};
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, ukuran);
        spUkuran.setAdapter(adapter);

        String [] warna = {"Biru","Hitam","Putih","Abu-abu"};
        ArrayAdapter adapt = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, warna);
        spWarna.setAdapter(adapt);
    }
}
