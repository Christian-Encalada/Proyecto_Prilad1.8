package com.chris.proyecto_prilad

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer

class CargaPantalla : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_carga_pantalla)
        supportActionBar?.hide()
        startTimer()
    }

    fun startTimer(){
        object: CountDownTimer(2000,1000){
            override fun onTick(p0: Long) {

            }

            override fun onFinish() {
                val intent = Intent(applicationContext,MainActivity::class.java).apply { }
                startActivity(intent)
                finish()
            }

        }.start()
    }
}