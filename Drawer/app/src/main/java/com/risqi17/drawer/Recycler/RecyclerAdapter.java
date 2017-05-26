package com.risqi17.drawer.Recycler;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.risqi17.drawer.PilihPesanan;
import com.risqi17.drawer.R;

/**
 * Created by Risqi17 on 21/05/2017.
 */

public class RecyclerAdapter extends  RecyclerView.Adapter<RecyclerViewHolder> {

    //deklarasi variable context

    private final Context context;

    String [] name={"Penjahit A","Penjahit B","Penjahit C","Penjahit D",
            "Penjahit E","Penjahit F","Penjahit G","Penjahit H"};
    String [] alamat={"Jl. Mastrip 05 Jember","Jl. Kalimantan 02 Jember","Jl. Gajah Mada Jember","Jl. Hayam Wuruk 11 Jember",
            "Jl. Sudirman 20 Jember","Jl. Danau Toba 12 Jember","Jl. Riau 05 Jember","Jl. Karimata 09 Jember"};

    // menampilkan list item dalam bentuk text dengan tipe data string dengan variable name

    LayoutInflater inflater;
    public RecyclerAdapter(Context context) {
        this.context=context;
        inflater=LayoutInflater.from(context);
    }
    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v=inflater.inflate(R.layout.item_list_penjahit, parent, false);

        RecyclerViewHolder viewHolder = new RecyclerViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {

        holder.tv1.setText(name[position]);
        holder.tv1.setOnClickListener(clickListener);
        holder.tv2.setText(alamat[position]);
        holder.tv2.setOnClickListener(clickListener);
        holder.imageView.setOnClickListener(clickListener);
        holder.tv1.setTag(holder);
        holder.tv2.setTag(holder);
        holder.imageView.setTag(holder);

    }

    View.OnClickListener clickListener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
//member aksi saat cardview diklik berdasarkan posisi tertentu
            RecyclerViewHolder vholder = (RecyclerViewHolder) v.getTag();

            int position = vholder.getPosition();
            //Intent i = new Intent(getApplicationContext(), PilihPesanan.class);

            //Toast.makeText(context, "Menu ini berada di posisi " + position, Toast.LENGTH_LONG).show();
            Intent i  = new Intent(context, PilihPesanan.class);
            context.startActivity(i);


        }
    };



    @Override
    public int getItemCount() {
        return name.length;
    }
}
