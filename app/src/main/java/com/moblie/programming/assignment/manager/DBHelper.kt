package com.moblie.programming.assignment.manager

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.moblie.programming.assignment.type.Certificate

class DBHelper(val context: Context?) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    companion object{
        const val DATABASE_VERSION = 1
        const val DATABASE_NAME = "TEST"
    }

    override fun onCreate(db: SQLiteDatabase) {
        var sql: String = "CREATE TABLE IF NOT EXISTS fav (id integer);"
        db.execSQL(sql)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        // NOTHING TO DO
    }

    fun addFav(certificate: Certificate) {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put("id", certificate.id)

        db.delete("fav", "id = ?", arrayOf(certificate.id.toString()))
        db.insert("fav", null, values)
        db.close()
    }

    @SuppressLint("Range")
    fun getList() : List<Int> {
        val db = this.writableDatabase
        val list = ArrayList<Int>()
        val selectQueryHandler = "SELECT * FROM fav"
        val cursor = db.rawQuery(selectQueryHandler,null)
        if (cursor.moveToFirst()) {
            do {
                val id = cursor.getString(cursor.getColumnIndex("id")).toInt()
                list.add(id)
            } while (cursor.moveToNext())
        }
        db.close()
        return list
    }

    fun deleteAllFav(){
        val db = this.writableDatabase

        db.delete("fav", "id is not ?", arrayOf("0"))
        db.close()
        CertificateManager.updateAllFav(false)
    }

    fun deleteFav(certificate: Certificate) {
        val db = this.writableDatabase

        db.delete("fav", "id = ?", arrayOf(certificate.id.toString()))
        db.close()
    }
}