package com.example.aprinew

import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class mouse : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.mouse)

        val rv_mouse: RecyclerView = findViewById(R.id.rv_mouse)

        val btn_kembali: Button = findViewById(R.id.btn_kembali)
        btn_kembali.setOnClickListener {
            val keluar: Intent = Intent(this, dashboard::class.java)
            startActivity(keluar)
            finish()
        }

        val id: MutableList<String> = mutableListOf()
        val nama: MutableList<String> = mutableListOf()
        val harga: MutableList<String> = mutableListOf()
        val foto: MutableList<Int> = mutableListOf()


        val dbtoko: SQLiteDatabase = openOrCreateDatabase("toko", MODE_PRIVATE, null)
        val detail_produk = dbtoko.rawQuery("SELECT * FROM mouse", null)

        while (detail_produk.moveToNext()) {
            id.add(detail_produk.getString(0))
            nama.add(detail_produk.getString(1))
            harga.add(detail_produk.getString(2))
            foto.add(R.drawable.mousegaming)

            val mi = mouse_item(this, id, nama, harga, foto)

            rv_mouse.adapter = mi
            rv_mouse.layoutManager = GridLayoutManager(this, 2)

            val btn_tambah: Button = findViewById(R.id.btn_tambah)
            btn_tambah.setOnClickListener {
                val pindah: Intent = Intent(this, mouse_tambah::class.java)
                startActivity(pindah)
            }
        }
    }}

//        val btn_logout: Button = findViewById(R.id.btn_logout)
//        btn_logout.setOnClickListener {
//
//            val keluar: Intent = Intent(this, dashboard::class.java)
//            startActivity(keluar)
//            finish()
//        }