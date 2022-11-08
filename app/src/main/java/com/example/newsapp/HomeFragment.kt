package com.example.newsapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
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
        // tabAdapterの中にフラグメントのアクティビティを渡す
        binding.pager.adapter = TabAdapter(requireActivity())
        viewPager = view.findViewById(R.id.pager)
        val tabLayout = view.findViewById<TabLayout>(R.id.tab_layout)

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            val view = layoutInflater.inflate(R.layout.appbar_item, null)
            if(position==0) view.setBackgroundColor(ResourcesCompat.getColor(resources, R.color.blue, null))
            else view.setBackgroundColor(ResourcesCompat.getColor(resources, R.color.red, null))
            tab.customView = view
        }.attach()
    }
}
