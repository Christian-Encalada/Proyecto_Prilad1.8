package com.chris.proyecto_prilad

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class RegisterAcivity : AppCompatActivity() {

    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_acivity)
        val txtemail_nuevo : TextView = findViewById(R.id.edtCorreo2)
        val txtpass_nuevo : TextView = findViewById(R.id.edtContrasena)
        val txtpass_nuevo_conf : TextView = findViewById(R.id.edtContrasenaConfirmacion)
        val btnCrear : Button = findViewById(R.id.registroTerminadoBtn)
        btnCrear.setOnClickListener(){
            var pass1 = txtpass_nuevo.text.toString()
            var pass2 = txtpass_nuevo_conf.text.toString()
            if (pass1.equals(pass2))
            {
                crearCuenta(txtemail_nuevo.text.toString(), txtpass_nuevo.text.toString())
            }
            else
            {
                Toast.makeText(baseContext, "Las contraseñas no son iguales",Toast.LENGTH_SHORT).show()
                txtpass_nuevo.requestFocus()
            }
        }

        //registro
        firebaseAuth= Firebase.auth




       // Botones
        val btn2: Button = findViewById(R.id.iniciarSesionBtn2)
        btn2.setOnClickListener {
           val intent: Intent = Intent(this, Pantalla_2::class.java)
            startActivity(intent)

        }
    }

    private fun crearCuenta(email: String, password: String){
        firebaseAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this)  {task ->
                if (task.isSuccessful)
                {
                    Toast.makeText(baseContext, "Cuenta creada", Toast.LENGTH_SHORT).show()
                }
                else
                {
                    Toast.makeText(baseContext, "Error al crear la cuenta: " + task.exception, Toast.LENGTH_SHORT).show()

                }
            }

    }

}

