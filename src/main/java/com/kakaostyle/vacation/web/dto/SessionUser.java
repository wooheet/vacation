package com.kakaostyle.vacation.web.dto;

import com.kakaostyle.vacation.domain.user.Role;
import com.kakaostyle.vacation.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SessionUser {
    private Long id;
    private String username;
    private String password;
    private Role role;


    public static SessionUser fromEntity(User user) {
        return new SessionUser(
                user.getId(),
                user.getUsername(),
                user.getPassword(),
                user.getRole()
        );
    }
}
