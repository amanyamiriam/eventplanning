package com.haz.eventplanning

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class ExitActivity : AppCompatActivity() {
    lateinit var buttonExit : Button
    lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exit)
        buttonExit = findViewById(R.id.mBtnExit)
        // initialising Firebase auth object
        auth = FirebaseAuth.getInstance()

        buttonExit.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            Toast.makeText(
                applicationContext, "",
                Toast.LENGTH_LONG).show()
            val intent = Intent(applicationContext, LoginActivity::class.java)
            startActivity(intent)

        }
    }
}