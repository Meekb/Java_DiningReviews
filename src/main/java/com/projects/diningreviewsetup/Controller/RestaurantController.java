package com.projects.diningreviewsetup.Controller;
import com.projects.diningreviewsetup.Repositories.RestaurantRepository;
import com.projects.diningreviewsetup.model.Restaurant;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.Optional;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {
    private final RestaurantRepository restaurantRepository;

    public RestaurantController(final RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    @GetMapping()
    public Iterable<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }

    @GetMapping(path="/id/{id}")
    public Optional<Restaurant> getRestaurantById(@PathVariable("id") Long id) {
        Optional<Restaurant> result = this.restaurantRepository.findById(id);
        if (result.isEmpty()) {
            System.out.println("Restaurant id does not exist");
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        } else return result;
    }

    @GetMapping(path="/name/{name}")
    public Optional<Restaurant> getRestaurantByName(@PathVariable("name") String name) {
        Optional<Restaurant> result = restaurantRepository.findByName(name);
        if (result.toString().isEmpty()) {
            System.out.println("Restaurant name does not exist");
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        } else return result;
    }


}
