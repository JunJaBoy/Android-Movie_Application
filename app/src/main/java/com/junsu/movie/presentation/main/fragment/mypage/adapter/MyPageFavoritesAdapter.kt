package com.junsu.movie.presentation.main.fragment.mypage.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.junsu.movie.common.OnFavoriteItemClickListener
import com.junsu.movie.data.model.MovieEntity
import com.junsu.movieapplication.databinding.ItemMypageFavoriteBinding

class MyPageFavoritesAdapter(
    private val onFavoriteItemClickListener: OnFavoriteItemClickListener,
    private var favoriteMovies: ArrayList<MovieEntity>? = arrayListOf(),
) :
    RecyclerView.Adapter<MyPageFavoritesAdapter.MyPageFavoritesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyPageFavoritesViewHolder {
        return MyPageFavoritesViewHolder(
            ItemMypageFavoriteBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MyPageFavoritesViewHolder, position: Int) {
        holder.bind(favoriteMovies!![position])
    }

    override fun getItemCount(): Int {
        return favoriteMovies!!.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateFavoriteMovies(favoriteMovies: ArrayList<MovieEntity>) {
        this.favoriteMovies = favoriteMovies
        notifyDataSetChanged()
    }

    inner class MyPageFavoritesViewHolder(private val binding: ItemMypageFavoriteBinding) :
        RecyclerView.ViewHolder(binding.root) {

        @SuppressLint("SetTextI18n")
        fun bind(favoriteMovie: MovieEntity) {
            with(binding) {

                tvMypageItemTitle.text = favoriteMovie.title
                tvMypageItemCreatedAt.text = "Created At ${favoriteMovie.createdAt}"
                btnMypageItemDeleteFavorite.setOnClickListener {
                    onFavoriteItemClickListener.onDeleteFavoriteItemClick(binding.btnMypageItemDeleteFavorite)
                }
            }
        }
    }
}