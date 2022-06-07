package com.example.agendasql

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper


class AdminSqliteOpenHelper(context: Context, name: String, factory: SQLiteDatabase.CursorFactory?, version: Int)
    : SQLiteOpenHelper (context, name, factory, version){

    override fun onCreate(db: SQLiteDatabase) {
        //TODO("Not yet implemented")
        db.execSQL("create table estudiante (nc text , nom_estudiante text, carrera text, semestre int, grupo text)")
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }
}