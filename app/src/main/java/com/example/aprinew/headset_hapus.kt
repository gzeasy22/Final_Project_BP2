package com.example.aprinew

import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class headset_hapus : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.keyboard_hapus)

        val id_produk_terpilih:String = intent.getStringExtra("id_produk_terpilih").toString()

        val dbtoko: SQLiteDatabase = openOrCreateDatabase("toko", MODE_PRIVATE, null)
        val query = dbtoko.rawQuery("DELETE FROM headset WHERE id_barang= '$id_produk_terpilih'", null)
        query.moveToNext()

        val pindah: Intent = Intent(this,headset::class.java)
        startActivity(pindah)



    }
}