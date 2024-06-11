package com.insurenebula.crm.User;

import java.util.Collections;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserRepository userRepository;

    // Dependency Injection. Instead of creating a new repository, inject the
    // existing one.
    // Using @Repository in UserRepository. Spring Boot will create an instance of
    // UserRepository and inject it
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // @GetMapping("/{id}")
    // public ResponseEntity<User> getUser(@PathVariable Integer id) {
    //     // Check if user exists
    //     User user = userRepository.findById(id)
    //             .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));

    //     // Return user if found or throw exception
    //     return ResponseEntity.status(HttpStatus.OK).body(user);
    // }

    // Get all users
    @GetMapping("/all")
    public ResponseEntity<Iterable<User>> getUsers() {
        // Get all users
        Iterable<User> users = userRepository.findAll();

        // Check if users exist
        if (!users.iterator().hasNext()) {
            return ResponseEntity.status(HttpStatus.OK).body(Collections.emptyList());
        }

        // Return users if found
        return ResponseEntity.status(HttpStatus.OK).body(users);
    }

    // @PutMapping("/{id}")
    // public ResponseEntity<User> editUser(@PathVariable Integer id, @RequestBody User user) {
    //     // Check if user exists
    //     User existingUser = userRepository.findById(id)
    //             .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));

    //     // Update user details
    //     existingUser.setFirstName(user.getFirstName());
    //     existingUser.setLastName(user.getLastName());
    //     existingUser.setEmail(user.getEmail());

    //     // Save updated user
    //     User updatedUser = userRepository.save(existingUser);
    //     return ResponseEntity.ok(updatedUser);
    // }

    // @PostMapping("")
    // public ResponseEntity<User> createUser(@RequestBody User user) {
    //     // Check if user already exists
    //     if (user.getId() != null && userRepository.existsById(user.getId())) {
    //         throw new ResponseStatusException(HttpStatus.CONFLICT, "User already exists");
    //     }

    //     // Save user
    //     User savedUser = userRepository.save(user);
    //     return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    // }

}
