package com.haz.eventplanning

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class RegisterActivity : AppCompatActivity() {
    private lateinit var textViewName: EditText
    private lateinit var textViewEmail: EditText
    private lateinit var redirectLogin:TextView
    private lateinit var textViewPassword : EditText
    private lateinit var buttonSignUp: Button
    private lateinit var mAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)


//        LINK THE VARIABLES BY ID
            textViewName = findViewById(R.id.mTvName)
            textViewEmail = findViewById(R.id.mTvEmail)
            textViewPassword = findViewById(R.id.mTvPassword)
            buttonSignUp = findViewById(R.id.mBtnLogin)
            redirectLogin = findViewById(R.id.mTvLogIn)


            //INITIALISE AUTHENTICATION
            mAuth = FirebaseAuth.getInstance()
            val intent = Intent(applicationContext, LoginActivity::class.java)
        startActivity(intent)

//        SET ACTIONS FOR THE BUTTONS
            buttonSignUp.setOnClickListener {
                signUpUser()
            }
        }
        private fun signUpUser() {
            val userName =textViewName.text.toString().trim()
            val userEmail = textViewEmail.text.toString().trim()
            val userPassword = textViewPassword.text.toString().trim()

            //CHECK FOR EMPTY FIELDS
            if (userName.isEmpty()){
                textViewName.setError("Please fill out this field")
               textViewName.requestFocus()
            }else if (userEmail.isEmpty()){
                textViewEmail.setError("Please fill out this input")
                textViewEmail.requestFocus()
            }else if (userPassword.isEmpty()){
                textViewPassword.setError("Please fill out this input")
                textViewPassword.requestFocus()
            }
            // If all credentials are correct
            // We call createUserWithEmailAndPassword
            // using authentication object and pass the
            // email and password through it.
            mAuth.createUserWithEmailAndPassword(userEmail, userPassword).addOnCompleteListener(this) {
                if (it.isSuccessful) {
                    Toast.makeText(this, "Successfully Signed Up", Toast.LENGTH_SHORT).show()

                } else {
                    Toast.makeText(this, "Sign Up Failed!", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }


