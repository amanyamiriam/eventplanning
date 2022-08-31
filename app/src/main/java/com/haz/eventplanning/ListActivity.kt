package com.haz.eventplanning

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class ListActivity : AppCompatActivity() {

    lateinit var listUsers: ListView
    lateinit var adapter:CustomAdapter
    lateinit var users:ArrayList<User>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        listUsers = findViewById(R.id.mlist)
        users = ArrayList()
        adapter = CustomAdapter(this,users)
        //Connect to the users table/child to fetch data
        val reference = FirebaseDatabase.getInstance().getReference().child("Users")
        //start fetching the data
        reference.addValueEventListener(object : ValueEventListener {
            //override fun on data changed
            override fun onDataChange(snapshot: DataSnapshot) {
                users.clear()
                //use for loop to add the users on the arraylist
                for (snap in snapshot.children) {
                    var user = snap.getValue(User::class.java)
                    users.add(user!!)
                }
                adapter.notifyDataSetChanged()
            }
            //Override the on cancelled method
            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(applicationContext,"Please contact the admin",
                    Toast.LENGTH_LONG).show()
            }
        })
        listUsers.adapter = adapter
        //set on item click listener to the listview
        listUsers.setOnItemClickListener { adapterView, view, i, l ->
            val userId = users.get(i).id
            val deletionReference = FirebaseDatabase.getInstance().
            getReference().child("Users/$userId")
            //set an alert when someone clicks on an item
            val alertDialog = AlertDialog.Builder(this)
            alertDialog.setTitle("ALERT!!!")
            alertDialog.setMessage("Select an option you want to perform")
            alertDialog.setNegativeButton("Update", DialogInterface.OnClickListener{ dialogInterface, i ->
                //Dismiss the alert
            })
            alertDialog.setPositiveButton("Delete", DialogInterface.OnClickListener { dialogInterface, i ->
                reference.removeValue()
                Toast.makeText(applicationContext,"Deleted successfully",
                    Toast.LENGTH_LONG).show()
            })
            alertDialog.create().show()
        }
    }
}