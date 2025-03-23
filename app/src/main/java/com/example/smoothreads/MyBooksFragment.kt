package com.example.smoothreads

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.smoothreads.databinding.FragmentMyBooksBinding
import com.google.android.material.navigation.NavigationBarView

class MyBooksFragment : Fragment() {

    private lateinit var searchView: SearchView
    private lateinit var wantToReadImageButton: ImageButton
    private lateinit var readImageButton: ImageButton
    private lateinit var navBar : NavigationBarView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentMyBooksBinding.inflate(inflater, container, false)
        val navController = findNavController()


        searchView = binding.searchMyBooks
        wantToReadImageButton = binding.wantToReadImageButton
        readImageButton = binding.ReadImageButton
        navBar = binding.navBar

        wantToReadImageButton.setOnClickListener {
            navController.navigate(R.id.action_myBooks_to_search)
        }

        readImageButton.setOnClickListener {
            navController.navigate(R.id.action_myBooks_to_readBooks)
        }

        return binding.root
    }
}