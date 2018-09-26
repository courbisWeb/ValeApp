package com.example.courbis_diaz.valeapp.Contract;

import android.provider.BaseColumns;

public class CargoContract {

    public static abstract class cargoEntry implements BaseColumns {
        public static final String TABLE_NAME="cargo";

        public static final String id="id";
        public static final String cargo="cargo";
    }

}
