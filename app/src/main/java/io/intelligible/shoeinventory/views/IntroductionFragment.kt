package io.intelligible.shoeinventory.views

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import io.intelligible.shoeinventory.R
import io.intelligible.shoeinventory.databinding.IntroductionFragmentBinding


class IntroductionFragment : Fragment(R.layout.introduction_fragment) {
    lateinit var binding: IntroductionFragmentBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding= IntroductionFragmentBinding.bind(view)

        binding.btnNext.setOnClickListener {
            findNavController().navigate(R.id.action_introductionFragment_to_getStartedFragment2)
        }
    }

}