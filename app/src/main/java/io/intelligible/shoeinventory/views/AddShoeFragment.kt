package io.intelligible.shoeinventory.views

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import io.intelligible.shoeinventory.R
import io.intelligible.shoeinventory.databinding.AddShoeFragmentBinding
import io.intelligible.shoeinventory.model.ShoeModel
import io.intelligible.shoeinventory.viewmodel.SharedViewModel
import java.util.*

class AddShoeFragment: Fragment(R.layout.add_shoe_fragment) {

    lateinit var binding : AddShoeFragmentBinding
    private val viewModel  : SharedViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
       binding = AddShoeFragmentBinding.bind(view)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.model = viewModel
        binding.btnCancel.setOnClickListener {
            findNavController().popBackStack()
        }
    }


}