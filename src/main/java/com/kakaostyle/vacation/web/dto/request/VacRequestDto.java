package com.kakaostyle.vacation.web.dto.request;

import com.kakaostyle.vacation.domain.user.User;
import com.kakaostyle.vacation.domain.vacation.Vacation;
import com.kakaostyle.vacation.domain.vacation.VacationStatus;
import com.kakaostyle.vacation.domain.vacation.VacationType;
import lombok.*;

import java.time.LocalDate;

@Getter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class VacRequestDto {

    private LocalDate startDate;
    private LocalDate endDate;
    private VacationType vacationType;
    private VacationStatus status;
    private String comment;

    public Vacation toEntity(User user, Double days_used, VacationStatus status,
                             LocalDate startDate, LocalDate endDate) {
        return Vacation.builder()
                .startDate(startDate)
                .endDate(endDate)
                .vacationType(this.vacationType)
                .comment(this.comment)
                .daysUsed(days_used)
                .status(status)
                .user(user)
                .build();
    }
}