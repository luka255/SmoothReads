package com.example.smoothreads.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.smoothreads.R
import com.example.smoothreads.databinding.FragmentReadBooksBinding

class ReadBooksFragment : Fragment() {

    private lateinit var listView: ListView
    private lateinit var text : TextView
    private lateinit var button : Button

override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

    val binding = FragmentReadBooksBinding.inflate(inflater,container,false)
    val navController = findNavController()

    listView = binding.listView
    text = binding.textView4
    button = binding.button

    val bookList: List<String> = emptyList()

    /*"book1","book2","book3","book4","book5","book6","book7","book8","book9","book10","book11","book12","book13","book14","book15","book16","book17","book18","book19","book20","book21","book22","book23","book24"*/

    if (!bookList.isEmpty())
    {
        listView.visibility = View.VISIBLE
        text.visibility = View.GONE
        button.visibility = View.GONE

        val adapter = ArrayAdapter(requireContext(),android.R.layout.simple_list_item_1,bookList)
        listView.adapter = adapter
    }

    button.setOnClickListener {
        navController.navigate(R.id.action_readBooks_to_search)
    }





    return binding.root
    }
}