package com.example.andrearodriguez.controldonantessangre;

import android.provider.BaseColumns;

/**
 * Created by andrearodriguez on 1/14/18.
 */

public class Estructura {

    public Estructura(){


    }

    public static abstract class EstructuraBase implements BaseColumns
    {
        public static final String TABLE1_NAME = "ListaDonantes";
        public static final String COLUMNA_NAME = "Nombre";
        public static final String COLUMNA_LASTNAME = "Apellido";
        public static final String COLUMNA_ID = "Identificacion";
        public static final String COLUMNA_EDAD = "Edad";
        public static final String COLUMNA_TIPOSANGRE = "Tipo";
        public static final String COLUMNA_RH = "RH";
        public static final String COLUMNA_ESTATURA = "Estatura";
        public static final String COLUMNA_PESO = "Peso";
    }
}
