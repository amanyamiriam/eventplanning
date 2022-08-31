package com.haz.eventplanning

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class EventsActivity : AppCompatActivity() {
    lateinit var textViewEvent: TextView
    lateinit var editTextName: EditText
    lateinit var editTextLocation: EditText
    lateinit var editTextDate: EditText
    lateinit var editTextDescription: EditText
    lateinit var buttonSave: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_events)
        textViewEvent = findViewById(R.id.mEvents)
        editTextName = findViewById(R.id.mEdtName)
        editTextLocation = findViewById(R.id.mEdtLocation)
        editTextDate = findViewById(R.id.mEdtDate)
        editTextDescription = findViewById(R.id.mEdtDescription)
        buttonSave = findViewById(R.id.mBtnSave)

        textViewEvent.setOnClickListener {
            var goToEvents = Intent(applicationContext,EventsActivity::class.java)
            startActivity(goToEvents)
        }
        editTextName.setOnClickListener {
            var goToName = Intent(applicationContext,EventsActivity::class.java)
            startActivity(goToName)
        }
        editTextLocation.setOnClickListener {
            var goToLocation = Intent(applicationContext,EventsActivity::class.java)
            startActivity(goToLocation)
        }
        editTextDate!!.setOnClickListener {
            var goToDate = Intent(applicationContext,EventsActivity::class.java)
            startActivity(goToDate)
        }
        editTextDescription.setOnClickListener {
            var goToDescription = Intent(applicationContext,EventsActivity::class.java)
            startActivity(goToDescription)
        }
        buttonSave.setOnClickListener {
            var goToSave = Intent(applicationContext,EventsActivity::class.java)
            startActivity(goToSave)

        }
    }

}
