package com.junsu.movie.presentation.main.fragment.movie.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.junsu.movie.data.model.MovieDirector
import com.junsu.movieapplication.databinding.ItemDialogMovieInfoBinding

class MovieInfoDialogDirectorsAdapter(
    private var directors: ArrayList<MovieDirector>? = arrayListOf()
) : RecyclerView.Adapter<MovieInfoDialogDirectorsAdapter.MovieInfoDialogDirectorsViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MovieInfoDialogDirectorsViewHolder {
        return MovieInfoDialogDirectorsViewHolder(
            ItemDialogMovieInfoBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: MovieInfoDialogDirectorsViewHolder, position: Int) {
        holder.bind(directors!![position])
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateDirectors(directors: ArrayList<MovieDirector>) {
        this.directors = directors
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return directors!!.size
    }

    class MovieInfoDialogDirectorsViewHolder(private val binding: ItemDialogMovieInfoBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(director: MovieDirector) {

            with(binding) {
                tvItemDialogMovieInfo.text = director.director
            }
        }
    }
}