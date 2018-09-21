package com.example.courbis_diaz.valeapp.Adaptador;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.courbis_diaz.valeapp.Entidad.ListaVale;
import com.example.courbis_diaz.valeapp.R;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Locale;

public class AdaptadorListaVale extends BaseAdapter {

    protected Activity activity;
    protected ArrayList <ListaVale> items;

    public AdaptadorListaVale(Activity activity, ArrayList<ListaVale> items) {
        this.activity = activity;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    public void clear(){
        items.clear();
    }

    public void addAll(ArrayList<ListaVale> listaVale){
        for (int i=0; i<listaVale.size();i++){
            items.add(listaVale.get(i));
        }
    }

    @Override
    public Object getItem(int i) {
        return items.get(i);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v=convertView;
        if (convertView==null){
            LayoutInflater inf=(LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v=inf.inflate(R.layout.layout_lista_vale,null);
        }

        ListaVale dir=items.get(position);

        TextView textViewCantidad=(TextView)v.findViewById(R.id.textViewCantidad);
        textViewCantidad.setText(Integer.toString(dir.getCantidad()));
        TextView textViewDescripcion=(TextView)v.findViewById(R.id.textViewDescripcion);
        textViewDescripcion.setText(dir.getDescripcion());
        TextView textViewBodega=(TextView)v.findViewById(R.id.textViewBodega);
        textViewBodega.setText(dir.getBodega());

        return v;
    }

    @Nullable
    @Override
    public CharSequence[] getAutofillOptions() {
        return new CharSequence[0];
    }
}
