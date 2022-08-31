package com.haz.eventplanning

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView

class TodolistActivity : AppCompatActivity() {
    lateinit var textViewTodolist: TextView
    lateinit var editTextTask: EditText
    lateinit var editTextDescription: EditText
    lateinit var checkBoxCompleted: CheckBox
    lateinit var buttonSave: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todolist)

        textViewTodolist = findViewById(R.id.mToDoList)
        editTextTask = findViewById(R.id.mEdtTask)
        editTextDescription = findViewById(R.id.edtDescription)
        checkBoxCompleted = findViewById(R.id.mcheckbox)
        buttonSave = findViewById(R.id.btnSave)

        textViewTodolist.setOnClickListener {
            var goToTodolist = Intent(applicationContext,TodolistActivity::class.java)
            startActivity(goToTodolist)
        }
        editTextTask.setOnClickListener {
            var goToTask = Intent(applicationContext,TodolistActivity::class.java)
            startActivity(goToTask)
        }
        editTextDescription.setOnClickListener {
            var goToDescription = Intent(applicationContext,TodolistActivity::class.java)
            startActivity(goToDescription)
        }

        buttonSave.setOnClickListener {
            var goToSave = Intent(applicationContext,TodolistActivity::class.java)
            startActivity(goToSave)

        }

    }

}