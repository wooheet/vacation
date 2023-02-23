package com.kakaostyle.vacation.domain.vacation;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum VacationType {

    ANNUAL_DAY(1.0, "아이디 또는 비밀번호가 일치 하지 않습니다."),
    ANNUAL_HALF_DAY(0.5,"존재 하지 않는 아이디 입니다."),
    ANNUAL_QUARTER_DAY(0.25, "서버 오류가 발생 하였습니다. 잠시 후 다시 시도해주세요.");

    private final double days;
    private final String message;
}

