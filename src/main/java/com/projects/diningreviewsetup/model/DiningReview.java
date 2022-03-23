package com.projects.diningreviewsetup.model;
import lombok.*;
import javax.persistence.*;

@Entity
@Table(name = "REVIEWS")
public @Data
@NoArgsConstructor
class DiningReview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private Long restaurant; // represented by the restaurant id
    private Integer peanut_score;
    private Integer egg_score;
    private Integer dairy_score;
    private String commentary;

    public DiningReview(String display_name, Long restaurant, Integer peanut_score, Integer egg_score, Integer dairy_score, String commentary) {
        this.username = display_name;
        this.restaurant = restaurant;
        this.peanut_score = peanut_score;
        this.egg_score = egg_score;
        this.dairy_score = dairy_score;
        this.commentary = commentary;
    }
}