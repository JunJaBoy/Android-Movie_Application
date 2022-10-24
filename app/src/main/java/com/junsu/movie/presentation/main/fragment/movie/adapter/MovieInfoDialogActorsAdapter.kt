package com.junsu.movie.presentation.main.fragment.movie.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.junsu.movie.data.model.MovieActor
import com.junsu.movieapplication.databinding.ItemDialogMovieInfoBinding

class MovieInfoDialogActorsAdapter(
    private var actors: ArrayList<MovieActor>? = arrayListOf()
) : RecyclerView.Adapter<MovieInfoDialogActorsAdapter.MovieInfoDialogViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieInfoDialogViewHolder {
        return MovieInfoDialogViewHolder(
            ItemDialogMovieInfoBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: MovieInfoDialogViewHolder, position: Int) {
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

    class MovieInfoDialogViewHolder(private val binding: ItemDialogMovieInfoBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(actor: MovieActor) {

            with(binding) {
                tvItemDialogMovieInfo.text = actor.actor
            }
        }
    }
}