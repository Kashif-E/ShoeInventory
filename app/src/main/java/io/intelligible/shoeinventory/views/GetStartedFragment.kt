package io.intelligible.shoeinventory.views

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import io.intelligible.shoeinventory.R
import io.intelligible.shoeinventory.databinding.GetstartedFragmentBinding

class GetStartedFragment: Fragment(R.layout.getstarted_fragment) {
    lateinit var binding : GetstartedFragmentBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = GetstartedFragmentBinding.bind(view)

        binding.btnGetStarted.setOnClickListener {
            findNavController().navigate(R.id.action_getStartedFragment_to_loginFragment)
        }

    }
}