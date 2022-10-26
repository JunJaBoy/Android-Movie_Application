import com.junsu.movie.data.local.FavoriteMovieDB
import com.junsu.movie.data.model.MovieEntity

class MyPageRepository {

    suspend fun getAllFavoriteMovies(dataBase: FavoriteMovieDB): ArrayList<MovieEntity> {
        return dataBase.movieDAO().getAll()
    }
}