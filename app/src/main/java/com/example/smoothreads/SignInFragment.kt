package com.example.smoothreads

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.smoothreads.databinding.FragmentSignInBinding

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

        emailEditText = binding.emailInputSignIn
        passwordEditText = binding.passwordInputSignIn
        signInButton = binding.signInbutton
        signUpButton = binding.signUpButtonSignIn

        signInButton.setOnClickListener {
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()

            if(!validSignIn(email,password))
                Toast.makeText(requireContext(),"email/password is invalid", Toast.LENGTH_SHORT).show()
            else
                Toast.makeText(requireContext(),"signed in successfully", Toast.LENGTH_SHORT).show()

        }

        signUpButton.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, SignUpFragment())
                .addToBackStack(null)
                .commit()
        }

        return binding.root
    }
    private fun isValidEmail(email:String):Boolean{
        val regex = "^[a-zA-Z0-9._-]+@[a-zAZ0-9.-]+\\.[a-zA-Z]{2,}$".toRegex()
        return email.matches(regex)
    }


    private fun validSignIn(email : String, password : String) : Boolean
    {
        val testMail : String = "test@gmail.com"
        val testPassword : String = "testPassword123!"

        if(!isValidEmail(email))
            Toast.makeText(requireContext(),"invalid email", Toast.LENGTH_SHORT).show()

        return email == testMail && password == testPassword
    }

}



