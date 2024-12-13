package org.oduw.controllers;

import lombok.RequiredArgsConstructor;
import org.oduw.controllers.dtos.LoginDto;
import org.oduw.controllers.dtos.RegisterDto;
import org.oduw.controllers.dtos.UpdateDto;
import org.oduw.models.User;
import org.oduw.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserControllerV1 {

    private final UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<User> getById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getById(id));
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody RegisterDto dto) {
        return ResponseEntity.ok(userService.register(dto));
    }

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody LoginDto dto) {
        return ResponseEntity.ok(userService.login(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateById(@PathVariable Long id, @RequestBody UpdateDto dto) {
        return ResponseEntity.ok(userService.updateById(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.deleteById(id));
    }
}
