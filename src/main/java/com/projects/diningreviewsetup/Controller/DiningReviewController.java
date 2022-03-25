package com.projects.diningreviewsetup.Controller;
import com.projects.diningreviewsetup.Repositories.DiningReviewRepository;
import com.projects.diningreviewsetup.model.DiningReview;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/reviews")
public class DiningReviewController {
    private final DiningReviewRepository diningReviewRepository;

    public DiningReviewController(final DiningReviewRepository diningReviewRepository) {
        this.diningReviewRepository = diningReviewRepository;
    }

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

    // returns review list with requested min peanut score
    @GetMapping("/peanut/score_greaterthanequal_{peanutScore}")
    public List<DiningReview> getReviewsByPeanutScoreGreaterThanEqual(@PathVariable("peanutScore") Integer peanutScore) {
        if (peanutScore != null) {
            return diningReviewRepository.findByPeanutScoreGreaterThanEqual(peanutScore);
        } else return new ArrayList<>();
    }

    // returns review list with requested min egg score
    @GetMapping("/egg/score_greaterthanequal_{eggScore}")
    public List<DiningReview> getReviewsByEggScoreGreaterThanEqual(@PathVariable("eggScore") Integer eggScore) {
        if (eggScore != null) {
            return diningReviewRepository.findByEggScoreGreaterThanEqual(eggScore);
        } else return new ArrayList<>();
    }

    // returns review list with requested min dairy score
    @GetMapping("/dairy/score_greaterthanequal_{dairyScore}")
    public List<DiningReview> getReviewsByDairyScoreGreaterThanEqual(@PathVariable("dairyScore") Integer dairyScore) {
        if (dairyScore != null) {
            return diningReviewRepository.findByDairyScoreGreaterThanEqual(dairyScore);
        } else return new ArrayList<>();
    }

}
