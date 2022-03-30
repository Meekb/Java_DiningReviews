package com.projects.diningreviewsetup.Controller;
import com.projects.diningreviewsetup.Repositories.RestaurantRepository;
import com.projects.diningreviewsetup.model.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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

    // return Iterable of all restaurants in order of id
    @GetMapping()
    public Iterable<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }

    // return Iterable with all restaurants sorted by name A-Z
    @GetMapping("/sorted_names")
    public Iterable<Restaurant> getAllRestaurantsSorted() {
        return this.restaurantRepository.findAll(Sort.by("name"));
    }

    @PostMapping("/addNew")
    public Restaurant createNewRestaurant(@RequestBody Restaurant restaurant) {
        if (restaurantRepository.findByNameContaining(restaurant.getName()).isEmpty()) {
            Restaurant newRestaurant = restaurantRepository.save(restaurant);
            System.out.print("\nNew restaurant created! id: " +  newRestaurant.getId() + ", name: " + newRestaurant.getName());
            return newRestaurant;
        } else {
            System.out.print("\nRestaurant may already exist. How do I match restaurants with multi-word names?");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Restaurant may already exist...");
        }
    }

    // returns Optional restaurant with requested id
    @GetMapping("/{id}")
    public Optional<Restaurant> getRestaurantById(@PathVariable("id") Long id) {
        Optional<Restaurant> restaurantOptional = this.restaurantRepository.findById(id);
        if (restaurantOptional.isEmpty()) {
            System.out.print("\nRestaurant id does not exist");
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Restaurant id does not exist.");
        } else return restaurantOptional;
    }

    // returns name containing...more work needed on this one - restaurants with multi-word names
    @GetMapping("/name_{name}")
    public List<Restaurant> getRestaurantByName(@PathVariable("name") String name) {
//        List<Restaurant> restaurantOptional = this.restaurantRepository.findByNameContaining(name);
          List<Restaurant> restaurantList = restaurantRepository.findByNameContaining(name);
        if (restaurantList.isEmpty()) {
            System.out.print("\nNo Restaurants found with that name.");
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No Restaurants found with that name.");
        } else return restaurantList;
    }

    // returns List of restaurants with overall rating greater than or equal to requested
    @GetMapping("/overallRating_{overallRating}")
    public List<Restaurant> getByOverallGreaterThanEqual(@PathVariable("overallRating") Double overallRating) {
        List<Restaurant> restaurantsToReturn = this.restaurantRepository.findByOverallRatingGreaterThanEqual(overallRating);
        if (restaurantsToReturn.isEmpty()) {
            System.out.print("\nSorry, no restaurants found with that overall rating.");
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Sorry, no restaurants found with that overall rating.");
        } else return restaurantsToReturn;
    }

    // returns List of restaurants with peanut rating greater than or equal to requested
    @GetMapping("/peanutRating_{peanutRating}")
    public List<Restaurant> getByPeanutGreaterThanEqual(@PathVariable("peanutRating") Integer peanutRating) {
        List<Restaurant> restaurantsToReturn = this.restaurantRepository.findByPeanutRatingGreaterThanEqual(peanutRating);
        if (restaurantsToReturn.isEmpty()) {
            System.out.print("\nSorry, no restaurants found with that peanut rating.");
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Sorry, no restaurants found with that peanut rating.");
        } else return restaurantsToReturn;
    }

    // returns List of restaurants with egg rating greater than or equal to requested
    @GetMapping("/eggRating_{eggRating}")
    public List<Restaurant> getByEggGreaterThanEqual(@PathVariable("eggRating") Integer eggRating) {
        List<Restaurant> restaurantsToReturn = this.restaurantRepository.findByEggRatingGreaterThanEqual(eggRating);
        if (restaurantsToReturn.isEmpty()) {
            System.out.print("\nSorry, no restaurants found with that egg rating.");
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Sorry, no restaurants found with that egg rating.");
        } else return restaurantsToReturn;
    }

    // returns List of restaurants with dairy rating greater than or equal to requested
    @GetMapping("/dairyRating_{dairyRating}")
    public List<Restaurant> getByDairyGreaterThanEqual(@PathVariable("dairyRating") Integer dairyRating) {
        List<Restaurant> restaurantsToReturn = this.restaurantRepository.findByDairyRatingGreaterThanEqual(dairyRating);
        if (restaurantsToReturn.isEmpty()) {
            System.out.print("\nSorry, no restaurants found with that dairy rating.");
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Sorry, no restaurants found with that dairy rating.");
        } else return restaurantsToReturn;
    }

}
