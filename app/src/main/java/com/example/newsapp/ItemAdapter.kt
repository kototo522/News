package com.example.newsapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.newsapp.data.datasource.model.LifehackerContentDataSourceModel

class Datasource {
    fun loadImages(): List<String> {
        return listOf(
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRy6eVhTlIO8QxiqUK8M7-4q87TN5_x2LgrbA&usqp=CAU",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRy6eVhTlIO8QxiqUK8M7-4q87TN5_x2LgrbA&usqp=CAU",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRy6eVhTlIO8QxiqUK8M7-4q87TN5_x2LgrbA&usqp=CAU",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRy6eVhTlIO8QxiqUK8M7-4q87TN5_x2LgrbA&usqp=CAU",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRy6eVhTlIO8QxiqUK8M7-4q87TN5_x2LgrbA&usqp=CAU",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRy6eVhTlIO8QxiqUK8M7-4q87TN5_x2LgrbA&usqp=CAU",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRy6eVhTlIO8QxiqUK8M7-4q87TN5_x2LgrbA&usqp=CAU",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRy6eVhTlIO8QxiqUK8M7-4q87TN5_x2LgrbA&usqp=CAU",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRy6eVhTlIO8QxiqUK8M7-4q87TN5_x2LgrbA&usqp=CAU",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRy6eVhTlIO8QxiqUK8M7-4q87TN5_x2LgrbA&usqp=CAU",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRy6eVhTlIO8QxiqUK8M7-4q87TN5_x2LgrbA&usqp=CAU",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRy6eVhTlIO8QxiqUK8M7-4q87TN5_x2LgrbA&usqp=CAU",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRy6eVhTlIO8QxiqUK8M7-4q87TN5_x2LgrbA&usqp=CAU",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRy6eVhTlIO8QxiqUK8M7-4q87TN5_x2LgrbA&usqp=CAU",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRy6eVhTlIO8QxiqUK8M7-4q87TN5_x2LgrbA&usqp=CAU",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRy6eVhTlIO8QxiqUK8M7-4q87TN5_x2LgrbA&usqp=CAU",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRy6eVhTlIO8QxiqUK8M7-4q87TN5_x2LgrbA&usqp=CAU",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRy6eVhTlIO8QxiqUK8M7-4q87TN5_x2LgrbA&usqp=CAU",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRy6eVhTlIO8QxiqUK8M7-4q87TN5_x2LgrbA&usqp=CAU",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRy6eVhTlIO8QxiqUK8M7-4q87TN5_x2LgrbA&usqp=CAU"
        )
    }
}

class ItemAdapter(
    private val titleList: List<LifehackerContentDataSourceModel>,
    private val imageList: List<String>
) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {
    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val titleView: TextView = view.findViewById(R.id.titleView)
        val textView: TextView = view.findViewById(R.id.textView)
        val imageView: ImageView = view.findViewById(R.id.imageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_item, parent, false)
        return ItemViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.titleView.text = titleList[position].title
        holder.textView.text = titleList[position].description
        holder.imageView.load(imageList[position])
    }

    override fun getItemCount() = titleList.size
}