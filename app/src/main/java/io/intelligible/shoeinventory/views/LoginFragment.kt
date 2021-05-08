package io.intelligible.shoeinventory.views

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import io.intelligible.shoeinventory.R
import io.intelligible.shoeinventory.databinding.LoginFragmentBinding
import io.intelligible.shoeinventory.exensions.isEmpty

class LoginFragment : Fragment(R.layout.login_fragment) {

    lateinit var binding : LoginFragmentBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = LoginFragmentBinding.bind(view)

        binding.btnLogin.setOnClickListener {
            if (binding.textInputLayout.isEmpty().not() && binding.textInputLayout2.isEmpty().not()){
                findNavController().navigate(R.id.action_loginFragment_to_shoeListFragment)
            }else{
                if (binding.textInputLayout2.isEmpty()) binding.textInputLayout2.error = "Password Is Required"
                if (binding.textInputLayout.isEmpty()) binding.textInputLayout.error = "Email Is Required"

            }

        }

    }
}