package io.intelligible.shoeinventory.views

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import io.intelligible.shoeinventory.R
import io.intelligible.shoeinventory.adapter.ShoeRecyclerViewAdapter
import io.intelligible.shoeinventory.databinding.FragmentShoeListBinding
import io.intelligible.shoeinventory.viewmodel.SharedViewModel

class ShoeListFragment: Fragment(R.layout.fragment_shoe_list) {

    lateinit var binding : FragmentShoeListBinding
    lateinit var shoeAdapter: ShoeRecyclerViewAdapter
    private val viewModel : SharedViewModel by activityViewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentShoeListBinding.bind(view)

        setupRecyclerView()
        binding.floatingActionButton.setOnClickListener {
            findNavController().navigate(R.id.action_shoeListFragment_to_addShoeFragment)
        }


        setHasOptionsMenu(true)

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return findNavController().navigateUp()
                || super.onOptionsItemSelected(item)
    }

    private fun setupRecyclerView() {
        shoeAdapter = ShoeRecyclerViewAdapter().apply {
            differ.submitList(viewModel.shoelist)
        }
        binding.rvShoeList.adapter = shoeAdapter
    }
}