package com.example.examen2_tamiapolo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AgregarReceta extends AppCompatActivity {
    CRUDRecetas CRUD = new CRUDRecetas(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_receta);

        EditText etTitulo = findViewById(R.id.etTitulo);
        EditText etDescripcion = findViewById(R.id.etDescripcion);
        Button btnAgregarR = findViewById(R.id.btnAgregarR);

        Button btnCancelar= findViewById(R.id.btnCancelar);
        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intento1 = new Intent(AgregarReceta.this, MainActivity.class);
                startActivity(intento1);
            }
        });

        btnAgregarR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CRUD.insertarReceta(etTitulo.getText().toString(), etDescripcion.getText().toString());
                Intent intento2 = new Intent(AgregarReceta.this, MainActivity.class);
                startActivity(intento2);
            }
        });
    }
}