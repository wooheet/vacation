package com.kakaostyle.vacation.service.vacation;

import com.kakaostyle.vacation.domain.dto.request.VacRequestDto;
import com.kakaostyle.vacation.domain.entity.User;
import com.kakaostyle.vacation.domain.entity.Vacation;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public interface VacationService {

    Vacation getVacation(Long id);
    List<Vacation> getVacationsByUser(User user);
    Vacation applyVacation(User user, Vacation vacation);
    Vacation updateVacation(Long vacationId, VacRequestDto dto);
    void deleteVacation(Long vacationId);
    double calculateVacationDaysExcludingHolidays(LocalDate startDate, LocalDate endDate);

    void VacationReset();
}
