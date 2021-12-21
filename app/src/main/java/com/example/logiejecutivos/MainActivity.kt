package com.example.logiejecutivos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import com.example.logiejecutivos.timepicker.TimePickerFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
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