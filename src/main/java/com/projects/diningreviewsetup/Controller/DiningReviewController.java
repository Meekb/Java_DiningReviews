package com.projects.diningreviewsetup.Controller;
import com.projects.diningreviewsetup.Repositories.DiningReviewRepository;
import com.projects.diningreviewsetup.Repositories.RestaurantRepository;
import com.projects.diningreviewsetup.Repositories.UserRepository;
import com.projects.diningreviewsetup.model.DiningReview;
import com.projects.diningreviewsetup.model.AdminReviewStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.ArrayList;
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

    // returns all reviews in order of id by default
    @GetMapping()
    public Iterable<DiningReview> getAllDiningReviews() {
        return diningReviewRepository.findAll();
    }

    // returns all reviews sorted by username
    @GetMapping("/sorted_username")
    public Iterable<DiningReview> getAllDiningReviewsSorted() {
        return diningReviewRepository.findAll(Sort.by("username"));
    }

    // returns review by specified id
    @GetMapping("/{id}")
    public Optional<DiningReview> getReviewById(@PathVariable("id") Long id) {
        if (id != null) {
            return diningReviewRepository.findById(id);
        } else return Optional.empty();
    }

    // creates and saves new DiningReview with checks for invalid user and restaurant ids
    @PostMapping("/addNew")
    public DiningReview createNewDiningReview(@RequestBody DiningReview diningReview) {
        if (restaurantRepository.findById(diningReview.getRestaurant()).isEmpty()) {
            System.out.print("\nRestaurant does not exist");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Restaurant does not exist");
        }
        if (userRepository.getByUsername(diningReview.getUsername()) == null) {
            System.out.print("\nUser does not exist");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User does not exist");
        }
        DiningReview newReview = diningReview;
        newReview.setAdminReviewStatus(AdminReviewStatus.PENDING);
        return diningReviewRepository.save(newReview);
    }

    // The following three endpoints return an Iterable of reviews by AdminReviewStatus Pending, Approved, Rejected
    @GetMapping("/pending")
    public Iterable<DiningReview> getPendingReviews() {
        return diningReviewRepository.findByAdminReviewStatus(AdminReviewStatus.PENDING);
    }
    @GetMapping("/approved")
    public Iterable<DiningReview> getApprovedReviews() {
        return diningReviewRepository.findByAdminReviewStatus(AdminReviewStatus.APPROVED);
    }
    @GetMapping("/rejected")
    public Iterable<DiningReview> getRejectedReviews() {
        return diningReviewRepository.findByAdminReviewStatus(AdminReviewStatus.REJECTED);
    }

    @PutMapping("/admin_approve/{id}")
    public DiningReview approveReview(@PathVariable("id") Long id) {
        Optional<DiningReview> reviewToChangeOptional = diningReviewRepository.findById(id);
        if (reviewToChangeOptional.isEmpty()) {
            System.out.print("\nReview does not exist");
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Review id does not exist");
        } else {
            DiningReview reviewToChange = reviewToChangeOptional.get();
            reviewToChange.setAdminReviewStatus(AdminReviewStatus.APPROVED);
            diningReviewRepository.save(reviewToChange);
            return reviewToChange;
        }
    }

    @PutMapping("/admin_reject/{id}")
    public DiningReview rejectReview(@PathVariable("id") Long id) {
        Optional<DiningReview> reviewToChangeOptional = diningReviewRepository.findById(id);
        if (reviewToChangeOptional.isEmpty()) {
            System.out.print("\nReview does not exist");
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Review id does not exist");
        } else {
            DiningReview reviewToChange = reviewToChangeOptional.get();
            reviewToChange.setAdminReviewStatus(AdminReviewStatus.REJECTED);
            diningReviewRepository.save(reviewToChange);
            return reviewToChange;
        }
    }

    @DeleteMapping("/delete_rejected/{id}")
    public DiningReview deleteRejectedDiningReview(@PathVariable("id") Long id) {
        Optional<DiningReview> reviewToDeleteOptional = diningReviewRepository.findById(id);
        if (!reviewToDeleteOptional.isPresent()) {
            return null;
        }
        DiningReview reviewToDelete = reviewToDeleteOptional.get();
        diningReviewRepository.delete(reviewToDelete);
        System.out.print("\nid: " + id + " has been successfully deleted");
        return reviewToDelete;
    }

    // returns review list with requested min peanut score
    @GetMapping("/peanutScore_{peanutScore}")
    public Iterable<DiningReview> getReviewsByPeanutScoreGreaterThanEqual(@PathVariable("peanutScore") Integer peanutScore) {
        if (peanutScore != null) {
            return diningReviewRepository.findByPeanutScoreGreaterThanEqual(peanutScore);
        } else return new ArrayList<>();
    }

    // returns review list with requested min egg score
    @GetMapping("/eggScore_{eggScore}")
    public Iterable<DiningReview> getReviewsByEggScoreGreaterThanEqual(@PathVariable("eggScore") Integer eggScore) {
        if (eggScore != null) {
            return diningReviewRepository.findByEggScoreGreaterThanEqual(eggScore);
        } else return new ArrayList<>();
    }

    // returns review list with requested min dairy score
    @GetMapping("/dairyScore_{dairyScore}")
    public Iterable<DiningReview> getReviewsByDairyScoreGreaterThanEqual(@PathVariable("dairyScore") Integer dairyScore) {
        Iterable<DiningReview> resultList = diningReviewRepository.findByDairyScoreGreaterThanEqual(dairyScore);
        if (resultList != null) {
            return diningReviewRepository.findByDairyScoreGreaterThanEqual(dairyScore);
        } else return new ArrayList<>();
    }

}
