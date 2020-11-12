package com.example.tommybinding

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog

class Homecheck : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homecheck)


        val dialogBuilder = AlertDialog.Builder(this)

        // set message of alert dialog
        dialogBuilder.setMessage("Lorem Ipsum has been the industry’s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.")
            // if the dialog is cancelable
            .setCancelable(false)

            // positive button text and action
            .setPositiveButton("Aggre", DialogInterface.OnClickListener { dialog, id ->
                dialog.cancel()
            })
            // negative button text and action
            .setNegativeButton("Dis Agree", DialogInterface.OnClickListener { dialog, id ->
                finish()
            })

        // create dialog box
        val alert = dialogBuilder.create()
        // set title for alert dialog box
        alert.setTitle("Syarat dan Ketentuan")
        // show alert dialog
        alert.show()
    }

    fun btnsatu(view: View) {
        val i = Intent(this, FirstActivity::class.java)
        startActivity(i)
    }
    fun btndua(view: View) {
        val i = Intent(this, FirstActivity::class.java)
        startActivity(i)
    }
}