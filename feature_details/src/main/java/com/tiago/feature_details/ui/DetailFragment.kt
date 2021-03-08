package com.tiago.feature_details.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.tiago.feature_details.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {

    private val binding: FragmentDetailBinding by lazy {
        initializeBinding()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = binding.root

    private fun initializeBinding() = FragmentDetailBinding.inflate(layoutInflater).apply {
        lifecycleOwner = this@DetailFragment
    }
}