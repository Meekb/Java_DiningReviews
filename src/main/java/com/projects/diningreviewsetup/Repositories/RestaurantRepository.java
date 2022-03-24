package com.projects.diningreviewsetup.Repositories;
import com.projects.diningreviewsetup.model.Restaurant;
import org.springframework.data.repository.CrudRepository;
import java.util.Optional;


public interface RestaurantRepository extends CrudRepository<Restaurant, Long> {
//    Optional<Restaurant> findByName(String name);
}