package com.projects.diningreviewsetup.model;
import lombok.Data;
import javax.persistence.*;

@Entity
@Table(name = "RESTAURANTS")
public @Data
class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // scores will be 1-5, with 5 being the best
    // category score is the average of all submitted scores for category
    @Column(name = "RESTAURANT_NAME")
    private String restaurant_name;
    @Column(name = "PEANUT_SCORE")
    private Integer peanut_score;
    @Column(name = "EGG_SCORE")
    private Integer egg_score;
    @Column(name = "DAIRY_SCORE")
    private Integer dairy_score;
    // overall score is the average of all submitted scores for all categories
    @Column(name = "OVERALL_SCORE")
    private Double overall_score;
}
