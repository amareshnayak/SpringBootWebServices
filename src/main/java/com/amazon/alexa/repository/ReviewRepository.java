package com.amazon.alexa.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.amazon.alexa.domain.Review;

public interface ReviewRepository extends CrudRepository<Review, Long> {
	@Query(value = "select * from alexa where reviewed_date like CONCAT(:date,'%')", nativeQuery = true)
	    public Iterable<Review> findByReviewDate(@Param("date")String date);
	
	@Query(value = "select * from alexa where review_source like CONCAT('%',CONCAT(:store_type,'%'))", nativeQuery = true)
	public Iterable<Review> findByStoreType(@Param("store_type")String store_type);
	
	@Query(value = "select * from alexa where rating = :rating", nativeQuery = true)
    public Iterable<Review> findByRating(@Param("rating")int rating);
	
	
}
