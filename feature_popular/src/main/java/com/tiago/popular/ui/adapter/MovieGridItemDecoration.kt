package com.tiago.popular.ui.adapter

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.tiago.common.extension.dp

class MovieGridItemDecoration : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) = with(outRect) {
        if (isOnTop(view, parent)) {
            top = 10.dp
        }
        if (!isEven(view, parent)) {
            right = 10.dp
            left = 5.dp
        } else {
            right = 5.dp
            left = 10.dp
        }
        bottom = 10.dp
    }

    private fun isOnTop(view: View, parent: RecyclerView): Boolean =
        parent.getChildAdapterPosition(view) == 0 || parent.getChildAdapterPosition(view) == 1

    private fun isEven(view: View, parent: RecyclerView): Boolean =
        parent.getChildAdapterPosition(view) % 2 == 0

}