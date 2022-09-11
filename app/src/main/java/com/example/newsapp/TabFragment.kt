package com.example.newsapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import coil.load
import com.example.newsapp.databinding.FragmentSearchBinding
import com.example.newsapp.databinding.FragmentTab01Binding
import com.example.newsapp.databinding.FragmentTab02Binding

class Tab01Fragment: Fragment(){
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentTab01Binding.bind(view)
        binding.imageView.load("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRy6eVhTlIO8QxiqUK8M7-4q87TN5_x2LgrbA&usqp=CAU")
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_tab_01,container,false)
    }
}

class Tab02Fragment: Fragment(){
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentTab02Binding.bind(view)
        binding.imageView.load("https://harajuku-pop.com/wp-content/uploads/2021/06/a2c615d59be789b047a89fa9d9985590.jpg")
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_tab_02,container,false)
    }
}