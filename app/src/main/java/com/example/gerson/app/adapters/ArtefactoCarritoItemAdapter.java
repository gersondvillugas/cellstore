package com.example.gerson.app.adapters;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gerson.app.R;
import com.example.gerson.app.models.Artefacto;

import java.util.List;

public class ArtefactoCarritoItemAdapter extends  RecyclerView.Adapter<ArtefactoCarritoItemAdapter.ArtefactoCarritoItem>{

    private Context mContext;
    private List<Artefacto> mData;
    public ArtefactoCarritoItemAdapter(Context mContext, List<Artefacto> mData){
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public ArtefactoCarritoItem onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.artefacto_carrito_item, viewGroup, false);
        return new ArtefactoCarritoItem(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ArtefactoCarritoItem artefactoCarritoItem, int i) {
        artefactoCarritoItem.artefacto_titulo.setText(mData.get(i).getNombre());
        artefactoCarritoItem.artefacto_precio.setText("S/ "+mData.get(i).getPrecio().toString());
        artefactoCarritoItem.artefacto_img.setImageResource(mData.get(i).getId_img());
        artefactoCarritoItem.setData(mData, i);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class ArtefactoCarritoItem extends RecyclerView.ViewHolder{

        TextView artefacto_titulo;
        TextView artefacto_precio;
        ImageView artefacto_img;
        ImageView artefacto_lupa_img;
        private int key;
        private List<Artefacto> mData;

        public void setData(final List<Artefacto> mData, int  i) {
            this.mData = mData;
            this.key = i;
        }

        public ArtefactoCarritoItem(View view){
            super(view);
            artefacto_img = (ImageView)itemView.findViewById(R.id.artefacto_img_id);
            artefacto_titulo = (TextView)itemView.findViewById(R.id.artefacto_text_titulo_id);
            artefacto_precio = (TextView)itemView.findViewById(R.id.artefacto_text_precio_id);
            artefacto_lupa_img = (ImageView)itemView.findViewById(R.id.artefacto_lupa_icon_id);
        }
    }
}