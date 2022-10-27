import com.junsu.movie.data.local.favoriteMovieDB
import com.junsu.movie.data.model.MovieEntity

class MyPageRepository {

    suspend fun getAllFavoriteMovies(): ArrayList<MovieEntity> {
        return favoriteMovieDB!!.movieDAO().getAll() as ArrayList<MovieEntity>
    }
}