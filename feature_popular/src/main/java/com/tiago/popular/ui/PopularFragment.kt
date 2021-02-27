package com.tiago.popular.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.tiago.common.viewmodel.ViewModelCreatorFactory
import com.tiago.popular.databinding.FragmentPopularBinding
import com.tiago.popular.di.PopularInjector
import com.tiago.popular.model.PopularState
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
            is PopularState.OnMoviesReceived -> {
                binding.popularList.adapter = MovieAdapter(state.movies)
                binding.popularList.layoutManager = LinearLayoutManager(requireContext())
            }
            is PopularState.OnMoviesFailed -> {
                Log.d("Resposta", state.exception.message ?: "unknown")
            }
        }
    }

}