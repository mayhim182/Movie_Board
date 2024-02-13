package com.mayank.movies.Service;

import com.mayank.movies.model.Movies;
import org.bson.types.ObjectId;

import java.util.List;
import java.util.Optional;

public interface MovieServices {
  public List<Movies> getAllMovies();

  public Optional<Movies> getSingleMovie(String imdbId);
}
