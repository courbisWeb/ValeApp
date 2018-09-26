package com.example.courbis_diaz.valeapp.Contract;

import android.provider.BaseColumns;

public class ObraContract {

    public static abstract class obraEntry implements BaseColumns{

        public static final String TABLE_NAME="obra";

        public static final String id="id";
        public static final String obra="obra";
        public static final String empresa="empresa";
        public static final String direccion="direccion";
        public static final String comuna="comuna";
    }

}
