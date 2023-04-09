package com.example.newsapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp.data.datasource.model.LifehackerContentDataSourceModel


class ItemAdapter(
    private val titleList: List<LifehackerContentDataSourceModel>
) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {
    lateinit var listener: OnItemClickListener

    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val titleView: TextView = view.findViewById(R.id.titleView)
        val textView: TextView = view.findViewById(R.id.textView)
        val linerLayoutView: LinearLayout = view.findViewById(R.id.linearLayout)
    }

    // 作られた時に実行されるメゾット
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
        val item = adapterLayout.inflate(R.layout.card_item, parent, false)
        // クリックは検知した(positionがとってこれない)
//        ItemViewHolder(adapterLayout).itemView.setOnClickListener(View.OnClickListener { v ->
//            Toast.makeText(v.context, "aaaaa", Toast.LENGTH_SHORT).show()
//        })
        return ItemViewHolder(item)
    }

    // 表示内容の更新
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.titleView.text = titleList[position].title
        holder.textView.text = titleList[position].description
        holder.linerLayoutView.setOnClickListener {
            listener.onItemClickListener(it, position, titleList[position].link!!)
        }
    }

    interface OnItemClickListener {
        fun onItemClickListener(view: View, position: Int, clickedLink: String)
    }

    // リスナー(OnItemClickListenerオブジェクトをリスナーに格納??)
    fun setOnItemClickListener(listener: OnItemClickListener) {
        this.listener = listener
    }

    // 表示したいリスト数を返す
    override fun getItemCount() = titleList.size
}