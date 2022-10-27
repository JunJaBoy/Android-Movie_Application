import androidx.annotation.WorkerThread
import com.junsu.movie.data.local.favoriteMovieDB
import com.junsu.movie.data.model.MovieEntity

class MyPageRepository {

    @WorkerThread
    suspend fun getAllFavoriteMovies(): ArrayList<MovieEntity> {
        return favoriteMovieDB!!.movieDAO().getAll() as ArrayList<MovieEntity>
    }

    @WorkerThread
    suspend fun deleteFavoriteMovie(movieEntity: MovieEntity) {
        return favoriteMovieDB!!.movieDAO().delete(movieEntity)
    }
}