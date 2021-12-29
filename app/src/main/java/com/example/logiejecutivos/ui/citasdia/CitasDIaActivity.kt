package com.example.logiejecutivos.ui.citasdia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.logiejecutivos.R
import com.example.logiejecutivos.ui.adaptador.CustomAdaptador

class CitasDIaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_citas_dia)


        val bundle = intent.extras
        val paciente = bundle?.getString("Paciente")
        val origen = bundle?.getString("Origen")
        val destino = bundle?.getString("Destino")
        val conductor = bundle?.getString("Conductor")
        val hor = bundle?.getString("Array")

        val nombre_paciente = findViewById<TextView>(R.id.txt_nom_paciente)
        val condu = findViewById<TextView>(R.id.txt_conductor)
        val ruta = findViewById<TextView>(R.id.txt_ruta)


        nombre_paciente.text = "PACIENTE: " + paciente.toString()
        condu.text = "CONDUCTOR: " + conductor.toString()
        ruta.text = "RUTA: " + origen.toString() + " - " +destino.toString()

        //Modifique la hora por el Array

        //CODIGO DEL RECYCLER VIEW
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
        val adapter = CustomAdaptador()

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }
}