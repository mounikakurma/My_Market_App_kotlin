package com.example.mymarketapp

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.mymarketapp.databinding.FragmentWelcomeBinding

class WelcomeFragment : Fragment(R.layout.fragment_welcome) {

    private var _binding: FragmentWelcomeBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        _binding = FragmentWelcomeBinding.bind(view)

        binding.btnContinue.setOnClickListener {
            findNavController().navigate(R.id.action_welcome_to_login)
        }
    }
}
