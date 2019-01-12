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
        return new ArtefactoCardItem(view, dialog);
    }

    @Override
    public void onBindViewHolder(@NonNull ArtefactoCardItem artefactoCardItem, int i) {
        artefactoCardItem.artefactoTituloView.setText(mData.get(i).getNombre());
        artefactoCardItem.artefactoPrecioView.setText("S/ "+mData.get(i).getPrecio().toString());
        artefactoCardItem.artefactoImageView.setImageResource(mData.get(i).getId_img());
        artefactoCardItem.setData(mData, i);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class ArtefactoCardItem extends RecyclerView.ViewHolder{

        TextView artefactoTituloView;
        TextView artefactoPrecioView;
        ImageView artefactoImageView;
        ImageView lupaView;
        ImageView ventaDardoView;

        private Dialog dialog;
        private int key;
        private List<Artefacto> mData;
        private boolean agregadoAlCarro;

        public void setData(final List<Artefacto> mData, int  i) {
            this.mData = mData;
            this.key = i;
            lupaView.setOnClickListener(new View.OnClickListener(){
                public void onClick(View view){

                    TextView nombre = (TextView)dialog.findViewById(R.id.artefacto_nombre);
                    TextView procesador = (TextView)dialog.findViewById(R.id.artefacto_procesador);
                    TextView gpu = (TextView)dialog.findViewById(R.id.artefacto_gpu);
                    TextView camara = (TextView)dialog.findViewById(R.id.artefacto_camara);
                    TextView pantalla = (TextView)dialog.findViewById(R.id.artefacto_pantalla);
                    TextView ram = (TextView)dialog.findViewById(R.id.artefacto_ram);
                    TextView capacidad = (TextView)dialog.findViewById(R.id.artefacto_capacidad);
                    TextView bateria = (TextView)dialog.findViewById(R.id.artefacto_bateria);
                    TextView precio = (TextView)dialog.findViewById(R.id.artefacto_precio);
                    ImageView img = (ImageView)dialog.findViewById(R.id.artefacto_img);

                    TextView cantidad = (TextView)dialog.findViewById(R.id.artefacto_cantidad);

                    Artefacto artefacto = mData.get(key);

                    nombre.setText(artefacto.getNombre());
                    procesador.setText( "Procesador: " + artefacto.getProcesador());
                    gpu.setText(        "GPU: " + artefacto.getGpu());
                    camara.setText(     "Camara: " + artefacto.getCamara().toString());
                    pantalla.setText(   "Pantalla: " + artefacto.getPantalla());
                    ram.setText(        "RAM: " + artefacto.getRam());
                    capacidad.setText(  "Capacidad : " + artefacto.getCapacidad());
                    bateria.setText(    "Bateria: " + artefacto.getBateria());
                    precio.setText(     String.format("S/ %.2f",artefacto.getPrecio()));
                    img.setImageResource( artefacto.getId_img());
                    cantidad.setText("2");
                    dialog.show();

                }
            });
            ventaDardoView.setOnClickListener(new View.OnClickListener(){
                public void onClick(View view){
                    /*
                    * Agregar codigo de agregar producto a carrito
                    * ... carrito sera un arraylista vacio el cual se ira llenando a medida q la persona solicita mas productos
                    * */
                    agregadoAlCarro = !agregadoAlCarro;
                    if(!agregadoAlCarro){
                        ventaDardoView.setImageResource(R.drawable.dardo_pinchado);
                    }else {
                        ventaDardoView.setImageResource(R.drawable.dardo);
                    }
                }
            });
        }

        public ArtefactoCardItem(View view, final Dialog dialog){
            super(view);
            this.dialog = dialog;
            this.mData = mData;

            artefactoImageView = (ImageView)itemView.findViewById(R.id.artefacto_img_id);
            artefactoTituloView = (TextView)itemView.findViewById(R.id.artefacto_text_titulo_id);
            artefactoPrecioView = (TextView)itemView.findViewById(R.id.artefacto_text_precio_id);
            lupaView = (ImageView)itemView.findViewById(R.id.artefacto_lupa_icon_id);
            ventaDardoView = (ImageView) itemView.findViewById(R.id.artefacto_img_dardo);
            agregadoAlCarro = false;
        }
    }
}
