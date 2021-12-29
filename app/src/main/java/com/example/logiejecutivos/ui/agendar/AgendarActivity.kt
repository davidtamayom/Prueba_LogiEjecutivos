package com.example.logiejecutivos.ui.agendar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import com.example.logiejecutivos.R
import com.example.logiejecutivos.ui.adaptador.CustomAdaptador
import com.example.logiejecutivos.ui.citasdia.CitasDIaActivity
import com.example.logiejecutivos.ui.timepicker.TimePickerFragment

class AgendarActivity : AppCompatActivity() {

    lateinit var btn_agendar : Button

    lateinit var pacientes : Spinner
    lateinit var origen : Spinner
    lateinit var destino : Spinner
    lateinit var conductor : Spinner

    lateinit var sel_paciente: String
    lateinit var sel_origen: String
    lateinit var sel_destino: String
    lateinit var sel_conductor: String
    lateinit var hora: String

    var array_pacientes = arrayListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agendar)
        findViewById<EditText>(R.id.editTextTime).setOnClickListener { showTimePickerDialog() }

        //Spinner PACIENTES
        val nom_pacientes =
            listOf<String>("Seleccione", "Pepito", "Juanito", "Sutanito", "Perengano")
        pacientes = findViewById(R.id.spinner_nombre_paciente)
        val adaptador_pacientes =
            ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, nom_pacientes)
        pacientes.adapter = adaptador_pacientes

        pacientes.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                sel_paciente = pacientes.selectedItem.toString()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }
        }

        //Spinner ORIGEN
        val origenes = listOf<String>("Seleccione", "Estelar", "Dann", "Alcazares", "HPTU", "Cardiovascular", "San Vicente")
        origen = findViewById(R.id.spinner_origen)
        val adaptador_origen = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, origenes)
        origen.adapter = adaptador_origen

        origen.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                sel_origen = origen.selectedItem.toString()
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {

            }
        }

        //Spinner DESTINO
        val destinos = listOf<String>("Seleccione", "Estelar", "Dann", "Alcazares", "HPTU", "Cardiovascular", "San Vicente")
        destino = findViewById(R.id.spinner_destino)
        val adaptador_destino = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, destinos)
        destino.adapter = adaptador_destino

        destino.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                sel_destino = destino.selectedItem.toString()
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {

            }
        }

        //Spinner CONDUCTOR
        val conductores = listOf<String>("Seleccione", "Felipe Tamayo", "Evelio Marulanda")
        conductor = findViewById(R.id.spinner_conductor)
        val adaptador_conductor = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, conductores)
        conductor.adapter = adaptador_conductor

        conductor.onItemSelectedListener = object:
            AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                sel_conductor = conductor.selectedItem.toString()
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {

            }
        }

        btn_agendar = findViewById(R.id.button_agendar_cita)

        btn_agendar.setOnClickListener {

            val intent = Intent(this, CitasDIaActivity::class.java)
            intent.putExtra("Paciente","$sel_paciente")
            intent.putExtra("Origen", "$sel_origen")
            intent.putExtra("Destino", "$sel_destino")
            intent.putExtra("Conductor", "$sel_conductor")
            intent.putExtra("Hora", "$hora")

            array_pacientes.add(sel_paciente)
            intent.putExtra("Array", "$array_pacientes")
            //Cree el nuevo array

            startActivity(intent)
        }
    }

    private fun showTimePickerDialog() {
        val timePicker = TimePickerFragment {onTimeSelected(it)}
        timePicker.show(supportFragmentManager,"time")
    }

    private fun onTimeSelected(it: String) {
        hora = findViewById<EditText>(R.id.editTextTime).setText(it).toString()
    }
}