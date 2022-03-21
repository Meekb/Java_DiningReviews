package com.projects.diningreviewsetup.model;
import lombok.*;
import javax.persistence.*;

@Entity
@Table(name = "REVIEWS")
public @Data
class DiningReview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String user;
    private Long restaurant; // represented by the restaurant id
    private Integer peanut_score;
    private Integer egg_score;
    private Integer dairy_score;
    private String commentary;
}