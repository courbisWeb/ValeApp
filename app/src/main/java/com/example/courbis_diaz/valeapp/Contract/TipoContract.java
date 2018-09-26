package com.example.courbis_diaz.valeapp.Contract;

import android.provider.BaseColumns;

public class TipoContract {

    public static abstract class tipoEntry implements BaseColumns{

        public static final String TABLE_NAME="tipo_empresa";

        public static final String id="id";
        public static final String tipo="tipo";


    }

}
