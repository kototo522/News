package com.example.newsapp

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.fragment.app.Fragment
import androidx.fragment.app.createViewModelLazy
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.newsapp.databinding.FragmentHomeBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class HomeFragment : Fragment() {
    private lateinit var viewPager: ViewPager2

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentHomeBinding.bind(view)
        binding.pager.adapter = TabAdapter(requireActivity())

        viewPager = view.findViewById(R.id.pager)
        val tabLayout = view.findViewById<TabLayout>(R.id.tab_layout)
        // tabAdapterの中にフラグメントのアクティビティを渡す
        val tabAdapter  = TabAdapter(requireActivity())
        binding.pager.adapter = tabAdapter
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabReselected(tab: TabLayout.Tab?) {}
            override fun onTabUnselected(tab: TabLayout.Tab?) {}
            override fun onTabSelected(tab: TabLayout.Tab?) {
                if (tab != null) {
                    binding.pager.currentItem = tab.position
                }
            }
        })

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            val view = layoutInflater.inflate(R.layout.appbar_item, null)
            if(position==0) view.setBackgroundColor(resources.getColor(R.color.blue))
            else view.setBackgroundColor(resources.getColor(R.color.red))
            tab.customView = view
        }.attach()
    }

}