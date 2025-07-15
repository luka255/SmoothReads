package com.example.smoothreads.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.navigation.fragment.findNavController
import com.example.smoothreads.R
import com.example.smoothreads.databinding.FragmentBookListBinding
import com.example.smoothreads.databinding.FragmentWantToReadBinding

class BookListFragment : Fragment() {

    private lateinit var listView: ListView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentBookListBinding.inflate(inflater,container,false)
        val navController = findNavController()

        listView = binding.listViewWtr

        val bookList1 = listOf("book1","book2","book3","book4","book5","book6","book7","book8","book9","book10","book11","book12","book13","book14","book15","book16","book17","book18","book19","book20","book21","book22","book23","book24")

        val adapter = ArrayAdapter(requireContext(),android.R.layout.simple_list_item_1,bookList1)
        listView.adapter = adapter

        return binding.root
    }

}