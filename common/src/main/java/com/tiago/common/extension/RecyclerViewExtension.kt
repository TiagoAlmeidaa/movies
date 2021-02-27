package com.tiago.common.extension

import androidx.recyclerview.widget.RecyclerView

fun RecyclerView.replaceItemDecoration(itemDecoration: RecyclerView.ItemDecoration) {
    if (itemDecorationCount > 0) {
        for (position in 0 until itemDecorationCount) {
            removeItemDecorationAt(position)
        }
    }

    addItemDecoration(itemDecoration)
}