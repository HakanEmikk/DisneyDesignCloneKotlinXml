package com.example.disneyclone.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.disneyclone.R
import com.example.disneyclone.databinding.FragmentHomeBinding
import com.example.disneyclone.adapters.MovieAdapter
import com.example.disneyclone.models.Movie

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var newToDisneyAdapter: MovieAdapter
    private lateinit var specialForYouAdapter: MovieAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerViews()
        loadFakeData()
    }

    private fun setupRecyclerViews() {
        // Setup New to Disney+ RecyclerView
        newToDisneyAdapter = MovieAdapter()
        binding.newToDisneyRecyclerView.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = newToDisneyAdapter
        }

        // Setup Special for You RecyclerView
        specialForYouAdapter = MovieAdapter()
        binding.specialForYouRecyclerView.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = specialForYouAdapter
        }
    }

    private fun loadFakeData() {
        // New to Disney+ movies
        val newMovies = listOf(
            Movie(1, "Bob's Burgers Film", R.drawable.marvel),
//            Movie(2, "İlk Dalga", R.drawable.ilk_dalga),
//            Movie(3, "Wandavision", R.drawable.wandavision),
//            Movie(4, "Black Widow", R.drawable.black_widow)
        )
        newToDisneyAdapter.submitList(newMovies)

        // Special for You movies
        val specialMovies = listOf(
            Movie(5, "Loki", R.drawable.home),
//            Movie(6, "Mandalorian", R.drawable.mandalorian),
//            Movie(7, "Soul", R.drawable.soul),
//            Movie(8, "Moon Knight", R.drawable.moon_knight)
        )
        specialForYouAdapter.submitList(specialMovies)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}