package com.projects.diningreviewsetup.Repositories;
import com.projects.diningreviewsetup.model.AdminReviewStatus;
import com.projects.diningreviewsetup.model.DiningReview;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface DiningReviewRepository extends CrudRepository<DiningReview, Long> {
    List<DiningReview> findAll(Sort username);
    Iterable<DiningReview> findByAdminReviewStatus(AdminReviewStatus adminReviewStatus);
    Iterable<DiningReview> findByPeanutScoreGreaterThanEqual(Integer peanutScore);
    Iterable<DiningReview> findByEggScoreGreaterThanEqual(Integer eggScore);
    Iterable<DiningReview> findByDairyScoreGreaterThanEqual(Integer dairyScore);
}