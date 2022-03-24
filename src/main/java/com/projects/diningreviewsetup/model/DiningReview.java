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
    @Column(name = "USERNAME")
    private String username;
    @Column(name = "RESTAURANT")
    private Long restaurant; // represented by the restaurant id
    @Column(name = "PEANUTSCORE")
    private Integer peanutScore;
    @Column(name = "EGGSCORE")
    private Integer eggScore;
    @Column(name = "DAIRYSCORE")
    private Integer dairyScore;
    @Column(name = "COMMENTARY")
    private String commentary;

    public DiningReview(String display_name, Long restaurant, Integer peanutScore, Integer eggScore, Integer dairyScore, String commentary) {
        this.username = display_name;
        this.restaurant = restaurant;
        this.peanutScore = peanutScore;
        this.eggScore = eggScore;
        this.dairyScore = dairyScore;
        this.commentary = commentary;
    }
}