package com.example.courbis_diaz.valeapp.Contract;

import android.provider.BaseColumns;

public class ComunaContract {

    public static abstract class comunaEntry implements BaseColumns {
        public static final String TABLE_NAME="comuna";

        public static final String id="id";
        public static final String comuna="comuna";
    }

}
