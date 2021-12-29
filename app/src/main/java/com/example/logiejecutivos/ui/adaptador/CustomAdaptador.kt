package com.example.logiejecutivos.ui.adaptador

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.logiejecutivos.R


class CustomAdaptador: RecyclerView.Adapter<CustomAdaptador.ViewHolder>(){

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        var itemPaciente: TextView
        var itemOrigen: TextView
        var itemDestino: TextView
        var itemConductor: TextView

        init{
            itemPaciente = itemView.findViewById(R.id.nombre_paciente)
            itemOrigen = itemView.findViewById(R.id.ruta_paciente_origen)
            itemDestino = itemView.findViewById(R.id.ruta_paciente_destino)
            itemConductor = itemView.findViewById(R.id.nombre_conductor)
        }
    }

    val array_pacientes = arrayOf("Pedro", "Juan", "Ana")
    val array_origen = arrayOf("HTPU", "Alcazares", "San Vicente")
    val array_destino = arrayOf("Dann", "Cardiovascular", "Hilton")
    val array_conductor = arrayOf("Felipe Tamayo", "Evelio Marulanda","Felipe Tamayo")


    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context).inflate(R.layout.card_layout, viewGroup, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.itemPaciente.text = array_pacientes[i]
        viewHolder.itemOrigen.text = array_origen[i]
        viewHolder.itemDestino.text = array_destino[i]
        viewHolder.itemConductor.text = array_conductor[i]
    }

    override fun getItemCount(): Int {
        return array_pacientes.size
    }
}

