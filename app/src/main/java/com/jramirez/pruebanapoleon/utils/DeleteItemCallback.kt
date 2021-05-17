package com.jramirez.pruebanapoleon.utils

import androidx.recyclerview.widget.ItemTouchHelper.*
import androidx.recyclerview.widget.RecyclerView
import com.jramirez.pruebanapoleon.base.CellRemovedListener

class DeleteItemCallback(
    private val cellRemovedListener: CellRemovedListener
) :
    SimpleCallback(ACTION_STATE_IDLE, LEFT or RIGHT) {

    override fun onMove(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        target: RecyclerView.ViewHolder
    ): Boolean {
        return false
    }

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
        val position = viewHolder.adapterPosition
        cellRemovedListener.onRemoveItem(position)
    }
}