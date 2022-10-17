package com.example.roomdatabase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import kotlinx.coroutines.launch
import roomDatabase.Db

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //INICIALIZAMOS LA DB
        val room = Room.databaseBuilder(this,Db::class.java,"database-ciisa").allowMainThreadQueries().build()

        //REFERENCIAS WIDGETS
        val til_user = findViewById<TextInputLayout>(R.id.til_user)
        val til_pass = findViewById<TextInputLayout>(R.id.til_pass)
        val btn_login = findViewById<Button>(R.id.btn_login)
        val btn_register = findViewById<Button>(R.id.btn_register)

        btn_login.setOnClickListener {
            val user = til_user.editText?.text.toString()
            val pass = til_pass.editText?.text.toString()

            lifecycleScope.launch{
                val response = room.daoUsuario().login(user,pass)
                //val response = room.daoUsuario().obtenerUsuario()
                if(response.size == 1) Toast.makeText(this@MainActivity,"Login exitosovzaoat",Toast.LENGTH_LONG).show() else Toast.makeText(this@MainActivity,"Login fallido",Toast.LENGTH_LONG).show()

            }
        }

        btn_register.setOnClickListener {
            val intent = Intent(this@MainActivity,RegistrarUsuario::class.java)
            startActivity(intent)
        }


    }
}