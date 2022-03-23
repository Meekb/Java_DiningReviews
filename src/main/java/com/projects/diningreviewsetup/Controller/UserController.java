package com.projects.diningreviewsetup.Controller;
import com.projects.diningreviewsetup.Repositories.UserRepository;
import com.projects.diningreviewsetup.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserRepository userRepository;

    public UserController(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping()
    public Iterable<User> getAllUsers() {
        return this.userRepository.findAll();
    }

}
