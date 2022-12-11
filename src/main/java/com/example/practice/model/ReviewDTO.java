package com.example.practice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewDTO {
    private String source;
    private String alien_name;
    private String review;
    private Integer rating;
    private String username;
    private String date;
}
