package com.haz.eventplanning

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.firebase.database.FirebaseDatabase

class ViewActivity : AppCompatActivity() {

    lateinit var editTextName: EditText
    lateinit var editTextEmail: EditText
    lateinit var editTextIdNumber: EditText
    lateinit var buttonSave: Button
    lateinit var buttonView: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view)

        editTextName = findViewById(R.id.mEdtName)
        editTextEmail = findViewById(R.id.mEdtEmail)
        editTextIdNumber = findViewById(R.id.mEdtIdNumber)
        buttonSave = findViewById(R.id.mBtnSave)
        buttonView = findViewById(R.id.mBtnView)
        buttonSave!!.setOnClickListener {
            val  userName = editTextName!!.text.toString().trim()
            val  userEmail = editTextEmail!!.text.toString().trim()
            val  userIdNumber = editTextIdNumber!!.text.toString().trim()
            val id =System.currentTimeMillis().toString()
            //Check if the user has submitted empty fields
            if (userName.isEmpty()){
                editTextName!!.setError("Please fill the fields!!!")
                editTextName!!.requestFocus()
            }else if (userEmail.isEmpty()){
                editTextEmail!!.setError("Please fill the fields!!!")
                editTextEmail!!.requestFocus()
            }else if (userIdNumber.isEmpty()){
                editTextIdNumber!!.setError("Please fill the fields!!!")
                editTextIdNumber!!.requestFocus()
            }else{
                //proceed to save data
                //start by creating the user object
                val userData = User(userName,userEmail,userIdNumber,id)
                //create a reference to the database to restore data
                val reference = FirebaseDatabase.getInstance().getReference().child("users/$id")
                //Start saving userData
                reference.setValue(userData).addOnCompleteListener {
                        task->
                    if (task.isSuccessful ){
                        Toast.makeText(applicationContext,"Data saved successfully",
                            Toast.LENGTH_LONG).show()
                    }else{
                        Toast.makeText(applicationContext,"Data saving failed",
                            Toast.LENGTH_LONG).show()
                    }
                }
            }

        }
        buttonView!!.setOnClickListener {
            val goToUsers = Intent(applicationContext,ListActivity::class.java)
            startActivity(goToUsers)

        }

    }
}