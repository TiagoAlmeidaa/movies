package com.tiago.popular.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.tiago.common.extension.gone
import com.tiago.common.extension.replaceItemDecoration
import com.tiago.common.extension.visible
import com.tiago.common.viewmodel.ViewModelCreatorFactory
import com.tiago.popular.databinding.FragmentPopularBinding
import com.tiago.popular.di.PopularInjector
import com.tiago.popular.model.PopularState
import com.tiago.popular.model.RecyclerViewState
import com.tiago.popular.ui.adapter.MovieAdapter
import com.tiago.popular.viewmodel.PopularViewModel
import com.tiago.popular.viewmodel.PopularViewModelFactory
import javax.inject.Inject

class PopularFragment : Fragment() {

    @Inject
    internal lateinit var factory: PopularViewModelFactory

    private val viewModel: PopularViewModel by viewModels {
        ViewModelCreatorFactory(factory, this)
    }

    private val binding: FragmentPopularBinding by lazy {
        FragmentPopularBinding.inflate(layoutInflater).apply {
            lifecycleOwner = this@PopularFragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        injectDependencies()
        setupEvents()
        setupObservers()
        loadData()
    }

    private fun setupEvents() = with(binding) {
        imageViewMode.setOnClickListener {
            viewModel.changeRecyclerViewMode()
        }
    }

    private fun injectDependencies() = PopularInjector.component.inject(this)

    private fun setupObservers() = with(viewModel) {
        state.observe(viewLifecycleOwner, getStateObserver())
        mode.observe(viewLifecycleOwner, getModeObserver())
    }

    private fun loadData() {
        if (!viewModel.hasMovies()) {
            viewModel.getPopularMovies()
        }
    }

    private fun getStateObserver() = Observer<PopularState> { state ->
        when (state) {
            is PopularState.OnLoading -> {
                showLoading()
            }
            is PopularState.OnMoviesReceived -> with(binding) {
                hideLoading()
                popularList.adapter = MovieAdapter(state.movies)
            }
            is PopularState.OnMoviesFailed -> {
                hideLoading()

                Toast.makeText(requireContext(), state.exception.message ?: "unknown error", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun getModeObserver() = Observer<RecyclerViewState> { state ->
        when(state) {
            is RecyclerViewState.GridMode -> {
                with(binding) {
                    imageViewMode.setImageResource(state.iconChangeTo)
                    popularList.layoutManager = GridLayoutManager(requireContext(), 2)
                    popularList.replaceItemDecoration(state.decoration)
                }
            }
            is RecyclerViewState.ListMode -> {
                with(binding) {
                    imageViewMode.setImageResource(state.iconChangeTo)
                    popularList.layoutManager = LinearLayoutManager(requireContext())
                    popularList.replaceItemDecoration(state.decoration)
                }
            }
        }
    }

    private fun showLoading() = with(binding) {
        progressBar.visible()
        popularList.gone()
    }

    private fun hideLoading() = with(binding) {
        progressBar.gone()
        popularList.visible()
    }

}