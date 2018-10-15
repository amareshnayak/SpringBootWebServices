package com.amazon.alexa.service;

import org.springframework.stereotype.Service;

import com.amazon.alexa.domain.Review;
import com.amazon.alexa.repository.ReviewRepository;

import java.util.List;

@Service
public class ReviewService {

	private ReviewRepository reviewRepository;

	public ReviewService(ReviewRepository reviewRepository) {
		this.reviewRepository = reviewRepository;
	}

	public Iterable<Review> list() {
		return reviewRepository.findAll();
	}

	public Iterable<Review> filterByDate(String date) {
		System.out.println("inside my service------" + date);
		return reviewRepository.findByReviewDate(date);
	}

	public Iterable<Review> filterByStoreType(String store_type) {
		System.out.println("inside my service------" + store_type);
		return reviewRepository.findByStoreType(store_type);
	}

	public Iterable<Review> filterByRating(int rating) {
		System.out.println("inside my service------" + rating);
		
		return reviewRepository.findByRating(rating);
	}

	public Review save(Review user) {
		return reviewRepository.save(user);
	}

	public void save(List<Review> users) {
		reviewRepository.save(users);
	}
}
