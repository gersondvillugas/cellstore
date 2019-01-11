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

public class TabletCardItemAdapter  extends RecyclerView.Adapter<TabletCardItemAdapter.TabletCardItem> {

    private Context mContext;
    private List<Artefacto> mData;
    private Dialog dialog;
    public TabletCardItemAdapter(Context mContext, List<Artefacto> mData, Dialog dialog){
        this.mContext = mContext;
        this.mData = mData;
        this.dialog = dialog;
    }

    @NonNull
    @Override
    public TabletCardItemAdapter.TabletCardItem onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.mytablet_item, viewGroup, false);
        return new TabletCardItemAdapter.TabletCardItem(view, dialog);
    }

    @Override
    public void onBindViewHolder(@NonNull TabletCardItem tabletCardItem, int i) {
        tabletCardItem.artefacto_titulo.setText(mData.get(i).getNombre());
        tabletCardItem.artefacto_precio.setText("S/ "+mData.get(i).getPrecio().toString());
        tabletCardItem.artefacto_img.setImageResource(mData.get(i).getId_img());
        tabletCardItem.setData(mData, i);
    }




    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class TabletCardItem extends RecyclerView.ViewHolder{

        TextView artefacto_titulo;
        TextView artefacto_precio;
        ImageView artefacto_img;
        ImageView tablet_lupa_img;

        private Dialog dialog;
        private int key;
        private List<Artefacto> mData;

        public void setData(final List<Artefacto> mData, int  i) {
            this.mData = mData;
            this.key = i;
            tablet_lupa_img.setOnClickListener(new View.OnClickListener(){
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
        }

        public TabletCardItem(View view, final Dialog dialog){
            super(view);
            this.dialog = dialog;
            this.mData = mData;

            artefacto_img = (ImageView)itemView.findViewById(R.id.tablet_img_id);
            artefacto_titulo = (TextView)itemView.findViewById(R.id.table_text_titulo_id);
            artefacto_precio = (TextView)itemView.findViewById(R.id.table_text_precio_id);
            tablet_lupa_img = (ImageView)itemView.findViewById(R.id.table_lupa_icon_id);
            // artefacto_img = (ImageView)itemView.findViewById(R.id.artefacto_img_id);
          //  artefacto_titulo = (TextView)itemView.findViewById(R.id.artefacto_text_titulo_id);
        //    artefacto_precio = (TextView)itemView.findViewById(R.id.artefacto_text_precio_id);
          //  artefacto_lupa_img = (ImageView)itemView.findViewById(R.id.artefacto_lupa_icon_id);


        }
    }
}
