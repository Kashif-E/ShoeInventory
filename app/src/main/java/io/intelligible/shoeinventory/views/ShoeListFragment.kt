package io.intelligible.shoeinventory.views

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import io.intelligible.shoeinventory.R

import io.intelligible.shoeinventory.databinding.FragmentShoeListBinding
import io.intelligible.shoeinventory.databinding.HolderShoeDetailsBinding
import io.intelligible.shoeinventory.viewmodel.SharedViewModel

class ShoeListFragment: Fragment(R.layout.fragment_shoe_list) {

    lateinit var binding : FragmentShoeListBinding
    private val viewModel : SharedViewModel by activityViewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentShoeListBinding.bind(view)


        binding.floatingActionButton.setOnClickListener {
            findNavController().navigate(R.id.action_shoeListFragment_to_addShoeFragment)
        }


        observeMutables()
        setHasOptionsMenu(true)

    }

    private fun observeMutables() {

         viewModel.shoelist.forEach {
                val view = HolderShoeDetailsBinding.inflate(layoutInflater)
                view.shoename.text = it.shoeName
                view.company.text = it.company
                view.shoeSize.text = it.shoeSize
                view.descrip.text = it.shoeDescription
                binding.shoesListLayout.addView(view.root)
            }

        }




    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return findNavController().navigateUp()
                || super.onOptionsItemSelected(item)
    }


}