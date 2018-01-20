package com.example.andrearodriguez.controldonantessangre;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by andrearodriguez on 1/14/18.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerViewHolder>{

    BaseDatos basedatos;
    private ArrayList<String> arreglodonantesNombre = new ArrayList<String>();
    private ArrayList<String> arreglodonantesApellido = new ArrayList<String>();
    private ArrayList<String> arreglodonantesEdad = new ArrayList<String>();
    private ArrayList<String> arreglodonantesTipo = new ArrayList<String>();
    private ArrayList<String> arreglodonantesRh = new ArrayList<String>();
    private ArrayList<String> arreglodonantesEstatura = new ArrayList<String>();
    private ArrayList<String> arreglodonantesPeso = new ArrayList<String>();
    private ArrayList<String> arreglodonantesId = new ArrayList<String>();


    String cadena ;
    LayoutInflater inflater;
    Context context;
    Cursor c;




    public RecyclerAdapter(Context context, String cadena) {
        this.context = context;
        inflater = LayoutInflater.from(context);

        basedatos = new BaseDatos(context);
        SQLiteDatabase sq = basedatos.getWritableDatabase();


        c = sq.rawQuery("SELECT * FROM " + Estructura.EstructuraBase.TABLE1_NAME, null);

        if (cadena != null) {
            if (!cadena.equals("")) {
                c = sq.rawQuery("SELECT * FROM ListaDonantes where Identificacion=?", new String[]{cadena});
            }
        }

            int a = 0;
            if (c.moveToFirst()) {
                do {
                    arreglodonantesNombre.add(c.getString((c.getColumnIndex(Estructura.EstructuraBase.COLUMNA_NAME))));
                    arreglodonantesApellido.add(c.getString((c.getColumnIndex(Estructura.EstructuraBase.COLUMNA_LASTNAME))));
                    arreglodonantesEdad.add(c.getString((c.getColumnIndex(Estructura.EstructuraBase.COLUMNA_EDAD))));
                    arreglodonantesTipo.add(c.getString((c.getColumnIndex(Estructura.EstructuraBase.COLUMNA_TIPOSANGRE))));
                    arreglodonantesRh.add(c.getString((c.getColumnIndex(Estructura.EstructuraBase.COLUMNA_RH))));
                    arreglodonantesEstatura.add(c.getString((c.getColumnIndex(Estructura.EstructuraBase.COLUMNA_ESTATURA))));
                    arreglodonantesPeso.add(c.getString((c.getColumnIndex(Estructura.EstructuraBase.COLUMNA_PESO))));
                    arreglodonantesId.add(c.getString((c.getColumnIndex(Estructura.EstructuraBase.COLUMNA_ID))));
                    a++;
                } while (c.moveToNext());
            }

    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v=inflater.inflate(R.layout.row_donante,parent,false);
        RecyclerViewHolder view1= new RecyclerViewHolder(v);
        return view1;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        holder.nombre.setText(arreglodonantesNombre.get(position));
        holder.apellido.setText(arreglodonantesApellido.get(position));
        holder.edad.setText(arreglodonantesEdad.get(position) + " Años");
        holder.tipo.setText(arreglodonantesTipo.get(position));
        holder.rh.setText(arreglodonantesRh.get(position));
        holder.estatura.setText(arreglodonantesEstatura.get(position) + " cm");
        holder.peso.setText(arreglodonantesPeso.get(position) + " Kg");
        holder.id.setText(arreglodonantesId.get(position).toString().trim());

        holder.editar.setOnClickListener(onClickEditar);
        holder.eliminar.setOnClickListener(onClickEliminar);
    }

    View.OnClickListener onClickEditar = new View.OnClickListener(){

        @Override
        public void onClick(View view) {
            RecyclerViewHolder vh=(RecyclerViewHolder)view.getTag();
            Toast.makeText(context,"Editar",Toast.LENGTH_SHORT).show();
        }
    };

    View.OnClickListener onClickEliminar = new View.OnClickListener(){

        @Override
        public void onClick(View view) {
            RecyclerViewHolder vh=(RecyclerViewHolder)view.getTag();
            Toast.makeText(context,"Eliminar",Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    public int getItemCount() {
        return arreglodonantesNombre.size();
    }
}
