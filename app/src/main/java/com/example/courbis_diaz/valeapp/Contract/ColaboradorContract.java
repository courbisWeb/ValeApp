package com.example.courbis_diaz.valeapp.Contract;

import android.provider.BaseColumns;

public class ColaboradorContract {

    public static abstract class colaboradorEntry implements BaseColumns{
        public static final String TABLE_NAME="colaborador";

        public static final String id="id";
        public static final String rut="rut";
        public static final String nombre="nombre";
        public static final String cargo="cargo";
        public static final String empresa="empresa";
        public static final String pass="pass";
    }

}
