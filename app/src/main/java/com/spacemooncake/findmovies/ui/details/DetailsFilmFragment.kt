package com.spacemooncake.findmovies.ui.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.spacemooncake.findmovies.R
import com.spacemooncake.findmovies.databinding.DetailsFilmFragmentBinding
import com.spacemooncake.findmovies.model.entities.Film

class DetailsFilmFragment : Fragment() {
    private var _binding : DetailsFilmFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
        _binding = DetailsFilmFragmentBinding.inflate(inflater, container, false )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.getParcelable<Film>(BUNDLE_EXTRA)?.let{
            renderData(it)
        }
    }

    private fun renderData(film: Film) {
        with(binding){
            poster.setImageResource(film.filmPoster)
            nameFilm.text = film.filmName
            dateFilm.text = film.filmDate
            rating.text = film.filmRating.toString()
            like.setImageResource(R.drawable.like)
            star.setImageResource(R.drawable.star)
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        const val BUNDLE_EXTRA = "film"
        fun newInstance(bundle: Bundle) : DetailsFilmFragment {
            val fragment =DetailsFilmFragment()
            fragment.arguments = bundle
            return fragment
        }
    }
}