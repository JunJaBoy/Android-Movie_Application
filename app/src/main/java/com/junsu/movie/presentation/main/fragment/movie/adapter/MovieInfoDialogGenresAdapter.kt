package com.junsu.movie.presentation.main.fragment.movie.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.junsu.movie.data.model.MovieGenre
import com.junsu.movieapplication.databinding.ItemDialogMovieInfoBinding

class MovieInfoDialogGenresAdapter(
    private var genres: ArrayList<MovieGenre>? = arrayListOf()
) : RecyclerView.Adapter<MovieInfoDialogGenresAdapter.MovieInfoDialogGenresViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MovieInfoDialogGenresViewHolder {
        return MovieInfoDialogGenresViewHolder(
            ItemDialogMovieInfoBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: MovieInfoDialogGenresViewHolder, position: Int) {
        holder.bind(genres!![position])
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateActors(genres: ArrayList<MovieGenre>) {
        this.genres = genres
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return genres!!.size
    }

    class MovieInfoDialogGenresViewHolder(private val binding: ItemDialogMovieInfoBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(genre: MovieGenre) {

            with(binding) {
                tvItemDialogMovieInfo.text = genre.genre
            }
        }
    }
}