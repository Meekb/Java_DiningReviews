package com.projects.diningreviewsetup.Repositories;
import com.projects.diningreviewsetup.model.Restaurant;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import java.util.List;
import java.util.Optional;

public interface RestaurantRepository extends CrudRepository<Restaurant, Long> {
    @Query("SELECT restaurant FROM Restaurant restaurant WHERE restaurant.name = 1")
    List<Restaurant> findByName(String name);
    List<Restaurant> findByOverallGreaterThanEqual(Double overallRating);
    List<Restaurant> findByPeanutGreaterThanEqual(Integer peanutRating);
    List<Restaurant> findByEggGreaterThanEqual(Integer eggRating);
    List<Restaurant> findByDairyGreaterThanEqual(Integer dairyRating);
}