package com.amazon.alexa.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.amazon.alexa.domain.Review;
import com.amazon.alexa.service.ReviewService;

@RestController
@RequestMapping("/api/review")
public class ReviewController {

    private ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @RequestMapping(value="/search", method = RequestMethod.GET)
    public Iterable<Review> list() {
        return reviewService.list();
    }
    

    @RequestMapping(value="/search",params="review_date", method = RequestMethod.GET)
    @ResponseBody
    public Iterable<Review> getReviewDetailsByReviewDate(@RequestParam String review_date) {
    	System.out.println("-------------------------"+review_date);
      return reviewService.filterByDate(review_date);
    }
    
    
    @RequestMapping(value="/search",params="review_source", method = RequestMethod.GET)
    @ResponseBody
    public Iterable<Review> getReviewDetailsByStoreType(@RequestParam String review_source) {
    	System.out.println("-------------------------"+review_source);
      return reviewService.filterByStoreType(review_source);
    }
    
    @RequestMapping(value="/search",params="rating", method = RequestMethod.GET)
    @ResponseBody
    public Iterable<Review> getReviewDetailsByfindByRating(@RequestParam int rating) {
    	System.out.println("-------------------------"+rating);
      return reviewService.filterByRating(rating);
    }
}
