package com.projects.diningreviewsetup.model;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Entity
@Table(name = "RESTAURANTS")
public @Data
@NoArgsConstructor
class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // scores will be 1-5, with 5 being the best
    // category score is the average of all submitted scores for category
    @Column(name = "NAME")
    private String name;
    @Column(name = "PEANUTRATING")
    private Integer peanutRating;
    @Column(name = "EGGRATING")
    private Integer eggRating;
    @Column(name = "DAIRYRATING")
    private Integer dairyRating;
    // overall score is the average of all submitted scores for all categories
    @Column(name = "OVERALLRATING")
    private Double overallRating;

    public Restaurant(String name) {
        this.name = name;
        this.peanutRating = 0;
        this.eggRating = 0;
        this.dairyRating = 0;
        this.overallRating = 0.0;
    }
}
