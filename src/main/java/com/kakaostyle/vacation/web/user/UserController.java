package com.kakaostyle.vacation.controller.user;

import com.kakaostyle.vacation.domain.dto.request.VacRequestDto;
import com.kakaostyle.vacation.domain.entity.User;
import com.kakaostyle.vacation.domain.entity.Vacation;
import com.kakaostyle.vacation.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUser(@PathVariable Long userId) {
        User user = userService.getUser(userId);
        return ResponseEntity.ok(user);
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User createdUser = userService.createUser(user);
        return ResponseEntity.ok(createdUser);
    }

    @PostMapping("/{userId}/apply-vacation")
    public ResponseEntity<Vacation> applyVacation(@PathVariable Long userId, @RequestBody VacRequestDto dto) {
        Vacation createdVacation = userService.applyVacation(userId, dto);
        return ResponseEntity.ok(createdVacation);
    }

    @PutMapping("/{userId}/cancel-vacation/{vacationId}")
    public ResponseEntity<Void> cancelVacation(@PathVariable Long userId, @PathVariable Long vacationId) {
        userService.cancelVacation(userId, vacationId);
        return ResponseEntity.noContent().build();
    }
}
