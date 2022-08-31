package com.haz.eventplanning

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.TextView
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class IntentActivity : AppCompatActivity() {
    lateinit var textViewContactus: TextView
    lateinit var buttonCall: Button
    lateinit var buttonSms: Button
    lateinit var buttonEmail: Button
    lateinit var buttonShare: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent)
        textViewContactus = findViewById(R.id.mcontact)
        buttonSms = findViewById(R.id.mBtnSms)
        buttonCall= findViewById(R.id.mBtnCall)
        buttonEmail = findViewById(R.id.mBtnEmail)
        buttonShare = findViewById(R.id.mBtnShare)

        buttonSms.setOnClickListener {
            val uri: Uri = Uri.parse("smsto:YOUR_SMS_NUMBER")
            val intent = Intent(Intent.ACTION_SENDTO, uri)
            intent.putExtra("sms_body", "Hello There")
            startActivity(intent)
        }
        buttonEmail.setOnClickListener {
            val emailIntent =
                Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", "abc@gmail.com", null))
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Job Application")
            emailIntent.putExtra(Intent.EXTRA_TEXT, "Dear sir with regards to...")
            startActivity(Intent.createChooser(emailIntent, "Send email..."))
        }

        buttonShare.setOnClickListener {
            val shareIntent = Intent(Intent.ACTION_SEND)
            shareIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            shareIntent.type = "text/plain"
            shareIntent.putExtra(Intent.EXTRA_TEXT, "Hey, download this app!")
            startActivity(shareIntent)
        }

        buttonCall.setOnClickListener {
            val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "+254114743613"))
            if (ContextCompat.checkSelfPermission(
                    this@IntentActivity,
                    Manifest.permission.CALL_PHONE
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                ActivityCompat.requestPermissions(
                    this@IntentActivity,
                    arrayOf(Manifest.permission.CALL_PHONE),
                    1
                )
            } else {
                startActivity(intent)
            }
        }


    }
}