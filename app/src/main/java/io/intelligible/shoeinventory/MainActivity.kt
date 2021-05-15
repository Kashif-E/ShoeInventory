package io.intelligible.shoeinventory

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import io.intelligible.shoeinventory.databinding.ActivityMainBinding
import io.intelligible.shoeinventory.viewmodel.SharedViewModel

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
   val viewModel : SharedViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment)
        val navController = navHostFragment?.findNavController()



        val appBarConfiguration = AppBarConfiguration(navController!!.graph)


        setupActionBarWithNavController(navController!!, appBarConfiguration)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        navController.addOnDestinationChangedListener { _, destination, _ ->
            if (destination.id == R.id.shoeListFragment || destination.id == R.id.addShoeFragment){
                supportActionBar!!.show()
            }else{
                supportActionBar!!.hide()
            }

        }
    }
}