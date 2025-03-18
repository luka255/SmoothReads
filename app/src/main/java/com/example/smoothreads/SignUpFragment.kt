package com.example.smoothreads

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.smoothreads.databinding.FragmentSignUpBinding


class SignUpFragment : Fragment() {

    private lateinit var nameEditText: EditText
    private lateinit var emailEditText : EditText
    private lateinit var passwordEditText : EditText
    private lateinit var signUpButton: Button
    private lateinit var backToSignInButton : Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = FragmentSignUpBinding.inflate(inflater,container,false)

        nameEditText = binding.nameInputSignUp
        emailEditText = binding.EmailInputSignUp
        passwordEditText = binding.passwordInputSignUp
        signUpButton = binding.signUpButton
        backToSignInButton = binding.backToSignIn

        signUpButton.setOnClickListener {
            val name = nameEditText.text.toString()
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()

            if(validRegistrationForm(name,email,password))
            {
                parentFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, SignInFragment())
                    .addToBackStack(null)
                    .commit()

                Toast.makeText(requireContext(), "Registration Successful", Toast.LENGTH_SHORT).show()
            }
            else
            {
                Toast.makeText(requireContext(), "name or email is not valid", Toast.LENGTH_SHORT).show()
            }
        }

        backToSignInButton.setOnClickListener{
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, SignInFragment())
                .addToBackStack(null)
                .commit()
        }


        return binding.root
    }
    private fun isValidEmail(email:String):Boolean{
        val regex = "^[a-zA-Z0-9._-]+@[a-zAZ0-9.-]+\\.[a-zA-Z]{2,}$".toRegex()
        return email.matches(regex)
    }
    private fun isValidPassword(password:String):Boolean{
        val regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$".toRegex()
        return password.matches(regex)
    }
    private fun validRegistrationForm(name:String,email:String,password: String):Boolean{
        if(name == null){
            nameEditText.error="name field should be filled"
            return false
        }
        if(!isValidEmail(email)) {
            emailEditText.error = "invalid email"
            return false
        }
        if(!isValidPassword(password)){
            passwordEditText.error = "invalid password"
            return false
        }
        return true
    }

}
