package com.example.newsapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp.data.datasource.LifehackerRemoteDataSourceImpl
import kotlinx.coroutines.launch

class Tab01Fragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_tab_01, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val dataset = LifehackerRemoteDataSourceImpl()
        val recyclerView: RecyclerView = view.findViewById(R.id.Recycler_view)
        val webView: WebView = view.findViewById(R.id.webView)

        lifecycleScope.launch {
            val result = dataset.fetchContents()
            result.fold(
                onSuccess = {
                    val adapter= ItemAdapter(it)
                    adapter.setOnItemClickListener(object: ItemAdapter.OnItemClickListener{
                        override fun onItemClickListener(view: View, position: Int, clickedLink: String) {
                            webView.loadUrl(clickedLink)
                        }
                    })
                    recyclerView.adapter = adapter
                    recyclerView.setHasFixedSize(true)
                },
                onFailure = {
                    Toast.makeText(context, R.string.app_name, Toast.LENGTH_SHORT).show()
                }
            )
        }
    }
}

class Tab02Fragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_tab_02, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val dataset = LifehackerRemoteDataSourceImpl()
        val recyclerView: RecyclerView = view.findViewById(R.id.Recycler_view)
        val webView: WebView = view.findViewById(R.id.webView)

        lifecycleScope.launch {
            val result = dataset.fetchContents()
            result.fold(
                onSuccess = {
                    val adapter = ItemAdapter(it)
                    adapter.setOnItemClickListener(object: ItemAdapter.OnItemClickListener{
                        override fun onItemClickListener(view: View, position: Int, clickedLink: String) {
                            webView.loadUrl(clickedLink)
                        }
                    })
                    recyclerView.adapter = adapter
                    recyclerView.setHasFixedSize(true)
                },
                onFailure = {
                    Toast.makeText(context, R.string.app_name, Toast.LENGTH_SHORT).show()
                }
            )
        }
    }
}