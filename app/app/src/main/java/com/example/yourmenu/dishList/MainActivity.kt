package com.example.yourmenu.dishList

import android.os.Bundle
import android.view.*
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.yourmenu.R
import com.example.yourmenu.database.ViewModel

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        // Setting up the list view of dishes
        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1)
        val listView: ListView = findViewById(R.id.list_dish)
        listView.adapter = adapter

        // Instanciating the viewModel and retrieving the datas
        viewModel = ViewModelProvider(this).get(ViewModel::class.java)
        viewModel.localDishes.observe(this, Observer { dish -> run {
            adapter.clear() // TODO make it more clean
            dish?.let { it.forEach {item -> adapter.add(item.name)} }
        }
        })

        // Click on the "+" button
        fab.setOnClickListener {

            val popUp = PopupMenu(this@MainActivity, fab)
            popUp.menuInflater.inflate(R.menu.menu_create_dish, popUp.menu)
            // provisioning the menu with the different options from remote datas
            viewModel.remoteDishes.observe(this, Observer { options ->
                options.forEach { item -> popUp.menu.add( item.name )}
            })
            popUp.setOnMenuItemClickListener { clickedItem ->
                viewModel.remoteDishes.observe(this, Observer {dishList ->
                    dishList.forEach { item -> if (item.name == clickedItem.toString()) {viewModel.insertDish(item); return@forEach}}
                })
                true
            }
            popUp.show()
        }
    }

    // TODO : to be correctly implemented
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
