package com.example.aprinew

import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText

class monitor_tambah : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.monitor_tambah)

        val edt_nama: EditText = findViewById(R.id.edt_nama)
        val edt_harga: EditText = findViewById(R.id.edt_harga)
        val btn_simpan: Button = findViewById(R.id.btn_simpan)

        btn_simpan.setOnClickListener {
            val isi_nama:String = edt_nama.text.toString()
            val isi_harga:String = edt_harga.text.toString()

            val dbtoko: SQLiteDatabase = openOrCreateDatabase("toko", MODE_PRIVATE, null)
            val eksekutor = dbtoko.rawQuery("INSERT INTO monitor (nama_barang,harga_barang)VALUES('$isi_nama','$isi_harga')", null)
            eksekutor.moveToNext()

            val pindah: Intent = Intent(this,monitor::class.java)
            startActivity(pindah)
            Log.d("namanya",isi_nama)
            Log.d("harganya", isi_harga)
        }
    }
}