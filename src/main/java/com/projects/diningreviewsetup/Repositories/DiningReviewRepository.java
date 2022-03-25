package com.projects.diningreviewsetup.Repositories;
import com.projects.diningreviewsetup.model.DiningReview;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface DiningReviewRepository extends CrudRepository<DiningReview, Long> {

    List<DiningReview> findByPeanutScoreGreaterThanEqual(Integer peanutScore);

    List<DiningReview> findByEggScoreGreaterThanEqual(Integer eggScore);

    List<DiningReview> findByDairyScoreGreaterThanEqual(Integer dairyScore);

}