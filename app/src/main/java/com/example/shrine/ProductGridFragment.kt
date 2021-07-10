package com.example.shrine

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import com.example.shrine.databinding.FragmentProductGridBinding
import kotlinx.android.synthetic.main.fragment_product_grid.*
import kotlinx.android.synthetic.main.fragment_product_grid.view.*

class ProductGridFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        // Inflate the layout for this fragment with the ProductGrid theme
        val view = inflater.inflate(R.layout.fragment_product_grid, container, false)
        // Set up the toolbar.
        (activity as AppCompatActivity).setSupportActionBar(view.app_bar)
        return view

    }

    override fun onCreateOptionsMenu(menu: Menu, menuInflater: MenuInflater) {
        menuInflater.inflate(R.menu.top_bar, menu)
        super.onCreateOptionsMenu(menu, menuInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        app_bar.setNavigationOnClickListener {
            // Handle navigation icon press
        }

        app_bar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.favorite -> {
                    findNavController().navigate(R.id.action_productGridFragment_to_productsFragment)
                    // Handle favorite icon press
                    true
                }
                R.id.search -> {
                    // Handle search icon press
                    true
                }
                R.id.more -> {
                    // Handle more item (inside overflow menu) press
                    true
                }
                else -> false
            }
        }
    }




}