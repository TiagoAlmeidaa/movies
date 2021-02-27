package com.tiago.popular.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.tiago.common.extension.gone
import com.tiago.common.extension.visible
import com.tiago.common.viewmodel.ViewModelCreatorFactory
import com.tiago.popular.databinding.FragmentPopularBinding
import com.tiago.popular.di.PopularInjector
import com.tiago.popular.model.PopularState
import com.tiago.popular.ui.adapter.MovieAdapter
import com.tiago.popular.ui.adapter.MovieListItemDecoration
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
        setupObservers()
        loadData()
    }

    private fun injectDependencies() = PopularInjector.component.inject(this)

    private fun setupObservers() = with(viewModel) {
        state.observe(viewLifecycleOwner, getStateObserver())
    }

    private fun loadData() {
        if (!viewModel.hasMovies()) {
            viewModel.getPopularMovies()
        }
    }

    private fun getStateObserver() = Observer<PopularState> { state ->
        when (state) {
            is PopularState.OnLoading -> with(binding) {
                progressBar.visible()
                popularList.gone()
            }
            is PopularState.OnMoviesReceived -> with(binding) {
                progressBar.gone()
                popularList.visible()
                popularList.adapter = MovieAdapter(state.movies)
                popularList.layoutManager = LinearLayoutManager(requireContext())
                popularList.addItemDecoration(MovieListItemDecoration())
            }
            is PopularState.OnMoviesFailed -> with(binding) {
                progressBar.gone()
                popularList.visible()

                Toast.makeText(requireContext(), state.exception.message ?: "unknown error", Toast.LENGTH_LONG).show()
            }
        }
    }

}