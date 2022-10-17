package com.example.datepickerdialog

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.textfield.TextInputLayout
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //REFERENCIAS ID
        val til_date = findViewById<TextInputLayout>(R.id.til_date)
        val til_time = findViewById<TextInputLayout>(R.id.til_time)


        val cal = Calendar.getInstance() //obtener instancia

        //creamos un listener para que realice una accion al seleccionar la fecha
        val listenerFecha = DatePickerDialog.OnDateSetListener { datePicker, anyo, mes, dia ->
            til_date.editText?.setText("$dia/$mes/$anyo")
        }
        //creamos un listener para que realice una accion al seleccionar la hora
        val listenerHora = TimePickerDialog.OnTimeSetListener { timePicker, hora, minuto ->
            til_time.editText?.setText("$hora:$minuto")
        }

        //{} en kotlin es formato lambda osea formato abreviado

        //CREAMOS EVENTO CLICK PARA EL DATEPICKER DIALOG
        til_date.editText?.setOnClickListener {
            //DatePickerDialog(this,null,2020,1,1)//(contexto,listener funcion que se lanzara al elegir ,la hora a mostrar ,año a mostrar,mes a mostrar,dia a mostrar)
            DatePickerDialog(this,listenerFecha,cal.get(Calendar.YEAR),cal.get(Calendar.MONTH),cal.get(Calendar.DAY_OF_MONTH)).show()
        }


        //CREAMOS EVENTO CLICK PARA EL TIMEPICKER DIALOG
        til_time.editText?.setOnClickListener {
            //DatePickerDialog(this,null,2020,1,1)//(contexto,listener funcion que se lanzara al elegir ,la hora a mostrar ,año a mostrar,mes a mostrar,dia a mostrar)
            TimePickerDialog(this,listenerHora,cal.get(Calendar.HOUR_OF_DAY),cal.get(Calendar.MINUTE),true).show()
        }

    }

    //RECORDAR ACTIVAR EL android:focusableInTouchMode="false" EN EL EDIT TEXT PARA EVITAR DOBLE CLICK
}