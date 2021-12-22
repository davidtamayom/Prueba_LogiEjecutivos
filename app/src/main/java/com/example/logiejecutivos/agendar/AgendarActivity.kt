package com.example.logiejecutivos.agendar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import com.example.logiejecutivos.R
import com.example.logiejecutivos.timepicker.TimePickerFragment

class AgendarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agendar)
        findViewById<EditText>(R.id.editTextTime).setOnClickListener{ showTimePickerDialog() }

    }

    private fun showTimePickerDialog() {
        val timePicker = TimePickerFragment {onTimeSelected(it)}
        timePicker.show(supportFragmentManager,"time")
    }

    private fun onTimeSelected(it: String) {
        findViewById<EditText>(R.id.editTextTime).setText(it)
    }
}