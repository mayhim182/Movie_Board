package com.mayank.movies.ServiceImpl;

import com.mayank.movies.Repository.ReviewRepository;
import com.mayank.movies.Service.ReviewService;
import com.mayank.movies.model.Movies;
import com.mayank.movies.model.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class ReviewServiceImpl implements ReviewService {

  @Autowired
  private ReviewRepository reviewRepository;

  @Autowired
  private MongoTemplate mongoTemplate;

  public Review createReview(String reviewBody, String imdbId){
    Review review = new Review(reviewBody);
    reviewRepository.insert(review);

    mongoTemplate.update(Movies.class)
      .matching(Criteria.where("imdbId").is(imdbId))
      .apply(new Update().push("reviewIds").value(review))
      .first();
    return review;
  }
}
