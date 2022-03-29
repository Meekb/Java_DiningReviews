package com.projects.diningreviewsetup.Controller;
import com.projects.diningreviewsetup.Repositories.RestaurantRepository;
import com.projects.diningreviewsetup.model.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {

    @Autowired
    private RestaurantRepository restaurantRepository;

    // return Iterable with all restaurants
    @GetMapping()
    public Iterable<Restaurant> getAllRestaurants() {
        return this.restaurantRepository.findAll();
    }

//    @PostMapping("/restaurants")
//    public Restaurant createNewRestaurant(@RequestBody Restaurant restaurant) {
//
//    }

    // returns Optional restaurant with requested id
    @GetMapping("/{id}")
    public Optional<Restaurant> getRestaurantById(@PathVariable("id") Long id) {
        Optional<Restaurant> restaurantOptional = this.restaurantRepository.findById(id);
        if (restaurantOptional.isEmpty()) {
            System.out.print("Restaurant id does not exist");
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Restaurant id does not exist.");
        } else return restaurantOptional;
    }

    // returns Optional
    @GetMapping("/name_{name}")
    public Optional<Restaurant> getRestaurantByName(@PathVariable("name") String name) {
        Optional<Restaurant> restaurantOptional = this.restaurantRepository.findByNameContaining(name);
        if (restaurantOptional.isEmpty()) {
            System.out.print("No Restaurants found by that name.");
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No Restaurants found with that name.");
        } else return restaurantOptional;
    }

    // returns List of restaurants with overall rating greater than or equal to requested
    @GetMapping("/rating/overall_greaterthanequal_{overallRating}")
    public List<Restaurant> getByOverallRatingGreaterThanEqual(@PathVariable("overallRating") Double overallRating) {
        List<Restaurant> restaurantsToReturn = this.restaurantRepository.findByOverallRatingGreaterThanEqual(overallRating);
        if (restaurantsToReturn.isEmpty()) {
            System.out.print("Sorry, no restaurants found with that overall rating or better.");
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Sorry, no restaurants found with that overall rating or better.");
        } else return restaurantsToReturn;
    }

    // returns List of restaurants with peanut rating greater than or equal to requested
    @GetMapping("/rating/peanut_greaterthanequal_{peanutRating}")
    public List<Restaurant> getByPeanutRatingGreaterThanEqual(@PathVariable("peanutRating") Integer peanutRating) {
        List<Restaurant> restaurantsToReturn = this.restaurantRepository.findByPeanutRatingGreaterThanEqual(peanutRating);
        if (restaurantsToReturn.isEmpty()) {
            System.out.print("Sorry, no restaurants found with that peanut rating.");
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Sorry, no restaurants found with that peanut rating.");
        } else return restaurantsToReturn;
    }

    // returns List of restaurants with egg rating greater than or equal to requested
    @GetMapping("/rating/egg_greaterthanequal_{eggRating}")
    public List<Restaurant> getByEggRatingGreaterThanEqual(@PathVariable("eggRating") Integer eggRating) {
        List<Restaurant> restaurantsToReturn = this.restaurantRepository.findByEggRatingGreaterThanEqual(eggRating);
        if (restaurantsToReturn.isEmpty()) {
            System.out.print("Sorry, no restaurants found with that egg rating.");
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Sorry, no restaurants found with that egg rating.");
        } else return restaurantsToReturn;
    }

    // returns List of restaurants with dairy rating greater than or equal to requested
    @GetMapping("/rating/dairy_greaterthanequal_{dairyRating}")
    public List<Restaurant> getByDairyRatingGreaterThanEqual(@PathVariable("dairyRating") Integer dairyRating) {
        List<Restaurant> restaurantsToReturn = this.restaurantRepository.findByDairyRatingGreaterThanEqual(dairyRating);
        if (restaurantsToReturn.isEmpty()) {
            System.out.print("Sorry, no restaurants found with that dairy rating.");
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Sorry, no restaurants found with that dairy rating.");
        } else return restaurantsToReturn;
    }

}
