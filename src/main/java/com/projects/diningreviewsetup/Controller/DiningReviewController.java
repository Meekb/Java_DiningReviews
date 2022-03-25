package com.projects.diningreviewsetup.Controller;
import com.projects.diningreviewsetup.Repositories.DiningReviewRepository;
import com.projects.diningreviewsetup.model.DiningReview;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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

    @GetMapping()
    public Iterable<DiningReview> getAllDiningReviews() {
        return this.diningReviewRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<DiningReview> getReviewById(@PathVariable("id") Long id) {
        Optional<DiningReview> result = this.diningReviewRepository.findById(id);
        if (result.isEmpty()) {
            System.out.println("That id does not exist");
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        } else return result;
    }

    @GetMapping("/allergy/peanut_score_{peanutScore}")
    public List<DiningReview> getReviewByPeanutScore(@PathVariable("peanutScore") Integer peanutScore) {
        if (peanutScore != null) {
            return diningReviewRepository.findByPeanutScore(peanutScore);
        } else return new ArrayList<>();
    }

    @GetMapping("/allergy/egg_score_{eggScore}")
    public List<DiningReview> getReviewByEggScore(@PathVariable("eggScore") Integer eggScore) {
        if (eggScore != null) {
            return diningReviewRepository.findByEggScore(eggScore);
        } else return new ArrayList<>();
    }

    @GetMapping("/allergy/dairy_score_{dairyScore}")
    public List<DiningReview> getReviewsByDairyScore(@PathVariable("dairyScore") Integer dairyScore) {
        if (dairyScore != null) {
            return diningReviewRepository.findByDairyScore(dairyScore)
        } else return new ArrayList<>();
    }

}
