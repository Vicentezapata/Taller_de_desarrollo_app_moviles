package com.example.miprimeraapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        val delaey:Long = 6000
        Handler(this.mainLooper).postDelayed({
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        },delaey)
    }
}