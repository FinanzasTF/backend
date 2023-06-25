package com.back.finanzas_back.api;

import com.back.finanzas_back.domain.model.entity.User;
import com.back.finanzas_back.domain.persistence.UserRepository;
import com.back.finanzas_back.domain.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("user")
@AllArgsConstructor
public class UserController {
    private final UserService activityService;

    @PostMapping
    public User save(@RequestBody User resource) {
        resource.setPassword(new BCryptPasswordEncoder().encode(resource.getPassword()));
        return activityService.save( resource);
    }

    @GetMapping
    public List<User> getAll() {
        return activityService.getAll();
    }

    @GetMapping("validation/{id}")
    public User getById(@PathVariable Integer id) {
        return activityService.getById(id).get();
    }

//    @GetMapping("validation/{email}/{password}")
//    public User validation(@PathVariable String email, @PathVariable String password) {
//        return activityService.validation(email,password).get();
//    }
@GetMapping("validation/{email}/{password}")
public ResponseEntity<?> validation(@PathVariable String email, @PathVariable String password) {
    Optional<User> userOptional = activityService.validation(email, password);

    if (userOptional.isPresent()) {
        User user = userOptional.get();
        // Realizar operaciones con el usuario encontrado
        // ...
        return ResponseEntity.ok(user);
    } else {
        return ResponseEntity.notFound().build();
    }
}


    @PutMapping("{id}")
    public ResponseEntity<User> update(@PathVariable Integer id, @RequestBody User resource) {
        if(id.equals(resource.getId())) {

            return new ResponseEntity<>(activityService.update(resource), HttpStatus.OK);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<User> delete(@PathVariable Integer id) {
        if (activityService.deleteById(id)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
