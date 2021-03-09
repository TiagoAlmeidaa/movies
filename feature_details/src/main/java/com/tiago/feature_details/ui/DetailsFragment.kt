package com.tiago.feature_details.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.tiago.common.extension.setupSharedElementEnterTransition
import com.tiago.common.viewmodel.ViewModelCreatorFactory
import com.tiago.feature_details.databinding.FragmentDetailsBinding
import com.tiago.feature_details.di.DetailsInjector
import com.tiago.feature_details.model.DetailsState
import com.tiago.feature_details.viewmodel.DetailsViewModel
import com.tiago.feature_details.viewmodel.DetailsViewModelFactory
import com.tiago.model.Movie
import com.tiago.network.util.Urls
import javax.inject.Inject

class DetailsFragment : Fragment() {

    @Inject
    internal lateinit var factory: DetailsViewModelFactory

    private val viewModel: DetailsViewModel by viewModels {
        ViewModelCreatorFactory(factory, this)
    }

    private val binding: FragmentDetailsBinding by lazy {
        initializeBinding()
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
        initializeObservers()
    }

    private fun initializeBinding() = FragmentDetailsBinding.inflate(layoutInflater).apply {
        lifecycleOwner = this@DetailsFragment
    }

    private fun injectDependencies() = DetailsInjector.component.inject(this)

    private fun initializeUI() {
        setupSharedElementEnterTransition(android.R.transition.move)
        viewModel.getMovieFrom(arguments)
    }

    private fun initializeObservers() = with(viewModel) {
        state.observe(viewLifecycleOwner, getStateObserver())
    }

    private fun getStateObserver() = Observer<DetailsState> { state ->
        when (state) {
            is DetailsState.OnMovieNotFound -> activity?.onBackPressed()
            is DetailsState.OnMovieReceived -> setMovieInformation(state.movie)
        }
    }

    private fun setMovieInformation(movie: Movie) = with(binding) {
        tvMovieTitle.text = movie.originalTitle
        tvMovieDescription.text = movie.overview
        Glide
            .with(root)
            .load("${Urls.posterUrl()}${movie.posterPath}")
            .into(ivMoviePoster)
    }
}