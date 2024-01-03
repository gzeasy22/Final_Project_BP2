package com.example.aprinew

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        val btn_login:Button= findViewById(R.id.btn_login)

        btn_login.setOnClickListener {
            val pindah:Intent = Intent(this, dashboard::class.java)
            startActivity(pindah)
        }
    }
}