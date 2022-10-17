package com.example.roomdatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import kotlinx.coroutines.launch
import roomDatabase.Db
import roomDatabase.entity.Usuario

class RegistrarUsuario : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrar_usuario)
        //INICIALIZAMOS LA DB
        val room = Room.databaseBuilder(this, Db::class.java,"database-ciisa").allowMainThreadQueries().build()

        val  til_ruser = findViewById<TextInputLayout>(R.id.til_ruser)
        val  til_rname = findViewById<TextInputLayout>(R.id.til_rname)
        val  til_rpass = findViewById<TextInputLayout>(R.id.til_rpass)
        val  btn_rregister = findViewById<Button>(R.id.btn_rregister)
        btn_rregister.setOnClickListener {
            val user = til_ruser.editText?.text.toString()
            val pass = til_rpass.editText?.text.toString()
            val name = til_rname.editText?.text.toString()
            //INSERTAMS LA INFORMACION
            val usuario = Usuario(name,user,pass)
            lifecycleScope.launch{
                val id = room.daoUsuario().agregarUsuario(usuario)
                if(id>0){
                    Log.d("IDuser",id.toString())
                    Toast.makeText(this@RegistrarUsuario,"Usuario registrado exitosamente",Toast.LENGTH_LONG)
                }
            }
        }
    }
}