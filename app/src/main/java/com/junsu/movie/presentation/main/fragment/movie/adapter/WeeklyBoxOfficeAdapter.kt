package com.junsu.movie.presentation.main.fragment.movie.adapter

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.junsu.movie.common.OnMovieItemClickListener
import com.junsu.movie.data.model.WeeklyBoxOfficeList
import com.junsu.movieapplication.databinding.ItemMovieBinding

class WeeklyBoxOfficeAdapter(
    private val onMovieItemClickListener: OnMovieItemClickListener,
    private var movies: ArrayList<WeeklyBoxOfficeList>? = arrayListOf()
) :
    RecyclerView.Adapter<WeeklyBoxOfficeAdapter.WeeklyBoxOfficeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeeklyBoxOfficeViewHolder {
        return WeeklyBoxOfficeViewHolder(
            ItemMovieBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: WeeklyBoxOfficeViewHolder, position: Int) {
        holder.bind(movies!![position])
    }

    override fun getItemCount(): Int {
        return movies!!.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateMovies(newMovies: ArrayList<WeeklyBoxOfficeList>) {
        movies = newMovies
        notifyDataSetChanged()
    }

    inner class WeeklyBoxOfficeViewHolder(private val binding: ItemMovieBinding) :
        RecyclerView.ViewHolder(binding.root) {

        @SuppressLint("SetTextI18n")
        fun bind(movie: WeeklyBoxOfficeList) {

            with(binding) {

                tvItemMovieRank.apply {
                    movie.rank.also {
                        when (it) {
                            "1" -> {
                                setTextColor(Color.YELLOW)
                            }
                            "2" -> {
                                setTextColor(Color.GRAY)
                            }
                            "3" -> {
                                setTextColor(Color.RED)
                            }
                            else -> {
                                setTextColor(Color.BLACK)
                            }
                        }
                        text = it
                    }
                }

                tvItemMovieTitle.apply {
                    this.text = movie.title
                    isSelected = true
                }

                tvItemMovieAudienceTerm.text = "?????? : ${movie.weeklyAudienceCount}???"
                tvItemMovieAudienceTotal.text = "?????? : ${movie.totalAudienceCount}???"

                root.setOnClickListener {
                    onMovieItemClickListener.onMovieItemClick(movie.movieCode)
                }
            }
        }
    }
}
