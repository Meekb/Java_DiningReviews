package com.projects.diningreviewsetup.Controller;
import com.projects.diningreviewsetup.Repositories.RestaurantRepository;
import com.projects.diningreviewsetup.model.Restaurant;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {
    private final RestaurantRepository restaurantRepository;

    public RestaurantController(final RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    // return Iterable with all restaurants
    @GetMapping()
    public Iterable<Restaurant> getAllRestaurants() {
        return this.restaurantRepository.findAll();
    }

    // returns Optional restaurant with requested id
    @GetMapping("/{id}")
    public Optional<Restaurant> getRestaurantById(@PathVariable("id") Long id) {
        if (id != null) {
            return this.restaurantRepository.findById(id);
        } else return Optional.empty();
    }

    // returns Optional
    @GetMapping("/byname/{name}")
    public List<Restaurant> getRestaurantByName(@PathVariable("name") String name) {
        if (name != null) {
            return this.restaurantRepository.findByNameContaining(name);
        } else return new ArrayList<>();
    }

    // returns List of restaurants with overall rating greater than or equal to requested
    @GetMapping("/rating/overall_greaterthanequal_{overallRating}")
    public List<Restaurant> getByOverallRatingGreaterThanEqual(@PathVariable("overallRating") Double overallRating) {
        if (overallRating != null) {
            return this.restaurantRepository.findByOverallRatingGreaterThanEqual(overallRating);
        } else return new ArrayList<>();
    }

    // returns List of restaurants with peanut rating greater than or equal to requested
    @GetMapping("/rating/peanut_greaterthanequal_{peanutRating}")
    public List<Restaurant> getByPeanutRatingGreaterThanEqual(@PathVariable("peanutRating") Integer peanutRating) {
        if (peanutRating != null) {
            return this.restaurantRepository.findByPeanutRatingGreaterThanEqual(peanutRating);
        } else return new ArrayList<>();
    }

    // returns List of restaurants with egg rating greater than or equal to requested
    @GetMapping("/rating/egg_greaterthanequal_{eggRating}")
    public List<Restaurant> getByEggRatingGreaterThanEqual(@PathVariable("eggRating") Integer eggRating) {
        if (eggRating != null) {
            return this.restaurantRepository.findByEggRatingGreaterThanEqual(eggRating);
        } else return new ArrayList<>();
    }

    // returns List of restaurants with dairy rating greater than or equal to requested
    @GetMapping("/rating/dairy_greaterthanequal_{dairyRating}")
    public List<Restaurant> getByDairyRatingGreaterThanEqual(@PathVariable("dairyRating") Integer dairyRating) {
        if (dairyRating != null) {
            return this.restaurantRepository.findByDairyRatingGreaterThanEqual(dairyRating);
        } else return new ArrayList<>();
    }

}
