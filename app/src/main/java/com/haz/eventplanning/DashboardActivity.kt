package com.haz.eventplanning

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SearchView
import android.widget.TextView
import androidx.cardview.widget.CardView

class DashboardActivity : AppCompatActivity() {
    lateinit var searchView: SearchView
    lateinit var cardViewEvents: CardView
    lateinit var cardViewGuests: CardView
    lateinit var cardViewShoppinglist: CardView
    lateinit var cardViewTodolist: CardView
    lateinit var cardViewExit: CardView
    lateinit var cardViewLogout: CardView
    lateinit var cardViewContactUs: CardView
    lateinit var cardViewPeople: CardView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        searchView = findViewById(R.id.mSearchview)
        cardViewEvents = findViewById(R.id.card_events)
        cardViewGuests = findViewById(R.id.card_guest)
        cardViewShoppinglist = findViewById(R.id.card_shoppinglist)
        cardViewTodolist = findViewById(R.id.card_todolist)
        cardViewExit = findViewById(R.id.card_exit)
        cardViewLogout = findViewById(R.id.card_logout)
        cardViewContactUs = findViewById(R.id.card_contactus)
        cardViewPeople= findViewById(R.id.card_people)



        searchView.setOnClickListener {
            var goToSearchview = Intent(applicationContext,DashboardActivity::class.java)
            startActivity(goToSearchview)
        }
        cardViewEvents.setOnClickListener {
            var goToCardViewEvents = Intent(applicationContext,EventsActivity::class.java)
            startActivity(goToCardViewEvents)
        }
        cardViewGuests.setOnClickListener {
            var goToCardViewGuests = Intent(applicationContext,GuestActivity::class.java)
            startActivity(goToCardViewGuests)
        }
        cardViewShoppinglist.setOnClickListener {
            var goToCardViewShoppingList = Intent(applicationContext,ShoppingListActivity::class.java)
            startActivity(goToCardViewShoppingList)
        }
        cardViewTodolist.setOnClickListener {
            var goToCardViewTodolist = Intent(applicationContext,TodolistActivity::class.java)
            startActivity(goToCardViewTodolist)
        }
        cardViewExit.setOnClickListener {
            finish()
        }
        cardViewLogout.setOnClickListener {
            var goToCardViewLogout = Intent(applicationContext,LogOutActivity::class.java)
            startActivity(goToCardViewLogout)

        }
        cardViewContactUs.setOnClickListener {
            var goToCardViewContactus = Intent(applicationContext,IntentActivity::class.java)
            startActivity(goToCardViewContactus)

        }
        cardViewPeople.setOnClickListener {
            var goToCardViewPeople = Intent(applicationContext,IntentActivity::class.java)
            startActivity(goToCardViewPeople)

        }
    }
}