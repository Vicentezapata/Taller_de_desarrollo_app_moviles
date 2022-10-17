package com.example.alertdialog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn_delete = findViewById<Button>(R.id.btn_delete)
        btn_delete.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Confirmacion")
            builder.setMessage("Estas seguro que deseas eliminar?")
            builder.setPositiveButton(android.R.string.ok){//GENERAMOS BOTON POSITIVO
                    dialog,
                    //ACCION A REALIZAR
                    wich-> Toast.makeText(this,"Elemento Eliminado",Toast.LENGTH_LONG).show()
            }
            builder.setNegativeButton("Cancelar",null)
            builder.setNeutralButton("No estoy muy seguro",null)
            builder.show()
        }
    }
}