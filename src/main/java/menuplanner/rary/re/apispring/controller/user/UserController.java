package menuplanner.rary.re.apispring.controller.user;

import java.util.List;

import menuplanner.rary.re.apispring.model.user.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import menuplanner.rary.re.apispring.exception.*;
import menuplanner.rary.re.apispring.repository.user.UserRepository;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserRepository _userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        _userRepository = userRepository;
    }

    // get all users
    @GetMapping()
    public List<AppUser> getAllUsers(){
        return _userRepository.findAll();
    }

    // get user by id
    @GetMapping("/{id}")
    public ResponseEntity<AppUser> getUserById(@PathVariable int id) {
        AppUser appUser = _userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not exist with id :" + id));
        return ResponseEntity.ok(appUser);
    }

    // create a new user
    @PostMapping()
    public AppUser createUser(@RequestBody AppUser appUser) {

        return _userRepository.save(appUser);
    }
}