package com.example.mymarketapp.view.login

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.mymarketapp.R
import com.example.mymarketapp.databinding.FragmentLoginBinding
import com.example.mymarketapp.view.dashboard.activity.DashboardActivity

class LoginFragment : Fragment(R.layout.fragment_login) {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentLoginBinding.bind(view)

        binding.btnLogin.setOnClickListener {
            validateUserInput()
        }
    }

    private fun validateUserInput() {
        val email = binding.etEmail.text.toString().trim()
        val password = binding.etPassword.text.toString().trim()


        if (email.isEmpty()) {
            binding.emailErrorTV.apply {
                visibility = View.VISIBLE
                text = "Email is required"
            }
            return
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            binding.emailErrorTV.apply {
                visibility = View.VISIBLE
                text = "Invalid email format"

            }
            return
        }

        if (password.isEmpty()) {
            binding.passwordErrorTV.apply {
                visibility = View.VISIBLE
                text = "Password is required"

            }
            return
        }

        if (password.length < 6) {
            binding.passwordErrorTV.apply {
                visibility = View.VISIBLE
                text = "Password must be at least 6 characters"
            }
            return
        }

         binding.emailErrorTV.visibility = View.GONE
         binding.passwordErrorTV.visibility = View.GONE
        Toast.makeText(requireContext(), "Login Successful!", Toast.LENGTH_SHORT).show()

        navigateToDashboardActivity()

    }

    private fun navigateToDashboardActivity() {
        if (isAdded) {
            val dashboardIntent = Intent(requireContext(), DashboardActivity::class.java)
            startActivity(dashboardIntent)

            requireActivity().finish()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}