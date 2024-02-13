package com.mayank.movies.ServiceImpl;

import com.mayank.movies.Repository.MovieRepository;
import com.mayank.movies.Service.MovieServices;
import com.mayank.movies.model.Movies;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieServices {

  @Autowired
  private MovieRepository movieRepository;

  @Override
  public List<Movies> getAllMovies() {
    return movieRepository.findAll();
  }

  @Override
  public Optional<Movies> getSingleMovie(String imdbId) {
    return movieRepository.findMovieByImdbId(imdbId);
  }
}
