package com.projects.diningreviewsetup.Repositories;
import com.projects.diningreviewsetup.model.DiningReview;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface DiningReviewRepository extends CrudRepository<DiningReview, Long> {
    List<DiningReview> findByPeanutScore(Integer peanutScore);
    List<DiningReview> findByPeanutScoreGreaterThanEqual(Integer peanutScore);
    List<DiningReview> findByEggScore(Integer eggScore);
    List<DiningReview> findByEggScoreGreaterThanEqual(Integer eggScore);
    List<DiningReview> findByDairyScore(Integer dairyScore);
    List<DiningReview> findByDairyScoreGreaterThanEqual(Integer dairyScore);
}