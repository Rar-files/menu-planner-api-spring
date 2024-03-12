package menuplanner.rary.re.apispring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import menuplanner.rary.re.apispring.exception.*;
import menuplanner.rary.re.apispring.model.User;
import menuplanner.rary.re.apispring.repository.UserRepository;

@RestController
@RequestMapping("/api/v1/")
public class UserController {

    private final UserRepository _userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        _userRepository = userRepository;
    }

    // get all users
    @GetMapping("/users")
    public List<User> getAllUsers(){
        return _userRepository.findAll();
    }

    // get user by id rest api
    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable String id) {
        User user = _userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not exist with id :" + id));
        return ResponseEntity.ok(user);
    }

    // create user rest api
    @PostMapping("/users")
    public User createUser(@RequestBody User user) {
        return _userRepository.save(user);
    }
}