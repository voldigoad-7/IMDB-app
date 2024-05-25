package singh.sumit.movies;


import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;
    private static final Logger LOGGER = LoggerFactory.getLogger(MovieService.class);


    public List<movie> findAllMovies() {
        LOGGER.info("Fetching all movies from MongoDB");
        List<movie> movies = movieRepository.findAll();
        LOGGER.info("Found {} movies", movies.size());
        return movies;
    }
    public Optional<movie> singleMovie(String imdbId) {
        return movieRepository.findMovieByImdbId(imdbId);
    }
}
