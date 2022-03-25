package com.projects.diningreviewsetup.Repositories;
import com.projects.diningreviewsetup.model.Restaurant;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface RestaurantRepository extends CrudRepository<Restaurant, Long> {
    List<Restaurant> findByOverallRatingGreaterThanEqual(Double overallRating);
    List<Restaurant> findByPeanutRatingGreaterThanEqual(Integer peanutRating);
    List<Restaurant> findByEggRatingGreaterThanEqual(Integer eggRating);
    List<Restaurant> findByDairyRatingGreaterThanEqual(Integer dairyRating);
}