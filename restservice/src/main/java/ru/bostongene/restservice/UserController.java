package main.java.ru.bostongene.restservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.security.MessageDigest;
import java.util.List;
import java.util.Optional;


@RestController
public class UserController {

    @Autowired
    private UserRepository repository;


    @GetMapping("/users")
    public List<User> getUsers() {
        return (List<User>) repository.findAll();
    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable long id) {
        Optional<User> user = repository.findById(id);
        if (!user.isPresent())
            throw new UserNotFoundException();
        return user.get();
    }

    @PostMapping("/users")
    public ResponseEntity<Object> addUser(@RequestBody User user) throws Exception {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        digest.update(user.getPassword().getBytes());
        String password = new String(digest.digest());
        user.setPassword(password);
        User userToSave = repository.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(userToSave.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable long id) {
        repository.deleteById(id);
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    class UserNotFoundException extends RuntimeException {

        UserNotFoundException() {
            super("User does not exist");
        }
    }
}
