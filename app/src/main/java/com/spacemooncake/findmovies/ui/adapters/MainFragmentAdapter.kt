package com.spacemooncake.findmovies.ui.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.spacemooncake.findmovies.R
import com.spacemooncake.findmovies.databinding.MainFragmentRecyclerItemBinding
import com.spacemooncake.findmovies.domain.entities.Film
import com.spacemooncake.findmovies.ui.main.MainFragment

class MainFragmentAdapter(private val itemClickListener: MainFragment.OnItemViewClickListener) :
    RecyclerView.Adapter<MainFragmentAdapter.MainViewHolder>() {

    private var filmsData: List<Film> = listOf()
    private lateinit var binding: MainFragmentRecyclerItemBinding

    @SuppressLint("NotifyDataSetChanged")
    fun setFilm(data: List<Film>) {
        filmsData = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        binding = MainFragmentRecyclerItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false)
        return MainViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind(filmsData[position])
    }

    override fun getItemCount() = filmsData.size

    inner class MainViewHolder(view: View) : RecyclerView.ViewHolder(view){
        fun bind(film: Film) = with(binding){
            poster.setImageResource(film.filmPoster)
            nameFilm.text = film.filmName
            dateFilm.text = film.filmDate
            rating.text = film.filmRating.toString()
            like.setImageResource(R.drawable.like)
            star.setImageResource(R.drawable.star)
            root.setOnClickListener{itemClickListener.onItemViewClick(film)}
        }
    }



}