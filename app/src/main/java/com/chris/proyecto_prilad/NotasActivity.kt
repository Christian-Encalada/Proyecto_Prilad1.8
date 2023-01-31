package com.chris.proyecto_prilad


import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.*

import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.FirebaseFirestore

private var db = FirebaseFirestore.getInstance()



class NotasActivity : AppCompatActivity() {
    private var selectedDate: String = ""
    lateinit var inputProducto: EditText
    lateinit var inputTareas: EditText




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notas)



        // calendario test


        val btnAgregarNota = findViewById<Button>(R.id.btn_guardarNota)
        val calendarView = findViewById<CalendarView>(R.id.calendarView2)
        val fechaTextView = findViewById<TextView>(R.id.id_Fecha)

//Este código establece un escuchador de cambios en la vista de calendario
// (calendarView). Cuando se selecciona una fecha en la vista de calendario, se guarda la fecha seleccionada
// en la variable "selectedDate" en el formato "día/mes/año". Luego, se establece el texto del "fechaTextView"
// con la fecha seleccionada.

        calendarView.setOnDateChangeListener { _, year, month, dayOfMonth ->
            selectedDate = "$dayOfMonth/${month+1}/$year"
            fechaTextView.text = selectedDate
        }

        btnAgregarNota.setOnClickListener {
            inputProducto = findViewById(R.id.input_producto)
            inputTareas = findViewById(R.id.input_tareas)
            //trim() elimina los espacios en blanco al principio y al final de la cadena.
            val producto = inputProducto.text.toString().trim()
            val tareas = inputTareas.text.toString().trim()

            if (producto.isNotEmpty() && tareas.isNotEmpty()) {

                //Este código asigna los valores de fecha, producto
                // y tareas a un mapa llamado "nota". Cada valor se guarda con una clave correspondiente en el mapa
                val nota = hashMapOf(
                    "fecha" to selectedDate,
                    "producto" to producto,
                    "tareas" to tareas
                )

                db.collection("notas")
                    .add(nota)
                    .addOnSuccessListener {
                        Toast.makeText(this, "Nota guardada correctamente", Toast.LENGTH_SHORT).show()


                    }
                    .addOnFailureListener { exception ->
                        // Error al agregar la nota
                        Log.w("Error", "Error al agregar la nota", exception)
                    }
            } else {
                // Faltan campos por llenar
                Toast.makeText(this, "Por favor llene todos los campos", Toast.LENGTH_SHORT).show()
            }
        }
    }




    }

