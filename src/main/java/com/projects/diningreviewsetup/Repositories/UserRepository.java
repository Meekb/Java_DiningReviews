package com.projects.diningreviewsetup.Repositories;
import com.projects.diningreviewsetup.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}