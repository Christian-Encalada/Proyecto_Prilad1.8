package com.chris.proyecto_prilad

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn: Button = findViewById(R.id.button)
        btn.setOnClickListener {
            val intent: Intent = Intent(this, Pantalla_2:: class.java)
            startActivity(intent)
        }
    }
}