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
    val viewModel  : SharedViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
       binding = AddShoeFragmentBinding.bind(view)


        binding.btnAdd.setOnClickListener {
            addShoeToList()
        }

        binding.btnCancel.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun addShoeToList() {
        if (binding.etDesc.text.toString().isEmpty() or
                binding.etShoeCompany.text.toString().isEmpty() or
                binding.etShoeSize.text.toString().isEmpty()  or
                binding.etShoeme.text.toString().isEmpty() ){
            Toast.makeText(requireContext(), "Please Fill All Fields", Toast.LENGTH_SHORT).show()
        }else{
         viewModel.shoelist.add(
             ShoeModel(
                 shoeId = UUID.randomUUID().toString(),
                 shoeName = binding.etShoeme.text.toString(),
                 company = binding.etShoeCompany.text.toString(),
                 shoeSize = binding.etShoeSize.text.toString(),
                 shoeDescription = binding.etDesc.text.toString()
             )
         )

            Toast.makeText(requireContext(), "Shoe Added Successfully", Toast.LENGTH_SHORT).show()
        }

    }
}