package com.example.courbis_diaz.valeapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.courbis_diaz.valeapp.Adaptador.AdaptadorListaVale;
import com.example.courbis_diaz.valeapp.DB.DataBase;
import com.example.courbis_diaz.valeapp.Entidad.ListaVale;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

private AutoCompleteTextView material;
//private static final int REQ_CODE_SPEECH_INPUT=100;
//private ImageButton entradaVoz;
private Spinner spinnerElemento;
private ListView lista;
private EditText textElemento;
private ArrayList<ListaVale> item=new ArrayList<ListaVale>();;
private EditText cantidad;
private AdaptadorListaVale adapter;
private ImageButton crearVale;

/*Listado temporal de materiales*/
private static final String[] materiales=new String[]{
  "Madera estructural","Madera impregnada","Madera seca" ,"Madera verda", "Tapacan", "Tabla de cielo", "Tabla machihembrada", "Tabla tinglada",
        "guardapolvo", "pilastra", "cornisa", "Rodon", "Junquillo"
};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lista=(ListView) findViewById(R.id.listvale);
        //textElemento=(EditText) findViewById(R.id.editTextElemento);
        spinnerElemento=(Spinner) findViewById(R.id.spinnerElemento);
        cantidad=(EditText) findViewById(R.id.editTextRut);
        //entradaVoz=(ImageButton) findViewById(R.id.imageButtonEntradaVoz);
        crearVale=(ImageButton) findViewById(R.id.crearVale);

        DataBase dataBase= new DataBase(this);
        SQLiteDatabase db=dataBase.getWritableDatabase();



        crearVale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(view.getContext(),QR.class);
                startActivityForResult(intent,0);
            }
        });

        /*AutoComplete*/
        ArrayAdapter<String> adapadorAutoComplete=new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line,materiales);
        material=(AutoCompleteTextView)findViewById(R.id.autoCompleteTextViewMaterial);
        material.setAdapter(adapadorAutoComplete);
        /*Fin AutoComplete*/
        /*Fin AutoComplete*/


      /*  entradaVoz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EntradaDeVoz();
            }
        });*/

       spinnerElemento.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                llenarTextElemento();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });



       lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> adapterView/*contenedor*/, View view/*vistas*/, final int position/*posicion*/, long l/*id*/) {
            eliminarItem(position);
           }
       });
       }


        public void agregarItem(View v){
        Log.d("pruebaBoton","material= "+material.getText()+"y cantidad= "+cantidad.getText());
        if(material.getText().length()>0&&cantidad.getText().length()>0){
        ListaVale listaVale=new ListaVale(Integer.parseInt(cantidad.getText().toString()),material.getText().toString(),"");

        item.add(listaVale);
        adapter=new AdaptadorListaVale(MainActivity.this,item);
        lista.setAdapter(adapter);
        material.setText("");
        cantidad.setText("");
            Log.d("Array",Integer.toString(item.size()));}
            else{
            Toast.makeText(this, "Debes introducir Material y Cantidad", Toast.LENGTH_SHORT).show();
        }
    }



    public void eliminarItem(final int position){
        AlertDialog.Builder dialogo = new AlertDialog.Builder(MainActivity.this);
        dialogo.setTitle("Importante");
        dialogo.setMessage("¿ Estás seguro de eliminar este item ?");
        dialogo.setCancelable(false);
        dialogo.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogo1, int id) {
                item.remove(position);
                adapter.notifyDataSetChanged();
                Toast.makeText(MainActivity.this, "Item eliminado", Toast.LENGTH_SHORT).show();
            }
        });
        dialogo.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogo1, int id) {

            }
        });
        dialogo.show();
    }

    public void llenarTextElemento(){
        material.setText(spinnerElemento.getSelectedItem().toString());
    }

    /*public void EntradaDeVoz()
    {

        Intent intent=new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT,"¿Que material necesitas?");
        try {
            startActivityForResult(intent,REQ_CODE_SPEECH_INPUT);
        }catch (ActivityNotFoundException e)
        {

        }


    }*/

    /*@Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode){
            case REQ_CODE_SPEECH_INPUT:{
                if (resultCode==RESULT_OK && data!=null){
                    ArrayList<String> result=data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    material.setText(result.get(0));
                }
            }
        }

    }*/
}


