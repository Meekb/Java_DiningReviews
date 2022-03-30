package com.projects.diningreviewsetup.Repositories;
import com.projects.diningreviewsetup.model.AdminReviewStatus;
import com.projects.diningreviewsetup.model.DiningReview;
import org.springframework.data.repository.CrudRepository;

public interface DiningReviewRepository extends CrudRepository<DiningReview, Long> {
    Iterable<DiningReview> findByAdminReviewStatus(AdminReviewStatus adminReviewStatus);
    Iterable<DiningReview> findByPeanutScoreGreaterThanEqual(Integer peanutScore);
    Iterable<DiningReview> findByEggScoreGreaterThanEqual(Integer eggScore);
    Iterable<DiningReview> findByDairyScoreGreaterThanEqual(Integer dairyScore);
}