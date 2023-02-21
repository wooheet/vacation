package com.kakaostyle.vacation.web.dto.request;

import com.kakaostyle.vacation.domain.user.Role;
import com.kakaostyle.vacation.domain.user.User;
import lombok.*;

@Getter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class JoinRequestDto {
    private String username;

    private String password;

    private Role role;
    private Double availableVacDays;

    private Double requestedVacDays;

    public User toEntity() {
        return User.builder()
                .username(this.username)
                .password(this.password)
                .availableVacDays(this.availableVacDays)
                .requestedVacDays(this.requestedVacDays)
                .build();
    }
}
