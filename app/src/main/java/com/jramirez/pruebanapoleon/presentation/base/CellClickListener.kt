package com.jramirez.pruebanapoleon.presentation.base

import android.view.View

interface CellClickListener<T> {
    fun onCellClickListener(
        item: T, view: View
    )
}