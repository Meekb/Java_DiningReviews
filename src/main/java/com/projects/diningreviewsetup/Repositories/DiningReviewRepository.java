package com.projects.diningreviewsetup.Repositories;
//import com.projects.diningreviewsetup.model.DiningReview;
import com.projects.diningreviewsetup.model.DiningReview;
import com.projects.diningreviewsetup.model.Restaurant;
import org.springframework.data.repository.CrudRepository;

public interface DiningReviewRepository extends CrudRepository<DiningReview, Long> {
}