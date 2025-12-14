package com.example.mymarketapp.view.register.fragment

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.mymarketapp.R
import com.example.mymarketapp.databinding.FragmentRegisterBinding
import com.example.mymarketapp.utils.AuthResult
import com.example.mymarketapp.view.register.viewModel.AuthViewModel

class RegisterFragment : Fragment(R.layout.fragment_register) {

    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!

    private val viewModel: AuthViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        _binding = FragmentRegisterBinding.bind(view)

        binding.btnSignUp.setOnClickListener {
            validateSignupForm()
        }
    }

    private fun validateSignupForm() {

        val name = binding.etName.text.toString().trim()
        val email = binding.etEmail.text.toString().trim()
        val password = binding.etPassword.text.toString().trim()
        val confirmPassword = binding.etConfirmPassword.text.toString().trim()

        binding.nameInputLayout.error = null
        binding.emailInputLayout.error = null
        binding.passwordInputLayout.error = null
        binding.confirmPasswordInputLayout.error = null

        val result = viewModel.validateSignup(name, email, password, confirmPassword)
        when (result) {

            AuthResult.EmptyName ->
                binding.nameInputLayout.error = "Name is required"

            AuthResult.EmptyEmail ->
                binding.emailInputLayout.error = "Email is required"

            AuthResult.InvalidEmail ->
                binding.emailInputLayout.error = "Invalid email format"

            AuthResult.EmptyPassword ->
                binding.passwordInputLayout.error = "Password is required"

            AuthResult.ShortPassword ->
                binding.passwordInputLayout.error = "Minimum 6 characters required"

            AuthResult.PasswordMismatch ->
                binding.confirmPasswordInputLayout.error = "Passwords do not match"

            AuthResult.Success -> {
                Toast.makeText(requireContext(), "Account Created Successfully!", Toast.LENGTH_LONG)
                    .show()
            }
        }
    }
}