package com.example.tommybinding

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.CheckBox
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    private val SPLASH_TIME_OUT =
        3000L
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Handler().postDelayed(
                {
                    val i = Intent(this@MainActivity, Homecheck::class.java)
                    startActivity(i)
                    finish()
                }, SPLASH_TIME_OUT)






    }
}