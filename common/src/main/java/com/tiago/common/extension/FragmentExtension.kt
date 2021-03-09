package com.tiago.common.extension

import androidx.fragment.app.Fragment
import androidx.transition.TransitionInflater

fun Fragment.setupSharedElementEnterTransition(transitionId: Int) {
    sharedElementEnterTransition = TransitionInflater
        .from(requireContext())
        .inflateTransition(transitionId)
}