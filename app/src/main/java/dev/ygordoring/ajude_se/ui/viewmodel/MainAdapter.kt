package dev.ygordoring.ajude_se.ui.viewmodel

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import dev.ygordoring.ajude_se.R
import dev.ygordoring.ajude_se.data.model.MainItem

class MainAdapter(
    private val mainItems: List<MainItem>,
    private val onItemClickListener: (Int) -> Unit,
) : RecyclerView.Adapter<MainAdapter.MainViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.main_item, parent, false)
        return MainViewHolder(view)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val itemCurrent = mainItems[position]
        holder.bind(itemCurrent, onItemClickListener)
    }

    override fun getItemCount(): Int {
        return mainItems.size
    }

    class MainViewHolder
        (
        itemView: View
    ) : RecyclerView.ViewHolder(itemView) {
        fun bind(
            item: MainItem,
            onItemClickListener: (Int) -> Unit
        ) {
            val img: ImageView = itemView.findViewById(R.id.item_img_imc)
            val name: TextView = itemView.findViewById(R.id.item_txt_name)
            val container: LinearLayout = itemView.findViewById(R.id.item_container_imc)
            img.setImageResource(item.drawableId)
            name.setText(item.textStringId)
            container.setOnClickListener {
                onItemClickListener.invoke(item.id)
            }
        }

    }


}