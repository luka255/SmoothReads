package com.example.smoothreads

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import com.example.smoothreads.databinding.FragmentSignUpBinding

class SignUpFragment : Fragment() {

    private lateinit var nameEditText: EditText
    private lateinit var emailEditText : EditText
    private lateinit var passwordEditText : EditText
    private lateinit var signUpButton: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_sign_up, container, false)

        val backToSignInButton: Button = view.findViewById(R.id.backToSignIn)
        val signInButton: Button = view.findViewById(R.id.signUpButton)

        emailEditText= binding.editmailText

        signInButton.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, SignInFragment())
                .addToBackStack(null)
                .commit()
        }

        backToSignInButton.setOnClickListener{
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, SignInFragment())
                .addToBackStack(null)
                .commit()
        }


        return view
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
