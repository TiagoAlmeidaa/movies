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
import com.tiago.common.extension.onBottomReached
import com.tiago.common.extension.replaceItemDecoration
import com.tiago.common.extension.visible
import com.tiago.common.viewmodel.ViewModelCreatorFactory
import com.tiago.model.Movie
import com.tiago.common.util.BundleKeys
import com.tiago.common.util.decoration.GridItemDecoration
import com.tiago.navigation.MoviesNavigation
import com.tiago.navigation.Navigator
import com.tiago.popular.databinding.FragmentPopularBinding
import com.tiago.popular.di.PopularInjector
import com.tiago.popular.model.PopularState
import com.tiago.popular.ui.adapter.MovieAdapter
import com.tiago.popular.ui.adapter.MovieAdapterEvents
import com.tiago.popular.viewmodel.PopularViewModel
import com.tiago.popular.viewmodel.PopularViewModelFactory
import javax.inject.Inject

class PopularFragment : Fragment(), MovieAdapterEvents {

    @Inject
    internal lateinit var factory: PopularViewModelFactory

    private val viewModel: PopularViewModel by viewModels {
        ViewModelCreatorFactory(factory, this)
    }

    private val binding: FragmentPopularBinding by lazy {
        initializeBinding()
    }

    private val navigator: Navigator by lazy {
        activity as Navigator
    }

    private val adapter: MovieAdapter by lazy {
        MovieAdapter(this@PopularFragment)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        injectDependencies()
        initializeUI()
        initializeEvents()
        initializeObservers()
        initializeData()
    }

    override fun onMovieClicked(movie: Movie) {
        val bundle = Bundle().apply {
            putSerializable(BundleKeys.BUNDLE_DETAILS, movie)
        }
        navigator.navigateTo(MoviesNavigation.Details(bundle))
    }

    private fun initializeBinding() = FragmentPopularBinding.inflate(layoutInflater).apply {
        lifecycleOwner = this@PopularFragment
    }

    private fun injectDependencies() = PopularInjector.component.inject(this)

    private fun initializeUI() = with(binding) {
        popularList.layoutManager = GridLayoutManager(requireContext(), 2)
        popularList.adapter = adapter
        popularList.replaceItemDecoration(GridItemDecoration())
    }

    private fun initializeEvents() = with(binding) {
        popularList.onBottomReached {
            requestData(true)
        }
    }

    private fun initializeObservers() = with(viewModel) {
        state.observe(viewLifecycleOwner, getStateObserver())
    }

    private fun initializeData() = with(viewModel) {
        if (!hasMovies())
            requestData()
        else
            restore()
    }

    private fun requestData(addPage: Boolean = false) {
        binding.progressBar.visible()
        viewModel.getPopularMovies(addPage)
    }

    private fun getStateObserver() = Observer<PopularState> { state ->
        when (state) {
            is PopularState.OnMoviesReceived -> with(binding) {
                progressBar.gone()
                adapter.addMovies(state.movies)
            }
            is PopularState.OnMoviesFailed -> {
                Toast.makeText(
                    requireContext(),
                    state.exception.message ?: "unknown error",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }

}