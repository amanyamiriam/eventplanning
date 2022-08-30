package com.haz.eventplanning

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var textViewEvent:TextView
    lateinit var buttonWelcome:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buttonWelcome = findViewById(R.id.mBtnWelcome)
        textViewEvent = findViewById(R.id.mTvEvent)

        buttonWelcome.setOnClickListener {
            Toast.makeText(
                applicationContext, "",
                Toast.LENGTH_LONG).show()
            val intent = Intent(applicationContext, RegisterActivity::class.java)
            startActivity(intent)
        }

    }
}