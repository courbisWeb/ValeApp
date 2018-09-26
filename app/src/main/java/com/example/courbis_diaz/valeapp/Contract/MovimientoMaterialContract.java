package com.example.courbis_diaz.valeapp.Contract;

import android.provider.BaseColumns;

public class MovimientoMaterialContract {

    public static abstract class movimientoMaterialEntry implements BaseColumns{

        public static final String TABLE_NAME="movimiento_material";

        public static final String id="id";
        public static final String fecha="fecha";
        public static final String material="material";
        public static final String cantidad="cantidad";
        public static final String responsable="responsable";
        public static final String obra="obra";

    }


}
