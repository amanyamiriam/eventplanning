package com.haz.eventplanning

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView

class GuestActivity : AppCompatActivity() {
    lateinit var textViewGuest: TextView
    lateinit var editTextName: EditText
    lateinit var editTextGender: EditText
    lateinit var editTextAge: EditText
    lateinit var editTextEmail: EditText
    lateinit var editTextDescription: EditText
    lateinit var checkBoxInvited: CheckBox
    lateinit var buttonSave: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guest)

        textViewGuest = findViewById(R.id.mGuests)
        editTextName = findViewById(R.id.mName)
        editTextGender = findViewById(R.id.mEdtGender)
        editTextAge = findViewById(R.id.mEdtAge)
        editTextEmail = findViewById(R.id.mEdtEmail)
        editTextDescription = findViewById(R.id.mDescription)
        checkBoxInvited = findViewById(R.id.mCheckBox)
        buttonSave = findViewById(R.id.BtnSave)

        textViewGuest.setOnClickListener {
            var goToGuest = Intent(applicationContext,GuestActivity::class.java)
            startActivity(goToGuest)
        }

        editTextName.setOnClickListener {
            var goToName = Intent(applicationContext,GuestActivity::class.java)
            startActivity(goToName)
        }

        editTextGender.setOnClickListener {
            var goToGender = Intent(applicationContext,GuestActivity::class.java)
            startActivity(goToGender)
        }
        editTextAge.setOnClickListener {
            var goToAge = Intent(applicationContext,GuestActivity::class.java)
            startActivity(goToAge)
        }
        editTextEmail.setOnClickListener {
            var goToEmail = Intent(applicationContext,GuestActivity::class.java)
            startActivity(goToEmail)
        }
        editTextDescription.setOnClickListener {
            var goToDescription = Intent(applicationContext,GuestActivity::class.java)
            startActivity(goToDescription)
        }
        checkBoxInvited.setOnClickListener {
            var goToCheckBox = Intent(applicationContext,GuestActivity::class.java)
            startActivity(goToCheckBox)
        }
        buttonSave.setOnClickListener {
            var goToSave = Intent(applicationContext,GuestActivity::class.java)
            startActivity(goToSave)


        }
    }
}