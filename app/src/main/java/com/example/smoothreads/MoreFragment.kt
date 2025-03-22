package com.example.smoothreads

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.smoothreads.databinding.FragmentMoreBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MoreFragment : Fragment() {

    private lateinit var profileButton : ImageButton
    private lateinit var  logOutButton: ImageButton

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentMoreBinding.inflate(inflater,container,false)
        val navController = findNavController()

        profileButton = binding.profileImageButton
        logOutButton = binding.logOutImageButton

        logOutButton.setOnClickListener {
            (requireActivity() as MainActivity).findViewById<BottomNavigationView>(R.id.bottom_nav).visibility = View.GONE

            navController.popBackStack(R.id.signInFragment, true)
            navController.navigate(R.id.signInFragment)
        }

        return binding.root
    }
}