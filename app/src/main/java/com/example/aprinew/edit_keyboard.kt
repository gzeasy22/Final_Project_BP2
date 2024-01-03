package com.example.aprinew

import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class edit_keyboard : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.edit_keyboard)

        val id_produk_terpilih:String = intent.getStringExtra("id_produk_terpilih").toString()

        val dbtoko : SQLiteDatabase = openOrCreateDatabase("toko", MODE_PRIVATE, null)
        val ambil = dbtoko.rawQuery("SELECT * FROM keyboard WHERE id_barang = '$id_produk_terpilih'",null)
        ambil.moveToNext()

        val isi_namabarang = ambil.getString(1)
        val isi_hargabarang = ambil.getString(2)

        val edt_namabarang: EditText = findViewById(R.id.edt_namabarang)
        val edt_hargabarang: EditText = findViewById(R.id.edt_hargabarang)
        val btn_simpan: Button = findViewById(R.id.btn_Save)


        edt_namabarang.setText(isi_namabarang)
        edt_hargabarang.setText(isi_hargabarang)

        btn_simpan.setOnClickListener {
            val nama_baru:String = edt_namabarang.text.toString()
            val harga_baru:String = edt_hargabarang.text.toString()
            val mengubah = dbtoko.rawQuery("UPDATE keyboard SET nama_barang='$nama_baru',harga_barang='$harga_baru' WHERE id_barang = '$id_produk_terpilih'",null)
            mengubah.moveToNext()

            val pindah:Intent = Intent (this,keyboard::class.java)
            startActivity(pindah)
        }



    }
}