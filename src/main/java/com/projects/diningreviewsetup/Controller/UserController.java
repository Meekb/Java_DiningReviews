package com.projects.diningreviewsetup.Controller;
import com.projects.diningreviewsetup.Repositories.UserRepository;
import com.projects.diningreviewsetup.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private final UserRepository userRepository;

    public UserController(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/users")
    public Iterable<User> getAllUsers() {
        return this.userRepository.findAll();
    }
}
