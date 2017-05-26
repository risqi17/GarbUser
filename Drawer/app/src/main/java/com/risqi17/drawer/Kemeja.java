package com.risqi17.drawer;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.risqi17.drawer.SignUp.SignUpUser;

import java.util.HashMap;
import java.util.Map;

public class Kemeja extends AppCompatActivity implements View.OnClickListener {
    private RadioButton radioPj, radioPd;
    private Spinner spUkuran, spWarna;
    private EditText etKeterangan, etJumlah;
    private Button simpan;

    public static final String KEY_USER = "user";
    public static final String KEY_UKURAN = "ukuran";
    public static final String KEY_WARNA = "warna";
    public static final String KEY_MODEL = "model";
    public static final String KEY_JENIS = "jenis";
    public static final String KEY_KETERANGAN = "keterangan";
    public static final String KEY_JUMLAH = "jumlah";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kemeja);

        getSupportActionBar().setTitle("Kemeja");

        radioPj = (RadioButton)findViewById(R.id.radioPj);
        radioPd = (RadioButton)findViewById(R.id.radioPd);

        spUkuran = (Spinner)findViewById(R.id.spUkuran);
        spWarna = (Spinner)findViewById(R.id.spWarna);

        etKeterangan = (EditText)findViewById(R.id.etKeterangan);
        etJumlah = (EditText)findViewById(R.id.etJumlah);

        String [] ukuran = {"S","M","L","XL"};
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, ukuran);
        spUkuran.setAdapter(adapter);

        String [] warna = {"Biru","Hitam","Putih","Abu-abu"};
        ArrayAdapter adapt = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, warna);
        spWarna.setAdapter(adapt);

        simpan = (Button)findViewById(R.id.Simpan);
        simpan.setOnClickListener(this);
    }

    private void Pesan(){
        String jenis = "";
        if(radioPd.isChecked()){
            jenis = "Pendek";
        } else if(radioPj.isChecked()){
            jenis = "Panjang";
        }
        SharedPreferences sharedPreferences = getSharedPreferences(Config.SHARED_PREF_NAME, Context.MODE_PRIVATE);
        String ids = sharedPreferences.getString(Config.ID_SHARED_PREF, "Not Available");

        final String user = ids;
        final String model = "Kemeja";
        final String ukuran = spUkuran.getSelectedItem().toString().trim();
        final String warna = spWarna.getSelectedItem().toString().trim();
        final String jenisKemeja = jenis;
        final String keterangan = etKeterangan.getText().toString().trim();
        final String jumlah = etJumlah.getText().toString().trim();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, Config.PESAN_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(Kemeja.this,response,Toast.LENGTH_LONG).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(Kemeja.this,error.toString(),Toast.LENGTH_LONG).show();
                    }
                }){
            @Override
            protected Map<String,String> getParams(){
                Map<String,String> params = new HashMap<String, String>();
                params.put(KEY_USER,user);
                params.put(KEY_MODEL,model);
                params.put(KEY_UKURAN,ukuran);
                params.put(KEY_WARNA,warna);
                params.put(KEY_JENIS,jenisKemeja);
                params.put(KEY_KETERANGAN,keterangan);
                params.put(KEY_JUMLAH,jumlah);


                return params;
            }

        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
        Intent i = new Intent(getApplicationContext(), Pemesanan.class);
        startActivity(i);
        finish();
    }

    @Override
    public void onClick(View v){
         Pesan();
    }
}
