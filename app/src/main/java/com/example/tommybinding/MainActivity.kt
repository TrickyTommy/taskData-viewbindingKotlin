package com.example.tommybinding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.CheckBox
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private val SPLASH_TIME_OUT =
        3000L
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Handler().postDelayed(
            {
                val i = Intent(this@MainActivity, HomeActivity::class.java)
                startActivity(i)
                finish()
                onDestroy()
            }, SPLASH_TIME_OUT)
        val checkBox = findViewById<CheckBox>(R.id.checkBox)
        checkBox?.setOnCheckedChangeListener { buttonView, isChecked ->
            val msg = "You have " + (if (isChecked) "checked" else "unchecked") + " this Check it Checkbox."
            Toast.makeText(this@MainActivity, msg, Toast.LENGTH_SHORT).show()
        }
    }
}