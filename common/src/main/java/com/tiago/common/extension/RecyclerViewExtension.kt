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

fun RecyclerView.onBottomReached(action: () -> Unit) {
    addOnScrollListener(object : RecyclerView.OnScrollListener() {
        override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
            super.onScrollStateChanged(recyclerView, newState)
            if (hasReachedBottom(newState)) {
                action()
            }
        }
    })
}

fun RecyclerView.hasReachedBottom(newState: Int): Boolean =
    !canScrollVertically(1) && newState == RecyclerView.SCROLL_STATE_IDLE