package com.example.smoothreads.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.smoothreads.databinding.FragmentReadBooksBinding

class ReadBooksFragment : Fragment() {

override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentReadBooksBinding.inflate(inflater,container,false)

        return binding.root
    }
}