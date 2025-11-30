package com.example.mymarketapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.mymarketapp.databinding.FragmentWelcomeBinding

class WelcomeFragment : Fragment() {

    private lateinit var binding: FragmentWelcomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentWelcomeBinding.inflate(inflater, container, false)

        // Navigate to Login Fragment
        binding.btnLogin.setOnClickListener { view ->
            view.findNavController().navigate(R.id.action_welcomeFragment_to_loginFragment)
        }

        // Navigate to Signup Fragment
        binding.btnSignUp.setOnClickListener { view ->
            view.findNavController().navigate(R.id.action_welcomeFragment_to_signupFragment)
        }

        return binding.root
    }
}
