package com.junsu.movie.presentation.main.fragment.movie.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.junsu.movie.data.model.MovieActor
import com.junsu.movieapplication.databinding.ItemDialogMovieInfoBinding

class MovieInfoDialogActorsAdapter(
    private var actors: ArrayList<MovieActor>? = arrayListOf()
) : RecyclerView.Adapter<MovieInfoDialogActorsAdapter.MovieInfoDialogActorsViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MovieInfoDialogActorsViewHolder {
        return MovieInfoDialogActorsViewHolder(
            ItemDialogMovieInfoBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: MovieInfoDialogActorsViewHolder, position: Int) {
        holder.bind(actors!![position])
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateActors(actors: ArrayList<MovieActor>) {
        this.actors = actors
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return actors!!.size
    }

    inner class MovieInfoDialogActorsViewHolder(private val binding: ItemDialogMovieInfoBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(actor: MovieActor) {

            with(binding) {
                tvItemDialogMovieInfo.text = actor.actor
            }
        }
    }
}