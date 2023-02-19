package com.kakaostyle.vacation.domain.dto.request;

import com.kakaostyle.vacation.domain.type.VacationStatus;
import com.kakaostyle.vacation.domain.type.VacationType;
import lombok.*;

import java.time.LocalDate;

@Data
public class VacRequestDto {

    private LocalDate startDate;
    private LocalDate endDate;
    private VacationType vacationType;
    private VacationStatus vacationStatus;


}