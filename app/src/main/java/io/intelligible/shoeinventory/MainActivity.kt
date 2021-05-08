package io.intelligible.shoeinventory

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import io.intelligible.shoeinventory.viewmodel.SharedViewModel

class MainActivity : AppCompatActivity() {

    val viewModel : SharedViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment)
        val navController = navHostFragment?.findNavController()


        setupActionBarWithNavController(navController!!)
        navController.addOnDestinationChangedListener { controller, destination, arguments ->
            if (destination.id == R.id.shoeListFragment || destination.id == R.id.addShoeFragment){
                supportActionBar!!.show()
            }else{
                supportActionBar!!.hide()
            }

        }
    }
}