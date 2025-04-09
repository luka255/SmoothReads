package com.example.smoothreads.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.smoothreads.MainActivity
import com.example.smoothreads.R
import com.example.smoothreads.databinding.FragmentSignInBinding
import com.google.android.material.bottomnavigation.BottomNavigationView


class SignInFragment : Fragment() {

    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var signInButton: Button
    private lateinit var signUpButton: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentSignInBinding.inflate(inflater, container, false)
        val navController = findNavController()

        emailEditText = binding.emailInputSignIn
        passwordEditText = binding.passwordInputSignIn
        signInButton = binding.signInButton
        signUpButton = binding.signUpButtonSignIn

        signInButton.setOnClickListener {
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()

            if(!validSignIn(email,password)) {
                Toast.makeText(requireContext(), "email/password is invalid", Toast.LENGTH_SHORT)
                    .show()
            }
            else {
                (requireActivity() as MainActivity).findViewById<BottomNavigationView>(R.id.bottom_nav).visibility = View.VISIBLE

                navController.popBackStack(R.id.signInFragment,true)
                navController.navigate(R.id.myBooksFragment)
            }

        }

        signUpButton.setOnClickListener {
            navController.navigate(R.id.action_signIn_to_signUp)
        }

        return binding.root
    }
    private fun isValidEmail(email:String):Boolean{
        val regex = "^[a-zA-Z0-9._-]+@[a-zAZ0-9.-]+\\.[a-zA-Z]{2,}$".toRegex()
        return email.matches(regex)
    }


    private fun validSignIn(email : String, password : String) : Boolean
    {
        val testMail = "test@gmail.com"
        val testPassword = "123456Q!"

        if(!isValidEmail(email))
            Toast.makeText(requireContext(),"invalid email", Toast.LENGTH_SHORT).show()

        return email == testMail && password == testPassword
    }

}



