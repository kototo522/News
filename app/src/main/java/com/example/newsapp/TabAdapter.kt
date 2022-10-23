package com.example.newsapp

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class TabAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {
    companion object {
        private val pageList = listOf(Tab01Fragment(), Tab02Fragment())
    }
    override fun getItemCount(): Int = pageList.size
    override fun createFragment(position: Int): Fragment = pageList[position]
}