package br.com.odilonfontes.errorcenterapi.web.rest;

import br.com.odilonfontes.errorcenterapi.domain.User;
import br.com.odilonfontes.errorcenterapi.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserResource {

    private final UserService userService;

    public UserResource(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        User result = userService.save(user);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers(Pageable pageable) {
        Page<User> result = userService.findAll(pageable);
        return new ResponseEntity<>(result.getContent(), HttpStatus.OK);
    }

}
