package com.kakaostyle.vacation.domain.dto.request;

import lombok.*;

@Data
public class UserRequestDto {
	private Long userName;
	private String password;
	private String role;

}
