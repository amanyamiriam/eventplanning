package com.haz.eventplanning

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView

class ShoppingListActivity : AppCompatActivity() {
    lateinit var textViewShoppinglist: TextView
    lateinit var editTextName: EditText
    lateinit var editTextUnits: EditText
    lateinit var editTextPrice: EditText
    lateinit var editTextTotalquantity: EditText
    lateinit var editTextDescription: EditText
    lateinit var checkBoxPurchesed: CheckBox
    lateinit var buttonSave: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping_list)

        textViewShoppinglist = findViewById(R.id.mTvShoppingList)
        editTextName = findViewById(R.id.eName)
        editTextUnits = findViewById(R.id.mEdtUnits)
        editTextPrice = findViewById(R.id.mEdtPrice)
        editTextTotalquantity = findViewById(R.id.mEdtQuantity)
        editTextDescription = findViewById(R.id.medtdescription)
        checkBoxPurchesed = findViewById(R.id.mcheckBox)
        buttonSave = findViewById(R.id.bsave)


        textViewShoppinglist.setOnClickListener {
            var goToEvents = Intent(applicationContext,ShoppingListActivity::class.java)
            startActivity(goToEvents)
        }
        editTextName.setOnClickListener {
            var goToName = Intent(applicationContext,ShoppingListActivity::class.java)
            startActivity(goToName)
        }
        editTextUnits.setOnClickListener {
            var goToUnits = Intent(applicationContext,ShoppingListActivity::class.java)
            startActivity(goToUnits)
        }
        editTextPrice.setOnClickListener {
            var goToPrice= Intent(applicationContext,ShoppingListActivity::class.java)
            startActivity(goToPrice)
        }
        editTextTotalquantity.setOnClickListener {
            var goToQuantity= Intent(applicationContext,ShoppingListActivity::class.java)
            startActivity(goToQuantity)
        }

        editTextDescription.setOnClickListener {
            var goToDescription = Intent(applicationContext,ShoppingListActivity::class.java)
            startActivity(goToDescription)
        }
        buttonSave.setOnClickListener {
            var goToSave = Intent(applicationContext,ShoppingListActivity::class.java)
            startActivity(goToSave)


        }
    }

}

