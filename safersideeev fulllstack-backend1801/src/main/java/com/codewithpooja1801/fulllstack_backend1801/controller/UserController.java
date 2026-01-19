package com.codewithpooja1801.fulllstack_backend1801.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.codewithpooja1801.fulllstack_backend1801.model.User;
import com.codewithpooja1801.fulllstack_backend1801.repository.UserRepository;
import com.codewithpooja1801.fulllstack_backend1801.exception.UserNotFoundException.UserNotFoundsException;

@RestController
@CrossOrigin(origins = "*")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@PostMapping("/users")
	User newUser(@RequestBody User newUser) {
		return userRepository.save(newUser);
	}
	
	@GetMapping("/users")
    List<User> getAllUsers() {
        return userRepository.findAll();
    }
	
	@GetMapping("/users/{id}")
    User getUserById(@PathVariable Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundsException(id));
    }

    @PutMapping("/users/{id}")
    User updateUser(@RequestBody User updatedUser, @PathVariable Long id) {
        return userRepository.findById(id)
                .map(user -> {
                    user.setUsername(updatedUser.getUsername());
                    user.setName(updatedUser.getName());
                    user.setEmail(updatedUser.getEmail());
                    return userRepository.save(user);
                })
                .orElseThrow(() -> new UserNotFoundsException(id));
    }

    @DeleteMapping("/users/{id}")
    String deleteUser(@PathVariable Long id) {
        if (!userRepository.existsById(id)) {
            throw new UserNotFoundsException(id);
        }
        userRepository.deleteById(id);
        return "User with id " + id + " has been deleted successfully.";
    }

}
