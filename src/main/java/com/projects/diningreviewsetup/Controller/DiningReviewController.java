package com.projects.diningreviewsetup.Controller;
import com.projects.diningreviewsetup.Repositories.DiningReviewRepository;
import com.projects.diningreviewsetup.model.DiningReview;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
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

    @GetMapping("/id/{id}")
    public Optional<DiningReview> getReviewById(@PathVariable("id") Long id) {
        Optional<DiningReview> result = this.diningReviewRepository.findById(id);
        if (result.isEmpty()) {
            System.out.println("That id does not exist");
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        } else return result;
    }

    @GetMapping("/peanut/{peanutScore}")
    public Iterable<DiningReview> getReviewByPeanutScore(@PathVariable("peanutScore") Integer peanutScore) {
        Iterable<DiningReview> matchingScores = diningReviewRepository.findByPeanutScore(peanutScore);
        if (matchingScores.toString().isEmpty()) {
            System.out.println("Sorry, no reviews with that peanut score were found.");
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        } else return matchingScores;
    }

    @GetMapping("/egg/{eggScore}")
    public Iterable<DiningReview> getReviewByEggScore(@PathVariable("eggScore") Integer eggScore) {
        Iterable<DiningReview> matchingScores = diningReviewRepository.findByEggScore(eggScore);
        if (matchingScores.toString().isEmpty()) {
            System.out.println("Sorry, no reviews with that egg score were found.");
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        } else return matchingScores;
    }

    @GetMapping("/dairy/{dairyScore}")
    public Iterable<DiningReview> getReviewsByDairyScore(@PathVariable("dairyScore") Integer dairyScore) {
        Iterable<DiningReview> matchingScores = diningReviewRepository.findByDairyScore(dairyScore);
        if (matchingScores.toString().isEmpty()) {
            System.out.println("Sorry, no reviews with that dairy score were found.");
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        } else return matchingScores;
    }

}
