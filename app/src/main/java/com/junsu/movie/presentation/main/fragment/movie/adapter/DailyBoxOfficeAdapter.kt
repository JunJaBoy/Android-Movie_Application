package com.junsu.movie.presentation.main.fragment.movie.adapter

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.junsu.movie.common.OnMovieItemClickListener
import com.junsu.movie.data.model.DailyBoxOfficeList
import com.junsu.movieapplication.databinding.ItemMovieBinding

class DailyBoxOfficeAdapter(
    private val onMovieItemClickListener: OnMovieItemClickListener,
    private var movies: ArrayList<DailyBoxOfficeList>? = arrayListOf()
) :
    RecyclerView.Adapter<DailyBoxOfficeAdapter.DailyBoxOfficeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DailyBoxOfficeViewHolder {
        return DailyBoxOfficeViewHolder(
            ItemMovieBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: DailyBoxOfficeViewHolder, position: Int) {
        holder.bind(movies!![position])
    }

    override fun getItemCount(): Int {
        return movies!!.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateMovies(newMovies: ArrayList<DailyBoxOfficeList>) {
        movies = newMovies
        notifyDataSetChanged()
    }

    inner class DailyBoxOfficeViewHolder(private val binding: ItemMovieBinding) :
        RecyclerView.ViewHolder(binding.root) {

        @SuppressLint("SetTextI18n")
        fun bind(movie: DailyBoxOfficeList) {

            with(binding) {
                tvItemMovieRank.text = movie.rank
                when (movie.rank) {
                    "1" -> {
                        this.tvItemMovieRank.setTextColor(Color.YELLOW)
                    }
                    "2" -> {
                        this.tvItemMovieRank.setTextColor(Color.GRAY)
                    }
                    "3" -> {
                        this.tvItemMovieRank.setTextColor(Color.RED)
                    }
                    else -> {
                        this.tvItemMovieRank.setTextColor(Color.BLACK)
                    }
                }
                with(tvItemMovieTitle) {
                    this.text = movie.title
                    isSelected = true
                }
                tvItemMovieAudienceTerm.text = "오늘 : ${movie.dailyAudienceCount}명"
                tvItemMovieAudienceTotal.text = "전체 : ${movie.totalAudienceCount}명"

                root.setOnClickListener {
                    onMovieItemClickListener.onMovieItemClick(binding.root, movie.movieCode)
                }
            }
        }
    }
}