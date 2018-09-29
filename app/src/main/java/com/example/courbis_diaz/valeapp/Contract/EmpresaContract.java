package com.example.courbis_diaz.valeapp.Contract;

import android.provider.BaseColumns;

public class EmpresaContract {

    public static abstract class EmpresaEntry implements BaseColumns{
        public static final String TABLE_NAME="empresa";

        public static final String id="id";
        public static final String rut="rut";
        public static final String direccion="direccion";
        public static final String comuna="comuna";
        public static final String tipo="tipo";
        public static final String razonSocial="razon_social";
    }

}
