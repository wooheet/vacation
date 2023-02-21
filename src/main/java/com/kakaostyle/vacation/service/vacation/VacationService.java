package com.kakaostyle.vacation.service.vacation;

import com.kakaostyle.vacation.domain.user.User;
import com.kakaostyle.vacation.domain.vacation.Vacation;
import com.kakaostyle.vacation.web.dto.request.VacRequestDto;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public interface VacationService {

    Vacation getVacation(Long id);
    List<Vacation> getVacationsByUser(User user);
    Vacation requestVacation(User user, VacRequestDto vacRequestDto);
    Vacation updateVacation(Long vacationId, VacRequestDto dto);
    void deleteVacation(Long vacationId);
    double calculateVacationDaysExcludingHolidays(LocalDate startDate, LocalDate endDate);

    void VacationReset();
}
