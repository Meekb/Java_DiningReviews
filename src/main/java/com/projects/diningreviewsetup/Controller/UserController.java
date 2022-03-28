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

    // returns user by id
    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable("id") Long id) {
       if (id != null) {
           return this.userRepository.findById(id);
       } else return Optional.empty();
    }

    // returns user by username
    @GetMapping("/username/{username}")
    public User findByUsername(@PathVariable("username") String username) {
        if (username != null) {
            return this.userRepository.getByUsername(username);
        } else return null;
    }

    // returns users with peanut allergy interest
    @GetMapping("/peanut_interest")
    public Iterable <User> findByPeanutInterestTrue() {
        return this.userRepository.getByPeanutInterestTrue();
    }

    // returns users with egg allergy interest
    @GetMapping("/egg_interest")
    public Iterable <User> findByEggInterestTrue() {
        return this.userRepository.getByEggInterestTrue();
    }

    // returns users with dairy allergy interest
    @GetMapping("/dairy_interest")
    public Iterable <User> findByDairyInterestTrue() {
        return this.userRepository.getByDairyInterestTrue();
    }

    @PostMapping("/users")
    public User createNewUser(@RequestBody User user) {
        User newUser = this.userRepository.save(user);
        return newUser;
    }

}
