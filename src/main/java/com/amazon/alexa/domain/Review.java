package com.amazon.alexa.domain;

import javax.persistence.*;

@Entity
@Table(name = "alexa")
public class Review {
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    private Long id;
    @Column(columnDefinition = "text")
    private String review;
   @Column(columnDefinition = "text")
    private String author;
    @Column(columnDefinition = "text")
    private String review_source;
    @Column
    private int rating;
    @Column(columnDefinition = "text")
    private String title;
    @Column(columnDefinition = "text")
    private String product_name;
     @Column(columnDefinition = "text")
    private String reviewed_date;

    public Review() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getReview_source() {
		return review_source;
	}

	public void setReview_source(String review_source) {
		this.review_source = review_source;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getReviewed_date() {
		return reviewed_date;
	}

	public void setReviewed_date(String reviewed_date) {
		this.reviewed_date = reviewed_date;
	}
    
    

}
