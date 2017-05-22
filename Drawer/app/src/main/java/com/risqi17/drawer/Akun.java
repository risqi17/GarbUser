package com.risqi17.drawer;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

public class Akun extends AppCompatActivity {


    private TextView id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_akun);

        getSupportActionBar().setTitle("Profil");

        SharedPreferences sharedPreferences = getSharedPreferences(Config.SHARED_PREF_NAME, Context.MODE_PRIVATE);
        String ids = sharedPreferences.getString(Config.ID_SHARED_PREF, "Not Available");

        id = (TextView)findViewById(R.id.id);
        id.setText(ids);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.home) {
        }
        return super.onOptionsItemSelected(item);
    }
}
