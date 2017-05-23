package com.risqi17.drawer;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.TextView;

import com.etsy.android.grid.StaggeredGridView;
import com.risqi17.drawer.adapter.ItemGridAdapter;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    //Navigation Bottom
    private TextView mTextMessage;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    //put the action here
                case R.id.navigation_explore:
                    //put the action here
                case R.id.navigation_find:
                    //put the action here
                case R.id.navigation_msg:
                    /*mTextMessage.setText(R.string.title_msg);
                    return true;*/
            }
            return false;
        }

    };
    //Batas Navigation Bottom

    //stageredGridVIew
    private StaggeredGridView staggeredGridView;
    private String[] items = new String[]{
            "https://1.bp.blogspot.com/-rVeofFMBPn8/VPaTq51UxiI/AAAAAAAAGog/ODhu_80iMes/s400/Contoh%2BDesain%2BKemeja%2BMuslim%2BWanita%2BModern.png",
            "http://1.bp.blogspot.com/-FyD9aoAc3z4/VoiPD1dI-zI/AAAAAAAAnE8/SEw2p79ax88/s1600/Contoh%2BBusana%2BMuslim%2BWanita%2BFormal%2BElegan%2B2016.png",
            "http://caraberhijab.net/wp-content/uploads/2016/04/Model-Kemeja-Wanita-Modern.jpg",
            "http://stylecantik.com/wp-content/uploads/2016/04/Model-Baju-Kemeja-Pria-Lengan-Panjang.jpg",
            "http://caraberhijab.net/wp-content/uploads/2016/04/Model-Kemeja-Kerja-Wanita-Terbaru.jpg",
            "http://klikplaza.com/wp-content/uploads/2013/07/atypical-man-4770-39398-1-zoom.jpg",
            "http://caraberhijab.net/wp-content/uploads/2016/04/Model-Kemeja-Polos-Terbaru.jpg",
            "http://2.bp.blogspot.com/-AnjYAvm2ll4/VZkPkeP8O9I/AAAAAAAACkU/3BR75bf4ZrA/s1600/gambar-baju-kemeja-remaja-wanita-trend%252B10.jpg",
            "http://caraberhijab.net/wp-content/uploads/2016/04/Kemeja-Wanita-Bahan-Denim.jpg",
            "http://infokebaya.com/wp-content/uploads/2017/01/model-baju-kemeja-lengan-panjang-2017.png",
            "https://2.bp.blogspot.com/-4Oap3-BMDsQ/V1Poj3ozAxI/AAAAAAAAC0E/l9D_PQ4V5YgZqkznGlbZz5qRNIx83egtACLcB/s1600/Model%2BKemeja%2BPria%2BTerbaru.jpg",
            "http://caraberhijab.net/wp-content/uploads/2016/04/Model-Kemeja-Yang-Sedang-Trend.jpg",
            "http://infokebaya.com/wp-content/uploads/2017/01/model-kemeja-wanita-terbaru-lengan-panjang-2017.png",
            "https://3.bp.blogspot.com/-bw9DY239_yk/V1Po1p2a3ZI/AAAAAAAAC0c/abrGkDZcbekArV69UJOOZS-5Vk2uv4iWACLcB/s1600/Contoh%2BKemeja%2BPria%2BWarna%2BAbu.jpg",
            "http://infokebaya.com/wp-content/uploads/2017/01/baju-kemeja-pria-lengan-panjang-2017-1.png",
            "http://styleremaja.com/wp-content/uploads/2016/11/Kemeja-Putih-Pria-Branded-2017.jpg",
            "http://busanamuslimodis.com/wp-content/uploads/2015/09/Model-baju-Koko-Lengan-Panjang.png",
            "https://dynamic.zacdn.com/mWYXv0bWrf46ZQzBGclV1hC4n70=/fit-in/236x345/filters:quality(90):fill(ffffff)/http://static.id.zalora.net/p/carvil-3106-4402711-1.jpg",
            "http://bajukokoputih.co.id/wp-content/uploads/2016/11/baju-koko-putih-miqdad.jpg",
            "http://stylebajumuslim.com/wp-content/uploads/2016/11/Kemeja-Wanita-Lengan-Panjang-Terbaru-2017.jpg",
            "http://bajumodelbaru.biz/wp-content/uploads/2016/10/Model-Celana-Kulot-Panjang.jpg",
            "https://wp.hijup.com/wp-content/uploads/2017/01/celana-kulot-terbaru-5-683x1024.jpg",
            "http://fashionsmodern.com/wp-content/uploads/2016/10/Model-Celana-Kulot-Batik.jpg",
            "https://ecs7.tokopedia.net/img/product-1/2016/2/9/886576/886576_e541bfc9-f4f6-4b82-aff4-6568e5b3f52e.jpg",
            "https://s0.bukalapak.com/img/021054941/large/CelanaKatunFormal_1_scaled.jpg",
            "https://ecs7.tokopedia.net/img/cache/200-square/product-1/2015/12/17/1112937/1112937_9d8356a1-5071-4854-8b20-4481a3e30335.jpg",
            "https://s2.bukalapak.com/img/785668183/large/celana_aladin_murah_celama_wanita_modern_.jpg"

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Home");

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //stageredView
        staggeredGridView = (StaggeredGridView)findViewById(R.id.gv_staggered);
        ItemGridAdapter itemGridAdapter = new ItemGridAdapter(MainActivity.this, items);
        staggeredGridView.setAdapter(itemGridAdapter);
        staggeredGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                DetailImageActivity.toDetailImageActivity(MainActivity.this, items[position]);
            }
        });


        //navigation Bottom
        //mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    //Logout function
    private void logout(){
        //Creating an alert dialog to confirm logout
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage("Are you sure you want to logout?");
        alertDialogBuilder.setPositiveButton("Yes",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {

                        //Getting out sharedpreferences
                        SharedPreferences preferences = getSharedPreferences(Config.SHARED_PREF_NAME, Context.MODE_PRIVATE);
                        //Getting editor
                        SharedPreferences.Editor editor = preferences.edit();

                        //Puting the value false for loggedin
                        editor.putBoolean(Config.LOGGEDIN_SHARED_PREF, false);

                        //Putting blank value to email
                        editor.putString(Config.ID_SHARED_PREF, "");

                        //Saving the sharedpreferences
                        editor.commit();

                        //Starting login activity
                        Intent intent = new Intent(MainActivity.this, Login.class);
                        startActivity(intent);
                        finish();
                    }
                });

        alertDialogBuilder.setNegativeButton("No",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {

                    }
                });

        //Showing the alert dialog
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();

    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.menuLogout) {
            logout();
        }
        if (id == R.id.pesan) {
            Intent i = new Intent(getApplicationContext(), Pesan.class);
            startActivity(i);
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_akun) {
            Intent i = new Intent(getApplicationContext(), Akun.class);
            startActivity(i);

        } else if (id == R.id.nav_pemesanan) {
            Intent i = new Intent(getApplicationContext(), Pemesanan.class);
            startActivity(i);

        } else if (id == R.id.nav_komplain) {
            Intent i = new Intent(getApplicationContext(), Saran.class);
            startActivity(i);

        }  else if (id == R.id.nav_logout) {
            logout();

        } else if (id == R.id.nav_keluar) {
            finish();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
