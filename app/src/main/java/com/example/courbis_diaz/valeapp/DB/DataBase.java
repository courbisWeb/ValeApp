package com.example.courbis_diaz.valeapp.DB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.courbis_diaz.valeapp.Contract.CargoContract;
import com.example.courbis_diaz.valeapp.Contract.ColaboradorContract;
import com.example.courbis_diaz.valeapp.Contract.ComunaContract;
import com.example.courbis_diaz.valeapp.Contract.EmpresaContract;
import com.example.courbis_diaz.valeapp.Contract.MarcaContract;
import com.example.courbis_diaz.valeapp.Contract.MaterialContract;
import com.example.courbis_diaz.valeapp.Contract.MovimientoMaterialContract;
import com.example.courbis_diaz.valeapp.Contract.ObraContract;
import com.example.courbis_diaz.valeapp.Contract.TipoContract;
import com.example.courbis_diaz.valeapp.Contract.TipoValeContract;


public class DataBase  extends SQLiteOpenHelper{

    public static final int DATEBASE_VERSION=1;
    public static final String DATABASE_NAME="valeapp.db";

    public DataBase(Context context) {
        super(context, DATABASE_NAME, null, DATEBASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {


        //Tabla colaborador
        sqLiteDatabase.execSQL("CREATE TABLE " + ColaboradorContract.colaboradorEntry.TABLE_NAME + " ("
                + ColaboradorContract.colaboradorEntry.id + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + ColaboradorContract.colaboradorEntry.rut + " TEXT NOT NULL,"
                + ColaboradorContract.colaboradorEntry.nombre + " TEXT NOT NULL,"
                + ColaboradorContract.colaboradorEntry.empresa + " INTEGER NOT NULL,"//foranea
                + ColaboradorContract.colaboradorEntry.cargo + " INTEGER NOT NULL,"//foranea
                + ColaboradorContract.colaboradorEntry.pass + " TEXT,"
                + "FOREIGN KEY(empresa) REFERENCES empresa(id),"
                +" FOREIGN KEY(cargo) REFERENCES cargo(id),"
                + "UNIQUE (" + ColaboradorContract.colaboradorEntry.id + "))");
        //Tabla Cargo
        sqLiteDatabase.execSQL("CREATE TABLE " + CargoContract.cargoEntry.TABLE_NAME + " ("
                        + CargoContract.cargoEntry.id + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                        + CargoContract.cargoEntry.cargo + " TEXT NOT NULL,"
                        + "UNIQUE (" + CargoContract.cargoEntry.id + "))");

        //Tabla Empresa
        /*sqLiteDatabase.execSQL("CREATE TABLE " + EmpresaContract.EmpresaEntry.TABLE_NAME + " ("
                + EmpresaContract.EmpresaEntry.id + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + EmpresaContract.EmpresaEntry.razonSocial + " TEXT NOT NULL,"
                + EmpresaContract.EmpresaEntry.rut + "TEXT NOT NULL,"
                + EmpresaContract.EmpresaEntry.comuna + "INTEGER NOT NULL," //Foranea
                + EmpresaContract.EmpresaEntry.direccion + "TEXT NOT NULL,"
                + EmpresaContract.EmpresaEntry.tipo + "INTEGER NOT NULL,"//Foranea
                + "FOREIGN KEY(comuna) REFERENCES comuna(id),"
                + "FOREIGN KEY(tipo) REFERENCES tipo(id),"
                + "UNIQUE (" + EmpresaContract.EmpresaEntry.id + "))");*/

        //Tabla Comuna
        /*sqLiteDatabase.execSQL("CREATE TABLE " + ComunaContract.comunaEntry.TABLE_NAME + " ("
                + ComunaContract.comunaEntry.id + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + ComunaContract.comunaEntry.comuna + " TEXT NOT NULL,"
                + "UNIQUE (" + ComunaContract.comunaEntry.id + "))");*/

        //Tabla tipo
        /*sqLiteDatabase.execSQL("CREATE TABLE " + TipoContract.tipoEntry.TABLE_NAME + " ("
                + TipoContract.tipoEntry.id + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + TipoContract.tipoEntry.tipo + " TEXT NOT NULL,"
                + "UNIQUE (" + TipoContract.tipoEntry.id + "))");*/

        //Tabla Material
        sqLiteDatabase.execSQL("CREATE TABLE " + MaterialContract.materialEntry.TABLE_NAME + " ("
                + MaterialContract.materialEntry.id + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + MaterialContract.materialEntry.material + " TEXT NOT NULL,"
                + MaterialContract.materialEntry.marca + " TEXT NOT NULL,"
                + MaterialContract.materialEntry.proveedor + " TEXT NOT NULL,"
                + "UNIQUE (" + MaterialContract.materialEntry.id + "))");

        //Tabla Marca
        sqLiteDatabase.execSQL("CREATE TABLE " + MarcaContract.marcaEntry.TABLE_NAME + " ("
                + MarcaContract.marcaEntry.id + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + MarcaContract.marcaEntry.marca + " TEXT NOT NULL,"
                + "UNIQUE (" + MarcaContract.marcaEntry.id + "))");

        //Tabla Movimiento material
        sqLiteDatabase.execSQL("CREATE TABLE " + MovimientoMaterialContract.movimientoMaterialEntry.TABLE_NAME + " ("
                + MovimientoMaterialContract.movimientoMaterialEntry.id + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + MovimientoMaterialContract.movimientoMaterialEntry.fecha + " TEXT NOT NULL,"
                + MovimientoMaterialContract.movimientoMaterialEntry.material + " INTEGER NOT NULL,"//Foranea de material
                + MovimientoMaterialContract.movimientoMaterialEntry.obra + " INTEGER NOT NULL,"//Foranea de Obra
                + MovimientoMaterialContract.movimientoMaterialEntry.responsable + " INTEGER NOT NULL,"//Foranea de colaborador
                + MovimientoMaterialContract.movimientoMaterialEntry.cantidad + " INTEGER NOT NULL,"
                + "FOREIGN KEY(material) REFERENCES material(id),"
                + "FOREIGN KEY(obra) REFERENCES obra(id),"
                + "FOREIGN KEY(responsable) REFERENCES colaborador(id),"
                + "UNIQUE (" + MovimientoMaterialContract.movimientoMaterialEntry.id + "))");

        //Tabla Obra
        sqLiteDatabase.execSQL("CREATE TABLE " + ObraContract.obraEntry.TABLE_NAME + " ("
                + ObraContract.obraEntry.id + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + ObraContract.obraEntry.obra + " TEXT NOT NULL,"
                + ObraContract.obraEntry.comuna + " INTEGER NOT NULL,"//Foranea de comuna
                + ObraContract.obraEntry.direccion + " TEXT NOT NULL,"
                + ObraContract.obraEntry.empresa + " INTEGER NOT NULL,"//Foranea de empresa
                + "FOREIGN KEY(comuna) REFERENCES comuna(id),"
                + "FOREIGN KEY(empresa) REFERENCES empresa(id),"
                + "UNIQUE (" + ObraContract.obraEntry.id + "))");

        //Tabla Tipo
        sqLiteDatabase.execSQL("CREATE TABLE " + TipoValeContract.tipoValeEntry.TABLE_NAME + " ("
                + TipoValeContract.tipoValeEntry.id + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + TipoValeContract.tipoValeEntry.tipoVale + " TEXT NOT NULL,"
                + "UNIQUE (" + TipoValeContract.tipoValeEntry.id + "))");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
