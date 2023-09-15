package ua.ithillel.springboot.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.ithillel.springboot.model.User;
import ua.ithillel.springboot.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getById(@PathVariable("id") Long id) {
        User userById = userService.findUserById(id);
        return ResponseEntity.ok(userById);
    }

    @GetMapping
    public ResponseEntity<User> getById(@RequestParam(value = "email", required = true) String email) {
        User userById = userService.findUserByEmail(email);
        return ResponseEntity.ok(userById);
    }

    @GetMapping("/search")
    public ResponseEntity<List<User>> search(@RequestParam("num") int num,
                                             @RequestParam("count") int count) {
        List<User> allUsers = userService.findAllUsers(num, count);
        return ResponseEntity.ok(allUsers);
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAll(@RequestParam("nameAsc") boolean nameAsc) {
        List<User> allUsersSorted = userService.findAllUsersSorted(nameAsc);
        return ResponseEntity.ok(allUsersSorted);
    }
}
