package com.example.newsapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import coil.load
import com.example.newsapp.data.datasource.LifehackerRemoteDataSourceImpl
import com.example.newsapp.data.datasource.model.LifehackerContentDataSourceModel
import com.example.newsapp.databinding.FragmentSearchBinding
import com.example.newsapp.databinding.FragmentTab01Binding
import com.example.newsapp.databinding.FragmentTab02Binding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import java.lang.reflect.Array.set

class Tab01Fragment: Fragment(){
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_tab_01,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val dataset = LifehackerRemoteDataSourceImpl()
        val recyclerView: RecyclerView = view.findViewById(R.id.Recycler_view)
        recyclerView.adapter = ItemAdapter(requireContext(), dataset.get(LifehackerContentDataSourceModel->title), Datasource().loadTexts(), Datasource().loadImages())
        recyclerView.setHasFixedSize(true)
    }
}

class Tab02Fragment: Fragment(){
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_tab_02,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val myDataset = Datasource()
        val recyclerView: RecyclerView = view.findViewById(R.id.Recycler_view)
        recyclerView.adapter = ItemAdapter(requireContext(), myDataset.loadTitles(), myDataset.loadTexts(), myDataset.loadImages())
        recyclerView.setHasFixedSize(true)
    }
}