package com.kakaostyle.vacation.web.dto.response;

import com.kakaostyle.vacation.domain.user.Role;
import lombok.Data;

@Data
public class UserResponseDto {

    private Long id;
    private String username;
    private Role role;
    private Double availableVacDays;
    private Double requestedVacDays;
}