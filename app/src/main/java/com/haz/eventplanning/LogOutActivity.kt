package com.haz.eventplanning

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class LogOutActivity : AppCompatActivity() {
    lateinit var buttonLogOut:Button
    lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_out)
        // initialising Firebase auth object
        auth = FirebaseAuth.getInstance()


        buttonLogOut = findViewById(R.id.mBtnLogOut)

        buttonLogOut.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            Toast.makeText(
                applicationContext, "Log Out Successfull",
                Toast.LENGTH_LONG).show()
            val intent = Intent(applicationContext, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}