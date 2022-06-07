package com.example.agendasql

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

    class ListarRegistros : AppCompatActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)

            setContentView(R.layout.activity_listar_registros)
        //val paises = arrayOf("Mexico", "Brasil", "Canadá")
        val listView1 : ListView = findViewById<ListView> (R.id.lista1)
        //Creamos un arreglo vacío
        var lista_alum= ArrayList<String>()
        val adapter: ArrayAdapter<String> = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lista_alum)
        listView1.setAdapter(adapter)

        val admin = AdminSqliteOpenHelper(this, "bd_estudiante", null, 1)
        val bd = admin.readableDatabase
        val fila = bd.rawQuery("select nc,nom_estudiante, carrera,semestre, grupo from estudiante", null)
        while (fila.moveToNext()) {
            //llenamos el arreglo
            lista_alum.add(fila.getString(0)+"," + fila.getString(1)+"," + fila.getString(2)+"," + fila.getString(3)+"," + fila.getString(4))
            adapter.notifyDataSetChanged()
        }
        bd.close()
    }
    }