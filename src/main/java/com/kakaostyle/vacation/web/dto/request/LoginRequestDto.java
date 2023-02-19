package com.kakaostyle.vacation.domain.dto.request;

import lombok.Data;

@Data
public class LoginRequestDto {
	private Long userName;
	private String password;

}
