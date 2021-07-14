package com.example.shrine

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.shrine.databinding.FragmentProductsBinding
import com.google.android.material.tabs.TabLayout

class ProductsFragment : Fragment() {

    private var binding:FragmentProductsBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentProductsBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val fragmentsList = listOf(FavoritesFragment(), BagFragment(), PaymentFragment())
        val fragmentsTitleList = listOf("Favoritos", "Carrinho", "Pagamento")

     // so inicia o ViewPager se a Activity for diferente de nulo
        val viewPagerAdapter = ViewPagerAdapter(
            fragmentsList,
            fragmentsTitleList,
            childFragmentManager
        )
        binding?.let { bindingNonNull ->
            with(bindingNonNull) {
                container.adapter = viewPagerAdapter
                tlProductsTabs.setupWithViewPager(container)
            }
        }
    }

   /* fun goToFragment(fragment: Fragment){
        val fragmentTransaction = activity?.supportFragmentManager?.beginTransaction()
        fragmentTransaction?.replace(R.id.container, fragment)
        fragmentTransaction?.commit()
    }*/

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}