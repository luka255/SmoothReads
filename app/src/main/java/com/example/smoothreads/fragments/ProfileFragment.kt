package com.example.smoothreads.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.smoothreads.databinding.FragmentProfileBinding


class ProfileFragment : Fragment() {

    private lateinit var profilePicture: ImageView
    private lateinit var books : TextView
    private lateinit var favourites: TextView
    private lateinit var commented : TextView
    private lateinit var genres : TextView
    private lateinit var topBooks : TextView
    private lateinit var genresImage : ImageView
    private lateinit var topBooksImage : ImageView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentProfileBinding.inflate(inflater,container,false)

        profilePicture = binding.profilePicture
        books = binding.books
        favourites = binding.favourites
        commented = binding.commented
        genres = binding.genres
        topBooks = binding.topBooks
        genresImage = binding.genresImage
        topBooksImage = binding.topBooksImage


        return binding.root
    }

}