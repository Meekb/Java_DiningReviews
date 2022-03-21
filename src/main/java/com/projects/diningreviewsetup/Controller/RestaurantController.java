package com.projects.diningreviewsetup.Controller;
import com.projects.diningreviewsetup.Repositories.RestaurantRepository;
import com.projects.diningreviewsetup.model.Restaurant;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestaurantController {
    private final RestaurantRepository restaurantRepository;

    public RestaurantController(final RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    @GetMapping("/restaurants")
    public Iterable<Restaurant> getAllRestaurants() {
        return this.restaurantRepository.findAll();
    }
}
