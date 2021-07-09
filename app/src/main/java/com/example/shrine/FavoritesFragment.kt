package com.example.shrine

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.shrine.databinding.FragmentFavoritesBinding

class FavoritesFragment : Fragment() {
    private var binding:FragmentFavoritesBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFavoritesBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.btIMC?.setOnClickListener{
            findNavController().navigate(R.id.action_productsFragment_to_favoritesFragment)
            findNavController().navigate(R.id.action_favoritesFragment_to_calculadoraFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}