package com.example.gerson.app.adapters;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gerson.app.R;
import com.example.gerson.app.models.Celular;
import com.squareup.picasso.Picasso;

import java.util.List;
public abstract class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private List<Celular> celulars;
    private  int layout;
    private Context context;
    private  OnItemClickListener itemClickListener;
    public MyAdapter(List<Celular>celulars,int layout,OnItemClickListener listener){
        this.celulars=celulars;
        this.layout=layout;
        this.itemClickListener=listener;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder( ViewGroup parent, int i) {
        View v= LayoutInflater.from(parent.getContext()).inflate(layout,parent,false);
        context =parent.getContext();
        ViewHolder vh=new ViewHolder(v);
        return vh;


    }

    @Override
    public void onBindViewHolder( ViewHolder holder, int position) {
        holder.bind(celulars.get(position),itemClickListener);
    }

    @Override
    public int getItemCount() {
        return celulars.size();
    }

    public abstract void onEntrada(Object entrada, View view);

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textviewname;
        public TextView textViewPrecio;
        public ImageView ImageviewPoster;

        public ViewHolder(View v){
            super(v);
            textviewname=(TextView)itemView.findViewById(R.id.textViewTitle);
            textViewPrecio=(TextView)itemView.findViewById(R.id.textViewPrecio);

            ImageviewPoster=(ImageView)itemView.findViewById(R.id.imageViewPoster);
        }
        public void bind(final Celular celulars, final OnItemClickListener listener){
//procesamos los datos renderizar
            textviewname.setText(celulars.getName());
            textViewPrecio.setText(celulars.getPrecio());
            Picasso.with(context).load(celulars.getPoster()).fit().into(ImageviewPoster);
            // ImageviewPoster.setImageResource(movie.getPoster());
            //definimos que por cada elemento de nuestro recycler view tenemos un click listener que se
            //comporta de la siguiente manera
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(celulars,getAdapterPosition());
                }
            });
        }

    }
    public interface  OnItemClickListener{
        void onItemClick(Celular celulars,int posicion);

    }
    public Object getItem(int posicion) {
        return celulars.get(posicion);
    }


}
