package com.projects.diningreviewsetup.Controller;
import com.projects.diningreviewsetup.Repositories.DiningReviewRepository;
import com.projects.diningreviewsetup.Repositories.RestaurantRepository;
import com.projects.diningreviewsetup.Repositories.UserRepository;
import com.projects.diningreviewsetup.model.DiningReview;
import com.projects.diningreviewsetup.model.AdminReviewStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/reviews")
public class DiningReviewController {

    @Autowired
    private DiningReviewRepository diningReviewRepository;
    @Autowired
    private RestaurantRepository restaurantRepository;
    @Autowired
    private UserRepository userRepository;

    // returns all dining reviews
    @GetMapping()
    public Iterable<DiningReview> getAllDiningReviews() {
        return this.diningReviewRepository.findAll();
    }

    // returns review by id
    @GetMapping("/{id}")
    public Optional<DiningReview> getReviewById(@PathVariable("id") Long id) {
        if (id != null) {
            return diningReviewRepository.findById(id);
        } else return Optional.empty();
    }

    // The following three endpoints return an Iterable of reviews by AdminReviewStatus Pending, Approved, Rejected
    @GetMapping("/pending")
    public Iterable<DiningReview> getPendingReviews() {
        return this.diningReviewRepository.findByAdminReviewStatus(AdminReviewStatus.PENDING);
    }
    @GetMapping("/approved")
    public Iterable<DiningReview> getApprovedReviews() {
        return this.diningReviewRepository.findByAdminReviewStatus(AdminReviewStatus.APPROVED);
    }
    @GetMapping("/rejected")
    public Iterable<DiningReview> getRejectedReviews() {
        return this.diningReviewRepository.findByAdminReviewStatus(AdminReviewStatus.REJECTED);
    }

    // returns review list with requested min peanut score
    @GetMapping("/peanut/score_greaterthanequal_{peanutScore}")
    public Iterable<DiningReview> getReviewsByPeanutScoreGreaterThanEqual(@PathVariable("peanutScore") Integer peanutScore) {
        if (peanutScore != null) {
            return diningReviewRepository.findByPeanutScoreGreaterThanEqual(peanutScore);
        } else return new ArrayList<>();
    }

    // returns review list with requested min egg score
    @GetMapping("/egg/score_greaterthanequal_{eggScore}")
    public Iterable<DiningReview> getReviewsByEggScoreGreaterThanEqual(@PathVariable("eggScore") Integer eggScore) {
        if (eggScore != null) {
            return diningReviewRepository.findByEggScoreGreaterThanEqual(eggScore);
        } else return new ArrayList<>();
    }

    // returns review list with requested min dairy score
    @GetMapping("/dairy/score_greaterthanequal_{dairyScore}")
    public Iterable<DiningReview> getReviewsByDairyScoreGreaterThanEqual(@PathVariable("dairyScore") Integer dairyScore) {
        if (dairyScore != null) {
            return diningReviewRepository.findByDairyScoreGreaterThanEqual(dairyScore);
        } else return new ArrayList<>();
    }

}
