package com.example.newsapp
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp.databinding.FragmentFavoriteBinding

data class Affirmation(val stringResourceId: Int)

class Datasource {
    fun loadTitles(): List<Affirmation> {
        return listOf<Affirmation>(
            Affirmation(R.string.titleList1),
            Affirmation(R.string.titleList2),
            Affirmation(R.string.titleList3),
            Affirmation(R.string.titleList4),
            Affirmation(R.string.titleList5),
            Affirmation(R.string.titleList6),
            Affirmation(R.string.titleList7),
            Affirmation(R.string.titleList8),
            Affirmation(R.string.titleList9),
            Affirmation(R.string.titleList10)
        )
    }
    fun loadTexts(): List<Affirmation> {
        return listOf<Affirmation>(
            Affirmation(R.string.textList1),
            Affirmation(R.string.textList2),
            Affirmation(R.string.textList3),
            Affirmation(R.string.textList4),
            Affirmation(R.string.textList5),
            Affirmation(R.string.textList6),
            Affirmation(R.string.textList7),
            Affirmation(R.string.textList8),
            Affirmation(R.string.textList9),
            Affirmation(R.string.textList10)
        )
    }
}

class ItemAdapter(
    private val context: Context,
    private val dataset: List<Affirmation>
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
        val item = dataset[position]
        holder.titleView.text = context.resources.getString(item.stringResourceId)
        holder.textView.text = context.resources.getString(item.stringResourceId)
    }

    override fun getItemCount() = dataset.size
}