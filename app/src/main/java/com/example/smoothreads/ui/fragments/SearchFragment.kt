package com.example.smoothreads.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
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

        return binding.root
    }

}