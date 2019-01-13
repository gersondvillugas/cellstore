package com.example.gerson.app.activities.Search;

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
import com.example.gerson.app.activities.ContainerArtefactos;
import com.example.gerson.app.models.Carrito;
import com.example.gerson.app.models.artefacto.Artefacto;


import java.util.List;


public class SearchItemAdapter extends RecyclerView.Adapter<SearchItemAdapter.ViewHolder>{

    Context context;
    List<Artefacto> artefactos;
    public SearchItemAdapter(Context context, List<Artefacto> artefactos) {
        this.context = context;
        this.artefactos = artefactos;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.activity_search_item, viewGroup, false);
        return  new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        ContainerArtefactos search = (ContainerArtefactos) context;
        viewHolder.setArtefacto(artefactos.get(i));
        search.addViewHolders(viewHolder);

        viewHolder.getItemTituloView().setText(artefactos.get(i).getNombre());
        viewHolder.getItemPrecioView().setText("S/ "+artefactos.get(i).getPrecio().toString());
        Glide.with(context).load(artefactos.get(i).getUrlImg()).into(viewHolder.getItemImageView());

        viewHolder.setListener(artefactos.get(i),(OnClickSearchItemListener)context);
    }

    @Override
    public int getItemCount() {
        return artefactos.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView itemImageView;
        private TextView itemPrecioView;
        private TextView itemTituloView;
        private ImageView itemLupaView;
        private ImageView itemDardoView;

        private Boolean agregadoAlCarro;
        private Artefacto artefacto;



        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemImageView = (ImageView)itemView.findViewById(R.id.item_img_id);
            itemPrecioView = (TextView) itemView.findViewById(R.id.item_precio_id);
            itemTituloView = (TextView) itemView.findViewById(R.id.item_titulo_id);
            itemLupaView = (ImageView) itemView.findViewById(R.id.item_lupa_icon_id);
            itemDardoView = (ImageView) itemView.findViewById(R.id.item_img_dardo);

            agregadoAlCarro = false;
        }

        public void setListener(Artefacto artefacto, OnClickSearchItemListener listener){
            itemLupaView.setOnClickListener(new View.OnClickListener(){
                public void onClick(View view){
                    listener.onClickItemLupa(artefacto);
                }
            });
            itemDardoView.setOnClickListener(new View.OnClickListener(){
                public void onClick(View view){

                    agregadoAlCarro = !agregadoAlCarro;
                    updateDardoImage(artefacto);
                    listener.onClickItemDardo(artefacto);
                }
            });
        }

        public void updateDardoImage(){
            if(agregadoAlCarro){
                itemDardoView.setImageResource(R.drawable.dardo_pinchado);
            }else {
                itemDardoView.setImageResource(R.drawable.dardo);
            }
        }
        public void updateDardoImage(Artefacto artefacto){
            Carrito carrito = Carrito.getInstance();
            if(agregadoAlCarro){
                carrito.addArtefacto(artefacto);
                itemDardoView.setImageResource(R.drawable.dardo_pinchado);
            }else {
                carrito.removeArtefacto(artefacto);
                itemDardoView.setImageResource(R.drawable.dardo);
            }

        }

        public Artefacto getArtefacto() {
            return artefacto;
        }

        public void setArtefacto(Artefacto artefacto) {
            this.artefacto = artefacto;
        }

        public Boolean getAgregadoAlCarro() {
            return agregadoAlCarro;
        }

        public void setAgregadoAlCarro(Boolean agregadoAlCarro) {
            this.agregadoAlCarro = agregadoAlCarro;
        }

        public ImageView getItemImageView() {
            return itemImageView;
        }

        public TextView getItemPrecioView() {
            return itemPrecioView;
        }

        public TextView getItemTituloView() {
            return itemTituloView;
        }
    }
}
