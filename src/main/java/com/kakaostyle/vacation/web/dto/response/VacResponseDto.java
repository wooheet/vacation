package com.kakaostyle.vacation.web.dto.response;

import com.kakaostyle.vacation.domain.vacation.VacationStatus;
import com.kakaostyle.vacation.domain.vacation.VacationType;
import lombok.Data;

import java.time.LocalDate;

@Data
public class VacResponseDto {
    private Long id;
    private VacationType vacationType;
    private VacationStatus status;
    private Double daysUsed;
    private LocalDate startDate;
    private LocalDate endDate;
    private String comment;
}
