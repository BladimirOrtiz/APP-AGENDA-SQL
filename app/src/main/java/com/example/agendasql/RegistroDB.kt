package com.example.agendasql

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class RegistroDB : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro_db)
        val nc=findViewById<EditText>(R.id.txtNControl)
        val nom_estudiante=findViewById<EditText>(R.id.txtNombre)
        val carrera=findViewById<Spinner>(R.id.cbxCarreras)
        val semestre=findViewById<Spinner>(R.id.cbxSemestre)
        val grupos=findViewById<Spinner>(R.id.cbxGrupos)
        val registrar=findViewById<Button>(R.id.btnRegistrar)
        val Buttonlistar=findViewById<Button>(R.id.btnListar)
        registrar.setOnClickListener {
            val admin = AdminSqliteOpenHelper(this,"bd_estudiante", null, 1)
            val bd = admin.writableDatabase
            val registro = ContentValues()
            registro.put("nc", nc.getText().toString())
            registro.put("nom_estudiante", nom_estudiante.getText().toString())
            registro.put("carrera", carrera.selectedItem.toString())
            registro.put("semestre", semestre.selectedItem.toString())
            registro.put("grupo", grupos.selectedItem.toString())
            bd.insert("estudiante", null, registro)
            bd.close()
            nc.setText("")
            nom_estudiante.setText("")

           Toast.makeText(this, "Se cargaron los datos del estudiante", Toast.LENGTH_SHORT).show()
    }
        Buttonlistar.setOnClickListener {

            val intento1 :  Intent = Intent(this, ListarRegistros::class.java)
            startActivity(intento1)
        }
    }
}