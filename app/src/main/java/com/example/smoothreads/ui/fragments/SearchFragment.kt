package com.example.smoothreads.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.smoothreads.R
import com.example.smoothreads.databinding.FragmentSearchBinding

class SearchFragment : Fragment() {

    private lateinit var searchView : SearchView
    private lateinit var classicsButton : Button
    private lateinit var romanceButton : Button
    private lateinit var fantasyButton : Button
    private lateinit var fictionButton : Button
    private lateinit var nonFictionButton : Button
    private lateinit var youngAdultsButton : Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentSearchBinding.inflate(inflater,container,false)
        val navController = findNavController()

        searchView = binding.searchView
        classicsButton = binding.classicButton
        romanceButton = binding.romanceButton
        fantasyButton = binding.fantasyButton
        fictionButton = binding.fictionButton
        nonFictionButton = binding.nonFictionButton
        youngAdultsButton = binding.youngAdultsButton


        classicsButton.setOnClickListener {
            navController.navigate(R.id.action_search_to_bookList)
        }
        romanceButton.setOnClickListener {
            navController.navigate(R.id.action_search_to_bookList)
        }
        fantasyButton.setOnClickListener {
            navController.navigate(R.id.action_search_to_bookList)
        }
        fictionButton.setOnClickListener {
            navController.navigate(R.id.action_search_to_bookList)
        }
        nonFictionButton.setOnClickListener {
            navController.navigate(R.id.action_search_to_bookList)
        }
        youngAdultsButton.setOnClickListener {
            navController.navigate(R.id.action_search_to_bookList)
        }

        return binding.root
    }

}