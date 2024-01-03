package com.example.aprinew

import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class headset : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.headset)

        val rv_headset: RecyclerView = findViewById(R.id.rv_headset)

        val btn_kembali:Button = findViewById(R.id.btn_kembali)
        btn_kembali.setOnClickListener {
            val keluar:Intent = Intent(this,dashboard::class.java)
            startActivity(keluar)
            finish()
        }

        val id: MutableList<String> = mutableListOf()
        val nama: MutableList<String> = mutableListOf()
        val harga: MutableList<String> = mutableListOf()
        val foto: MutableList<Int> = mutableListOf()

        val dbtoko: SQLiteDatabase = openOrCreateDatabase("toko", MODE_PRIVATE, null)
        val detail_produk = dbtoko.rawQuery("SELECT * FROM headset", null)

        while (detail_produk.moveToNext()){
            id.add(detail_produk.getString(0))
            nama.add(detail_produk.getString(1))
            harga.add(detail_produk.getString(2))
            foto.add(R.drawable.headsetgaming)
        }
        val mi = headset_item(this, id,nama,harga,foto)

        rv_headset.adapter = mi
        rv_headset.layoutManager = GridLayoutManager(this, 2)

        val btn_tambah:Button = findViewById(R.id.btn_tambah)
        btn_tambah.setOnClickListener {
            val pindah:Intent = Intent(this, headset_tambah::class.java)
            startActivity(pindah)
        }

//        val btn_logout: Button = findViewById(R.id.btn_logout)
//        btn_logout.setOnClickListener {
//
//            val keluar: Intent = Intent(this, dashboard::class.java)
//            startActivity(keluar)
//            finish()
//        }


    }}