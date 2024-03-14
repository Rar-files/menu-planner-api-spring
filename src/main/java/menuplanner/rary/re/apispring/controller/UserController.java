package menuplanner.rary.re.apispring.controller;

import java.util.List;

import menuplanner.rary.re.apispring.model.user.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import menuplanner.rary.re.apispring.exception.*;
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
    public List<AppUser> getAllUsers(){
        return _userRepository.findAll();
    }

    // get user by id rest api
    @GetMapping("/users/{id}")
    public ResponseEntity<AppUser> getUserById(@PathVariable String id) {
        AppUser appUser = _userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not exist with id :" + id));
        return ResponseEntity.ok(appUser);
    }

    // create user rest api
    @PostMapping("/users")
    public AppUser createUser(@RequestBody AppUser appUser) {
        return _userRepository.save(appUser);
    }
}