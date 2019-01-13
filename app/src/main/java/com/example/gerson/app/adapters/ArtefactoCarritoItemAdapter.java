package com.example.gerson.app.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.gerson.app.R;
import com.example.gerson.app.models.Carrito;
import com.example.gerson.app.models.artefacto.Artefacto;

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
    public void onBindViewHolder(@NonNull final ArtefactoCarritoItem artefactoCarritoItem, int i) {
        artefactoCarritoItem.artefactoTituloView.setText(mData.get(i).getNombre());
        artefactoCarritoItem.artefactoPrecioView.setText("S/ "+mData.get(i).getPrecio().toString());
        Glide.with(mContext).load(mData.get(i).getUrlImg()).into(artefactoCarritoItem.artefactoImgView);
        artefactoCarritoItem.setData(mData, i);
        artefactoCarritoItem.deleteView.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                int key = artefactoCarritoItem.key;
                Carrito carrito = Carrito.getInstance();
                carrito.removeArtefacto(mData.get(key));
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class ArtefactoCarritoItem extends RecyclerView.ViewHolder{

        ImageView artefactoImgView;
        TextView artefactoTituloView;
        TextView artefactoPrecioView;

        TextView ventaCantidadView;
        ImageView deleteView;

        private int key;
        private List<Artefacto> mData;



        public void setData(final List<Artefacto> mData, int  i) {
            this.mData = mData;
            this.key = i;

        }

        public ArtefactoCarritoItem(View view){
            super(view);
            artefactoImgView = (ImageView)itemView.findViewById(R.id.artefacto_img_id);
            artefactoTituloView = (TextView)itemView.findViewById(R.id.artefacto_text_titulo_id);
            artefactoPrecioView = (TextView)itemView.findViewById(R.id.artefacto_text_precio_id);
            ventaCantidadView = (TextView)itemView.findViewById(R.id.artefacto_cantidad);
            deleteView = (ImageView)itemView.findViewById(R.id.delete_id);

        }
    }
}