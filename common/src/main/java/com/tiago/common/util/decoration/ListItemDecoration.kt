package com.tiago.common.util.decoration

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.tiago.common.extension.dp

class ListItemDecoration : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) = with(outRect) {
        if (isOnTop(view, parent)) {
            top = 10.dp
        }
        left = 50.dp
        right = 50.dp
        bottom = 10.dp
    }

    private fun isOnTop(view: View, parent: RecyclerView): Boolean =
        parent.getChildAdapterPosition(view) == 0

}