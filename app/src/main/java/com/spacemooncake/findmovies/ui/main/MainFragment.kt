package com.spacemooncake.findmovies.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.spacemooncake.findmovies.R
import com.spacemooncake.findmovies.databinding.MainFragmentBinding
import com.spacemooncake.findmovies.domain.entities.AppState
import com.spacemooncake.findmovies.domain.entities.Film
import com.spacemooncake.findmovies.ui.adapters.MainFragmentAdapter
import com.spacemooncake.findmovies.ui.details.DetailsFilmFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : Fragment() {
    private val viewModel: MainViewModel by viewModel()
    private var _binding: MainFragmentBinding? = null
    private val binding get() = _binding!!

    private var adapter: MainFragmentAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = MainFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            mainFragmentRecyclerView.adapter = adapter
            val observer = Observer<AppState> { renderData(it) }
            viewModel.liveData.observe(viewLifecycleOwner, observer)
            viewModel.getFilmsFromLocalSource()
        }
    }


    private fun renderData(appState: AppState) = with(binding) {
        when (appState) {
            is AppState.Success -> {
                adapter = MainFragmentAdapter(object : OnItemViewClickListener {
                    override fun onItemViewClick(film: Film) {
                        openFilmDetails(film)
                    }
                }).apply {
                    setFilm(appState.filmData)
                }
                mainFragmentRecyclerView.adapter = adapter
                mainFragmentRecyclerView.layoutManager = GridLayoutManager(context, 2)
            }
            is AppState.Loading -> {
                //TODO
            }
            is AppState.Error -> {
                //TODO
            }
        }

    }

    private fun openFilmDetails(film: Film){
        val manager = activity?.supportFragmentManager
        manager?.let{ manager ->
            val bundle = Bundle().apply{
                putParcelable(DetailsFilmFragment.BUNDLE_EXTRA, film)
            }
            manager.beginTransaction()
                .add(R.id.container, DetailsFilmFragment.newInstance(bundle))
                .addToBackStack("")
                .commitAllowingStateLoss()
        }
    }

    interface OnItemViewClickListener {
        fun onItemViewClick(film: Film)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        fun newInstance() = MainFragment()
    }
}