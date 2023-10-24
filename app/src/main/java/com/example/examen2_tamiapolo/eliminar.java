package com.example.examen2_tamiapolo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class eliminar extends AppCompatActivity {
    CRUDRecetas CRUD = new CRUDRecetas(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar);



        EditText etTitulo = findViewById(R.id.etTitulo);

        Button btnEliminar= findViewById(R.id.btnEliminar);
        btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CRUD.eliminarReceta(Integer.parseInt(String.valueOf(etTitulo.getText())));
                Intent intento1 = new Intent(eliminar.this, MainActivity.class);
                startActivity(intento1);
            }
        });

        Button btnCancelar= findViewById(R.id.btnCancelar);
        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intento1 = new Intent(eliminar.this, MainActivity.class);
                startActivity(intento1);
            }
        });
    }
}