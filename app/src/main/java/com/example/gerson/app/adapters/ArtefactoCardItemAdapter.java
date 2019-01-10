package com.example.gerson.app.adapters;

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

import org.w3c.dom.Text;

import java.util.List;

public class ArtefactoCardItemAdapter extends RecyclerView.Adapter<ArtefactoCardItemAdapter.ArtefactoCardItem> {

    private Context mContext;
    private List<Artefacto> mData;

    public ArtefactoCardItemAdapter(Context mContext, List<Artefacto> mData){
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public ArtefactoCardItem onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.mycard_item, viewGroup, false);
        return new ArtefactoCardItem(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ArtefactoCardItem artefactoCardItem, int i) {
        artefactoCardItem.artefacto_titulo.setText(mData.get(i).getNombre());
        artefactoCardItem.artefacto_precio.setText(mData.get(i).getPrecio().toString());
        artefactoCardItem.artefacto_img.setImageResource(mData.get(i).getId_img());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class ArtefactoCardItem extends RecyclerView.ViewHolder{

        TextView artefacto_titulo;
        TextView artefacto_precio;
        ImageView artefacto_img;

        public ArtefactoCardItem(View view){
            super(view);

            artefacto_img = (ImageView)itemView.findViewById(R.id.artefacto_img_id);
            artefacto_titulo = (TextView)itemView.findViewById(R.id.artefacto_text_titulo_id);
            artefacto_precio = (TextView)itemView.findViewById(R.id.artefacto_text_precio_id);

        }
    }
}
