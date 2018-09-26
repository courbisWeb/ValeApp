package com.example.courbis_diaz.valeapp.Contract;

import android.provider.BaseColumns;

public class MaterialContract {

    public static abstract class materialEntry implements BaseColumns{
        public static final String TABLE_NAME="material";

        public static final String id="id";
        public static final String material="material";
        public static final String marca="marca";
        public static final String proveedor="proveedor";
    }

}
