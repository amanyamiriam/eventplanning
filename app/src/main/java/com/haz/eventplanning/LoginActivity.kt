package com.haz.eventplanning

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {

     lateinit var tvRedirectSignUp: TextView
    lateinit var  textViewEmail: EditText
     lateinit var textViewPassword: EditText
    lateinit var buttonLogin: Button

    // Creating firebaseAuth object
    lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // View Binding
        tvRedirectSignUp = findViewById(R.id.mTvLogIn)
        buttonLogin = findViewById(R.id.mBtnLogin)
        textViewEmail = findViewById(R.id.mTvEmail)
        textViewPassword = findViewById(R.id.mTvPassword)

        // initialising Firebase auth object
        auth = FirebaseAuth.getInstance()

        buttonLogin.setOnClickListener {
            login()
            Toast.makeText(applicationContext,"Login successfull",
                Toast.LENGTH_LONG).show()
        }

        tvRedirectSignUp.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)

            // using finish() to end the activity
            finish()
        }
    }

    private fun login() {
        val email = textViewEmail.text.toString()
        val pass = textViewPassword.text.toString()
        // calling signInWithEmailAndPassword(email, pass)
        // function using Firebase auth object
        // On successful response Display a Toast
        auth.signInWithEmailAndPassword(email, pass).addOnCompleteListener(this) {
            if (it.isSuccessful) {
                Toast.makeText(this, "Successfully LoggedIn", Toast.LENGTH_SHORT).show()
                val intent= Intent(this,DashboardActivity::class.java)
                startActivity(intent)

            } else
                Toast.makeText(this, "Log In failed ", Toast.LENGTH_SHORT).show()
        }
    }

}