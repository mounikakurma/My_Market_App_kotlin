package com.example.mymarketapp.view.dashboard.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mymarketapp.R
import com.example.mymarketapp.view.dashboard.model.BottomMenuItem

//5th Adapter Component
class BottomMenuRecyclerAdapter(
    private val onItemClick: (BottomMenuItem) -> Unit
) : RecyclerView.Adapter<BottomMenuRecyclerAdapter.MenuViewHolder>() {

    private var items = listOf<BottomMenuItem>()

    fun submitList(list: List<BottomMenuItem>) {
        items = list
        notifyDataSetChanged()
    }

    //6th ViewHolder component
    inner class MenuViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val icon: ImageView = view.findViewById(R.id.icon)
        val title: TextView = view.findViewById(R.id.title)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_bottom_menu, parent, false)
        return MenuViewHolder(view)
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        val item = items[position]

        holder.icon.setImageResource(item.iconRes)
        holder.title.text = item.title

        val alpha = if (item.isSelected) 1f else 0.5f
        holder.icon.alpha = alpha
        holder.title.alpha = alpha

        holder.itemView.setOnClickListener {
            onItemClick(item)
        }
    }

    override fun getItemCount() = items.size
}
