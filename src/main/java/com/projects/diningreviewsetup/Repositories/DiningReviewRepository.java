package com.projects.diningreviewsetup.Repositories;
import com.projects.diningreviewsetup.model.DiningReview;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface DiningReviewRepository extends CrudRepository<DiningReview, Long> {
    Iterable<DiningReview> findByPeanutScore(Integer peanutScore);
    Iterable<DiningReview> findByEggScore(Integer eggScore);
    Iterable<DiningReview> findByDairyScore(Integer dairyScore);
}