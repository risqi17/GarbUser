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
            "http://pre00.deviantart.net/dfe2/th/pre/f/2016/187/9/5/screen_shot_2016_07_05_at_1_54_36_pm_by_chasingartwork-da8zklg.png",
            "http://orig06.deviantart.net/c9c2/f/2017/055/5/6/screen_shot_2017_02_24_at_1_34_16_pm_by_chasingartwork-db08403.png",
            "http://pre07.deviantart.net/cb2b/th/pre/f/2016/273/a/7/screen_shot_2016_09_29_at_12_09_11_pm_by_chasingartwork-dajdzni.png",
            "http://pre02.deviantart.net/f794/th/pre/f/2015/113/b/4/screen_shot_2015_04_23_at_3_34_14_am_by_chasingartwork-d8qqh44.png",
            "http://pre04.deviantart.net/4cdc/th/pre/i/2013/357/c/4/auto_avenger__hawkeye_by_chasingartwork-d6z1kig.jpg",
            "http://pre14.deviantart.net/7380/th/pre/i/2013/161/1/5/auto_avenger__venom_by_chasingartwork-d68ipvr.jpg",
            "http://pre04.deviantart.net/a1f9/th/pre/f/2012/358/8/3/8382505e18ee5bed1603570501971bd3-d5p0gc6.jpg",
            "http://orig11.deviantart.net/a985/f/2013/057/7/5/auto_avengers__iron_man_by_chasingartwork-d5wd4vk.jpg",
            "http://pre07.deviantart.net/7c04/th/pre/i/2013/165/f/9/dark_spidy_by_chasingartwork-d68zd68.jpg",
            "http://pre03.deviantart.net/fe16/th/pre/i/2013/169/8/5/auto_avenger__doom_by_chasingartwork-d69dfam.jpg"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

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
