package com.projects.diningreviewsetup.Controller;
import com.projects.diningreviewsetup.Repositories.DiningReviewRepository;
import com.projects.diningreviewsetup.model.DiningReview;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DiningReviewController {
    private final DiningReviewRepository diningReviewRepository;

    public DiningReviewController(final DiningReviewRepository diningReviewRepository) {
        this.diningReviewRepository = diningReviewRepository;
    }

    @GetMapping("/reviews")
    public Iterable<DiningReview> getAllDiningReviews() {
        return this.diningReviewRepository.findAll();
    }
}
