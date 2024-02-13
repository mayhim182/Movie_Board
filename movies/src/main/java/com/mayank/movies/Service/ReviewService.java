package com.mayank.movies.Service;

import com.mayank.movies.model.Review;

public interface ReviewService {
  public Review createReview(String reviewBody, String imdbId);
}
