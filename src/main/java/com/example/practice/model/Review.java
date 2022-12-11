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
  private Integer alienId;
  private String review;
  private Integer rating;
  private String username;
  private String  createdAt;
  private String source;
  private String alienName;

  public Review(Integer userId, String review, Integer alienId, Integer rating) {
    this.userId = userId;
    this.review = review;
    this.alienId = alienId;
    this.rating = rating;
  }

  public Review(String source, String alienName,String review, Integer rating, String username, String createdAt) {
    this.source = source;
    this.alienName = alienName;
    this.review = review;
    this.rating = rating;
    this.username = username;
    this.createdAt = createdAt;
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
