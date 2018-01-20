package com.example.andrearodriguez.controldonantessangre;

import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Created by andrearodriguez on 1/14/18.
 */

public class RecyclerViewHolder extends RecyclerView.ViewHolder {

    TextView nombre, apellido, id, edad, tipo, rh, estatura, peso;
    ImageButton eliminar, editar;


    public RecyclerViewHolder(View itemView) {
        super(itemView);

        nombre = (TextView) itemView.findViewById(R.id.txtNombre);
        apellido = (TextView) itemView.findViewById(R.id.txtNombreDonante);
        id = (TextView) itemView.findViewById(R.id.txtIdUsuario);
        edad = (TextView) itemView.findViewById(R.id.txtEdadUsuario);
        tipo = (TextView) itemView.findViewById(R.id.txtTipoSangreUsuario);
        rh = (TextView) itemView.findViewById(R.id.txtRhUsuario);
        estatura = (TextView) itemView.findViewById(R.id.txtEstaturaUsuario);
        peso = (TextView) itemView.findViewById(R.id.txtPesoUsuario);

        eliminar = (ImageButton) itemView.findViewById(R.id.imgEliminar);
        editar = (ImageButton) itemView.findViewById(R.id.imgEditar);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = getAdapterPosition();
                Snackbar.make(view, "Posición de objeto " + position, Snackbar.LENGTH_SHORT).setAction("Action", null).show();
            }
        });

    }
}