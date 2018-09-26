package com.example.courbis_diaz.valeapp.Contract;

import android.provider.BaseColumns;

public class MarcaContract {

    public static abstract class marcaEntry implements BaseColumns{
        public static final String TABLE_NAME="marca";

        public static final String id="id";
        public static final String marca="marca";
    }

}
