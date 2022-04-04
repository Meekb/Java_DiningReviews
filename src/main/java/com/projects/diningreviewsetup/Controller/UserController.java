package com.projects.diningreviewsetup.Controller;
import com.projects.diningreviewsetup.Repositories.UserRepository;
import com.projects.diningreviewsetup.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired UserRepository userRepository;

    // returns all users
    @GetMapping()
    public Iterable<User> getAllUsers() {
        return this.userRepository.findAll();
    }

    // creates / saves a new user
    @PostMapping("/addNew")
    public User createUser(@RequestBody User user) {
        if (userRepository.getByUsername(user.getUsername()) != null && userRepository.findById(user.getId()).isPresent()) {
            System.out.print("\nUser already exists");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User already exists");
        }
        if (userRepository.getByUsername(user.getUsername()) != null) {
            System.out.print("\nUsername not available");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Username not available");
        }
        return userRepository.save(user);
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
