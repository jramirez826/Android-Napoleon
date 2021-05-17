package com.jramirez.pruebanapoleon.post

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jramirez.pruebanapoleon.base.CellClickListener
import com.jramirez.pruebanapoleon.base.CellRemovedListener
import com.jramirez.pruebanapoleon.databinding.ItemPostBinding
import com.jramirez.pruebanapoleon.model.Post

class PostAdapter(private val cellClickListener: CellClickListener<Post>) :
    RecyclerView.Adapter<PostViewHolder>(), CellRemovedListener {

    private var list: MutableList<Post> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val binding = ItemPostBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PostViewHolder(binding)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val item = list[position]
        with(holder.binding) {
            labTitle.text = item.title
            labDescription.text = item.body
            root.setOnClickListener {
                cellClickListener.onCellClickListener(item)
            }
        }
    }

    fun update(items: List<Post>) {
        list.clear()
        list.addAll(items)
        notifyDataSetChanged()
    }

    override fun onRemoveItem(position: Int) {
        notifyItemRemoved(position)
        list.removeAt(position)
    }

    fun removeItems() {
        notifyItemRangeRemoved(0, itemCount)
        list.clear()
    }
}