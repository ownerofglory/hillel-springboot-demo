package ua.ithillel.springboot.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.ithillel.springboot.model.Greeting;

@RestController
@RequestMapping("/hello")
public class HelloController {
    @GetMapping
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("Hello");
    }

    @GetMapping("/{name}")
    public ResponseEntity<Greeting> greet(@PathVariable("name") String name) {
        Greeting greeting = new Greeting();
        greeting.setMessage("Hello " + name);

        return ResponseEntity.ok(greeting);
    }
}
