package com.risqi17.drawer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.risqi17.drawer.JSON.CustomListPenjahit;
import com.risqi17.drawer.JSON.ParseJSONPesanan;

public class Pemesanan extends AppCompatActivity {
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pemesanan);

        getSupportActionBar().setTitle("Pemesanan");

        listView = (ListView)findViewById(R.id.list_view);
        //get data from json
        StringRequest stringRequest = new StringRequest(Config.JSON_GET_PESANAN,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        showJSON(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(Pemesanan.this,error.getMessage(),Toast.LENGTH_LONG).show();
                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    private void showJSON(String json){
        ParseJSONPesanan pj = new ParseJSONPesanan(json);
        pj.parseJSON();
        CustomListPenjahit cl = new CustomListPenjahit(this, ParseJSONPesanan.ids, ParseJSONPesanan.models, ParseJSONPesanan.ukurans);
        listView.setAdapter(cl);
    }
}
