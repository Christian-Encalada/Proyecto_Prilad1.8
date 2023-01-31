package com.chris.proyecto_prilad

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase

class Pantalla_2 : AppCompatActivity() {
    private lateinit var firebaseAuth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pantalla2)
        val btnsesion : Button = findViewById(R.id.iniciarSesionBtn)
        val txtemail : TextView = findViewById(R.id.edtCorreo)
        val txtpass : TextView = findViewById(R.id.edtContrasena)
        //botones de pantallas



        val btn2: Button = findViewById(R.id.registroBtn)
        btn2.setOnClickListener {
            val intent: Intent = Intent(this, RegisterAcivity::class.java)
            startActivity(intent)


        }



        //iniciar sesion
        firebaseAuth= Firebase.auth
        btnsesion.setOnClickListener()
        {
            singIn(txtemail.text.toString(), txtpass.text.toString())
            val btn: Button = findViewById(R.id.iniciarSesionBtn)
            btn.setOnClickListener {
                if (txtemail.text.isEmpty() || txtpass.text.isEmpty()) {
                    Toast.makeText(baseContext, "Por favor proporciona un correo electrónico y una contraseña.", Toast.LENGTH_SHORT).show()
                }
                singIn(txtemail.text.toString(), txtpass.text.toString())
                val intent: Intent = Intent(this, NotasActivity::class.java)
                startActivity(intent)
            }
        }



    }
    private fun singIn(email: String, password: String)
    {
        firebaseAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val user = firebaseAuth.currentUser
                    Toast.makeText(baseContext, "INICIANDO SESION", Toast.LENGTH_SHORT).show()
                    // aqui vamos a ir a la segunda acivity
                }
                else
                {
                    Toast.makeText(baseContext,"Error de Email y/o Contraseña" , Toast.LENGTH_SHORT).show()
                }
            }
    }

}