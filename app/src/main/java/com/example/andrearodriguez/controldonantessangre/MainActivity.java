package com.example.andrearodriguez.controldonantessangre;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    BaseDatos basedatos;
    EditText idBusqueda;
    String cadena;
    ImageButton buscar;
    ImageButton limpiar;

    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        idBusqueda = (EditText)findViewById(R.id.edit_id_persona);
        buscar = (ImageButton)findViewById(R.id.buscar);
        limpiar = (ImageButton)findViewById(R.id.limpiar);

        basedatos = new BaseDatos(getApplicationContext());
        SQLiteDatabase sq = basedatos.getWritableDatabase();

        idBusqueda.setText(null);

        RecyclerAdapter adapter= new RecyclerAdapter(getApplicationContext(), null);
        recyclerView= (RecyclerView)findViewById(R.id.recyclerView);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        adapter.notifyDataSetChanged();


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                DialogoRegistrar dialogo = new DialogoRegistrar();
                dialogo.show(getSupportFragmentManager(), "DialogFragment");

                // sq.execSQL("DELETE FROM Lista");

                RecyclerAdapter adapter= new RecyclerAdapter(getApplicationContext(), null);
                recyclerView= (RecyclerView)findViewById(R.id.recyclerView);
                recyclerView.setAdapter(adapter);
                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                adapter.notifyDataSetChanged();

                Snackbar.make(view, "Todos los donantes", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(idBusqueda.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(), "Ingresa un id", Toast.LENGTH_LONG).show();
                }else if (idBusqueda != null && idBusqueda.getText() != null) {
                    String texto = idBusqueda.getText().toString();
                    RecyclerAdapter adapter = new RecyclerAdapter(getApplicationContext(), texto);
                    recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
                    recyclerView.setAdapter(adapter);
                    recyclerView.setHasFixedSize(true);
                    recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

                    Snackbar.make(view, "Resultado de la busqueda", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();

                }

            }
        });

        limpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                idBusqueda.setText(null);

                RecyclerAdapter adapter= new RecyclerAdapter(getApplicationContext(), null);
                recyclerView= (RecyclerView)findViewById(R.id.recyclerView);
                recyclerView.setAdapter(adapter);
                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                adapter.notifyDataSetChanged();

                Snackbar.make(view, "Todos los donantes", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

}
