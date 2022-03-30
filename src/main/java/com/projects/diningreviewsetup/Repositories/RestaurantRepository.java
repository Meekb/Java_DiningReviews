package com.projects.diningreviewsetup.Repositories;
import com.projects.diningreviewsetup.model.Restaurant;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface RestaurantRepository extends CrudRepository<Restaurant, Long> {
    List<Restaurant> findAll(Sort name);
    List<Restaurant> findByNameContaining(String name);
    List<Restaurant> findByOverallRatingGreaterThanEqual(Double overallRating);
    List<Restaurant> findByPeanutRatingGreaterThanEqual(Integer peanutRating);
    List<Restaurant> findByEggRatingGreaterThanEqual(Integer eggRating);
    List<Restaurant> findByDairyRatingGreaterThanEqual(Integer dairyRating);
}