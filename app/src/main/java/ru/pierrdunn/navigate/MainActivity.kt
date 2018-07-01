package ru.pierrdunn.navigate

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.navigation.NavAction
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), NavController.OnNavigatedListener {

    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        navController = Navigation.findNavController(this, R.id.nav_host_fragment)
        navController.addOnNavigatedListener(this)

    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.getItemId()) {
            android.R.id.home-> {

                if (!navController.popBackStack()) onBackPressed()

                return true
            }
        }

        return super.onOptionsItemSelected(item)
    }

    override fun onNavigated(controller: NavController, destination: NavDestination) {
        println(destination.label)
        supportActionBar?.title = destination.label
    }


}
