package com.example.practice.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Review {

  private Integer id;
  private Integer userId;
  private String review;
  private Integer alienId;
  private Integer rating;

  private String  createdAt;

  public Review(Integer userId, String review, Integer alienId, Integer rating) {
    this.userId = userId;
    this.review = review;
    this.alienId = alienId;
    this.rating = rating;
  }

  public Review(Integer id, Integer userId, String review, Integer alienId, Integer rating) {
    this.id = id;
    this.userId = userId;
    this.review = review;
    this.alienId = alienId;
    this.rating = rating;
  }

  public Review(String review, Integer rating) {
    this.review = review;
    this.rating = rating;
  }
}
