package com.example.aprinew

import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText

class keyboard_tambah : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.keyboard_tambah)

        val edt_nama: EditText = findViewById(R.id.edt_nama)
        val edt_harga: EditText = findViewById(R.id.edt_harga)
        val btn_simpan: Button = findViewById(R.id.btn_simpan)

        btn_simpan.setOnClickListener {
            val isi_nama:String = edt_nama.text.toString()
            val isi_harga:String = edt_harga.text.toString()

            val dbtoko: SQLiteDatabase = openOrCreateDatabase("toko", MODE_PRIVATE, null)
            val eksekutor = dbtoko.rawQuery("INSERT INTO keyboard (nama_barang,harga_barang)VALUES('$isi_nama','$isi_harga')", null)
            eksekutor.moveToNext()

            val pindah: Intent = Intent(this,keyboard::class.java)
            startActivity(pindah)
            Log.d("namanya",isi_nama)
            Log.d("harganya", isi_harga)
        }
//
//            val dbtoko1: SQLiteDatabase = openOrCreateDatabase("toko.unknown", MODE_PRIVATE, null)
//            val eksekutor1 = dbtoko1.rawQuery("INSERT INTO keyboard (nama_barang,harga_barang,)VALUES('$isi_nama','$isi_harga')", null)
//            eksekutor1.moveToNext()
//
//            val pindah1: Intent = Intent(this,dashboard::class.java)
//            startActivity(pindah1)
//
//            val dbtoko2: SQLiteDatabase = openOrCreateDatabase("toko.unknown", MODE_PRIVATE, null)
//            val eksekutor2 = dbtoko2.rawQuery("INSERT INTO monitor (nama_barang,harga_barang,)VALUES('$isi_nama','$isi_harga')", null)
//            eksekutor2.moveToNext()
//
//            val pindah2: Intent = Intent(this,dashboard::class.java)
//            startActivity(pindah2)
//
//            val dbtoko3: SQLiteDatabase = openOrCreateDatabase("toko.unknown", MODE_PRIVATE, null)
//            val eksekutor3 = dbtoko3.rawQuery("INSERT INTO mouse (nama_barang,harga_barang,)VALUES('$isi_nama','$isi_harga')", null)
//            eksekutor3.moveToNext()
//
//            val pindah3: Intent = Intent(this,dashboard::class.java)
//            startActivity(pindah3)


//            Log.d("kodenya",isi_kode)
//            Log.d("Namanya", isi_nama)
//            Log.d("Harganya", isi_harga)
        }
    }