package com.example.gerson.app.adapters;

import android.animation.ArgbEvaluator;
import android.app.Dialog;
import android.content.Context;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gerson.app.R;
import com.example.gerson.app.models.Artefacto;

import org.w3c.dom.Text;

import java.util.List;

public class ArtefactoCardItemAdapter extends RecyclerView.Adapter<ArtefactoCardItemAdapter.ArtefactoCardItem> {

    private Context mContext;
    private List<Artefacto> mData;
    private Dialog dialog;
    public ArtefactoCardItemAdapter(Context mContext, List<Artefacto> mData, Dialog dialog){
        this.mContext = mContext;
        this.mData = mData;
        this.dialog = dialog;
    }

    @NonNull
    @Override
    public ArtefactoCardItem onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.mycard_item, viewGroup, false);
        return new ArtefactoCardItem(view, mContext, dialog);
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
        ImageView artefacto_lupa_img;

        private Context mContext;
        private Dialog dialog;
        public ArtefactoCardItem(View view, Context context, final Dialog dialog){
            super(view);
            this.dialog = dialog;
            this.mContext = context;

            artefacto_img = (ImageView)itemView.findViewById(R.id.artefacto_img_id);
            artefacto_titulo = (TextView)itemView.findViewById(R.id.artefacto_text_titulo_id);
            artefacto_precio = (TextView)itemView.findViewById(R.id.artefacto_text_precio_id);
            artefacto_lupa_img = (ImageView)itemView.findViewById(R.id.artefacto_lupa_icon_id);

            artefacto_lupa_img.setOnClickListener(new View.OnClickListener(){
                public void onClick(View view){

                    dialog.show();

                }
            });

        }
    }
}
