package com.jramirez.pruebanapoleon.base

import android.view.View

interface CellClickListener<T> {
    fun onCellClickListener(
        item: T, view: View
    )
}