package com.example.examen2_tamiapolo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditarReceta extends AppCompatActivity {

    CRUDRecetas CRUD = new CRUDRecetas(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_receta);

            EditText etID = findViewById(R.id.etID);
            EditText etTitulo = findViewById(R.id.etTitulo);
            EditText etDescripcion = findViewById(R.id.etDescripcion);

            Button btnCancelar= findViewById(R.id.btnCancelar);
            Button btnGuardar= findViewById(R.id.btnGuardar);

            btnGuardar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    CRUD.actualizarReceta(Integer.parseInt(etID.getText().toString()), etTitulo.getText().toString(), etDescripcion.getText().toString());
                    Intent intento2 = new Intent(EditarReceta.this, MainActivity.class);
                    startActivity(intento2);
                }
            });

            btnCancelar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intento1 = new Intent(EditarReceta.this, MainActivity.class);
                    startActivity(intento1);
                }
            });
        }
}