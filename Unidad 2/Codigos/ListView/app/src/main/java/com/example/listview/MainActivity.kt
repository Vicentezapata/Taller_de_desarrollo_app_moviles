package com.example.listview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // access the listView from xml file
        var lv_datos = findViewById<ListView>(R.id.lv_datos)

        // use arrayadapter and define an array
        //Siempre acepta un Array o una Lista como entrada. Podemos almacenar los elementos de la lista en el archivo strings.xml también
        val arrayAdapter: ArrayAdapter<*>
        val recetas = arrayOf("Receta 1", "Receta 2", "Receta 3", "Receta 4", "Receta 5")
        arrayAdapter = ArrayAdapter(this,android.R.layout.simple_list_item_1, recetas)
        //PODEMOS CREAR UN XML PERSONALIZADO
        //arrayAdapter = ArrayAdapter(this,R.layout.elemento_de_lista, recetas)
        lv_datos.adapter = arrayAdapter

        lv_datos.onItemClickListener = object : AdapterView.OnItemClickListener{
            override fun onItemClick(p0: AdapterView<*>?, view: View?, position: Int, id: Long) {
                Toast.makeText(this@MainActivity,"Escogido ${recetas[position]}",Toast.LENGTH_LONG).show()
            }
        }
    }
}