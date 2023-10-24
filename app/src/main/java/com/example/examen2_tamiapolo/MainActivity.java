package com.example.examen2_tamiapolo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //ENLAZAR LISTVIEW
        ListView lvPracticas = findViewById(R.id.listarecetas);

        /*
        //PASO 2: Crear el arreglo
        final String[] arregloPracticas = {
                "Pasta",
                "Tacos",
                "Pizza",
                "Sandwich",
        };

        //PASO 3: Crear el adaptador
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arregloPracticas);
        // PASO 4: Asignar el adaptador
        lvPracticas.setAdapter(adapter);

        //PASO 5: Agregar evento a cada evento
        lvPracticas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                switch (position) {
                    case 0:
                        Toast.makeText(MainActivity.this, "Pasta", Toast.LENGTH_SHORT).show();
                        Intent intento = new Intent(MainActivity.this, EditarReceta.class);
                        startActivity(intento);
                        break;
                    case 1:
                        Toast.makeText(MainActivity.this, "Tacos", Toast.LENGTH_SHORT).show();
                        Intent intento1 = new Intent(MainActivity.this, EditarReceta.class);
                        startActivity(intento1);
                        break;
                    case 2:
                        Toast.makeText(MainActivity.this, "Pizza", Toast.LENGTH_SHORT).show();
                        Intent intento2 = new Intent(MainActivity.this, EditarReceta.class);
                        startActivity(intento2);
                        break;
                    case 3:
                        Toast.makeText(MainActivity.this, "Sandwich", Toast.LENGTH_SHORT).show();
                        Intent intento3 = new Intent(MainActivity.this, EditarReceta.class);
                        startActivity(intento3);
                        break;

                }
            }
        });*/

        //-------------------------------------------
        //Código PROFESOR

        Button btnAgregar= findViewById(R.id.btnAgregar);
        Button btnEliminar= findViewById(R.id.btnEliminar);
        Button btnEditar= findViewById(R.id.btnEditar);

        //Button btnBorrar= findViewById(R.id.btnAgregar);
        CRUDRecetas CRUD = new CRUDRecetas(this);
        ArrayList<String> listaRecetitas = new ArrayList<String>();

        /*CRUD.insertarReceta(" Pasta", "Comida italiana");
        CRUD.insertarReceta(" Tacos", "Comida mexicana");
        CRUD.insertarReceta(" Pizza", "Comida italiana");
        CRUD.insertarReceta(" Sandwich", "Comida casera");*/

        ListView listaRecetas=findViewById(R.id.listarecetas);
        Cursor informacion=CRUD.mostrarRecetas();

        //Buscar ID
        while (informacion.moveToNext()){
            String titulo=informacion.getString(0) + informacion.getString(1);
            listaRecetitas.add(titulo);
        }
        ArrayAdapter<String> adaptador=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,listaRecetitas);
        listaRecetas.setAdapter(adaptador);


        btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intento1 = new Intent(MainActivity.this, eliminar.class);
                startActivity(intento1);
            }
        });

        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intento = new Intent(MainActivity.this, AgregarReceta.class);
                startActivity(intento);
            }
        });

        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intento = new Intent(MainActivity.this, EditarReceta.class);
                startActivity(intento);
            }
        });


    }
}