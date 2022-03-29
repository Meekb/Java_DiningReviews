package com.projects.diningreviewsetup.Controller;
import com.projects.diningreviewsetup.Repositories.UserRepository;
import com.projects.diningreviewsetup.model.User;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserRepository userRepository;

    public UserController(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // returns all users
    @GetMapping()
    public Iterable<User> getAllUsers() {
        return this.userRepository.findAll();
    }

    // creates / saves a new user
    @PostMapping("/addNew")
    public User createUser(@RequestBody User user) {
        User newUser = this.userRepository.save(user);
        return newUser;
    }

    // returns user by id
    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable("id") Long id) {
       if (id != null) {
           return this.userRepository.findById(id);
       } else return Optional.empty();
    }

    // returns user by username
    @GetMapping("/username_{username}")
    public User findByUsername(@PathVariable("username") String username) {
        if (username != null) {
            return this.userRepository.getByUsername(username);
        } else return null;
    }

    // returns users with peanut allergy interest
    @GetMapping("/peanut_allergy")
    public Iterable <User> findByPeanutInterestTrue() {
        return this.userRepository.getByPeanutInterestTrue();
    }

    // returns users with egg allergy interest
    @GetMapping("/egg_allergy")
    public Iterable <User> findByEggInterestTrue() {
        return this.userRepository.getByEggInterestTrue();
    }

    // returns users with dairy allergy interest
    @GetMapping("/dairy_allergy")
    public Iterable <User> findByDairyInterestTrue() {
        return this.userRepository.getByDairyInterestTrue();
    }

}
