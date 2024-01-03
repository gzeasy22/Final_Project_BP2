package com.example.aprinew

import android.content.Intent
import android.content.SharedPreferences
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class dashboard : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dashboard)

        val btn_keyboard:Button = findViewById(R.id.btn_keyboard)
        val btn_mouse:Button = findViewById(R.id.btn_mouse)
        val btn_monitor:Button = findViewById(R.id.btn_monitor)
        val btn_headset:Button = findViewById(R.id.btn_headset)
        val btn_logout:Button = findViewById(R.id.btn_logout)
        btn_logout.setOnClickListener {
            val keluar: Intent = Intent(this, login::class.java)
            startActivity(keluar)
            finish()
        }


        btn_keyboard.setOnClickListener {
            val pindah:Intent = Intent(this,keyboard::class.java)
            startActivity(pindah)
        }
        btn_mouse.setOnClickListener {
            val pindah1:Intent = Intent(this,mouse::class.java)
            startActivity(pindah1)
        }
        btn_monitor.setOnClickListener {
            val pindah2:Intent = Intent(this,monitor::class.java)
            startActivity(pindah2)
        }
        btn_headset.setOnClickListener {
            val pindah3:Intent = Intent(this,headset::class.java)
            startActivity(pindah3)


            val tiket : SharedPreferences = getSharedPreferences("user", MODE_PRIVATE)
            val nama_user = tiket.getString("nama_user", null).toString()

            }


//            val dbtoko: SQLiteDatabase = openOrCreateDatabase("toko", MODE_PRIVATE, null)
//            val detail_produk = dbtoko.rawQuery("SELECT * FROM headset", null)
//
//            val dbtoko1: SQLiteDatabase = openOrCreateDatabase("toko", MODE_PRIVATE, null)
//            val detail_produk1 = dbtoko1.rawQuery("SELECT * FROM keyboard", null)
//
//            val dbtoko2: SQLiteDatabase = openOrCreateDatabase("toko", MODE_PRIVATE, null)
//            val detail_produk2 = dbtoko2.rawQuery("SELECT * FROM monitor", null)
//
//            val dbtoko3: SQLiteDatabase = openOrCreateDatabase("toko", MODE_PRIVATE, null)
//            val detail_produk3 = dbtoko3.rawQuery("SELECT * FROM mouse", null)

//            while (detail_produk.moveToNext()){
//                id.add(detail_produk.getString(0))
//                nama.add(detail_produk.getString(1))
//                harga.add(detail_produk.getString(2))


        }
    }
