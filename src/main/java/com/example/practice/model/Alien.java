package com.example.practice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Alien {
  private Integer id;
  private String alienName;
  private String source;
  private String createdBy;
  private String createdAt;
  private String imageUrl;

  public Alien(String alienName, String source, String createdBy, String imageUrl) {
    this.alienName = alienName;
    this.source = source;
    this.createdBy = createdBy;
    this.imageUrl = imageUrl;
  }

  public Alien(Integer id, String alienName, String source, String imageUrl) {
    this.id = id;
    this.alienName = alienName;
    this.source = source;
    this.imageUrl = imageUrl;
  }
}
