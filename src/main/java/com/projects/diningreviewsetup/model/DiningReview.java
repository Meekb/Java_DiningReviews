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
    @Column(name = "REVIEW_STATUS")
    @Enumerated(EnumType.STRING)
    private AdminReviewStatus adminReviewStatus;

}