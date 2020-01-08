package com.example.yourmenu

import android.os.Bundle
import android.view.*
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        // Control of the button // to be deleted
        val editButton: Button = findViewById(R.id.edit_dish_row)
        editButton.setOnClickListener { displayMenu() }

        // Control to display a menu on a long touch
        val dishTitle: TextView = findViewById((R.id.dish_title))
        registerForContextMenu(dishTitle) // Indicate that this View can display a ContextMenu

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }
    
    // function called when the ContextMenu is called
    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu_dish, menu)
    }

    // function called when a item of the menu is selected
    override fun onContextItemSelected(item: MenuItem): Boolean {
        Toast.makeText(this, "button clicked", Toast.LENGTH_SHORT).show()
        return super.onContextItemSelected(item)
    }

    // function controlling the button behavior
    private fun displayMenu() {
        Toast.makeText(this, "button clicked", Toast.LENGTH_SHORT).show()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
