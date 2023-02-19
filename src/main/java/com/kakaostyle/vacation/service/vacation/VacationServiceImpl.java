package com.kakaostyle.vacation.service.vacation;

import com.kakaostyle.vacation.domain.dto.request.VacRequestDto;
import com.kakaostyle.vacation.domain.entity.User;
import com.kakaostyle.vacation.domain.entity.Vacation;
import com.kakaostyle.vacation.domain.repository.VacationRepository;
import com.kakaostyle.vacation.domain.type.VacationStatus;
import com.kakaostyle.vacation.exception.VacationNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

@Service
@Transactional
@RequiredArgsConstructor
public class VacationServiceImpl implements VacationService{
    private final VacationRepository vacationRepository;

    @Override
    public Vacation getVacation(Long id) {
        return null;
    }

    @Override
    public List<Vacation> getVacationsByUser(User user) {
        return vacationRepository.findByUser(user);
    }

    @Override
    public Vacation applyVacation(User user, Vacation vacation) {
        vacation = Vacation.builder()
                .user(user)
                .build();
        return vacationRepository.save(vacation);
    }

    @Override
    public Vacation updateVacation(Long vacationId, VacRequestDto dto) {
        Vacation existingVacation = vacationRepository.findById(vacationId)
                .orElseThrow(() -> new VacationNotFoundException("Vacation not found"));

        existingVacation.builder()
                .startDate(dto.getStartDate())
                .endDate(dto.getEndDate())
                .vacationType(dto.getVacationType())
                .status(VacationStatus.APPROVED)
                .build();

        return vacationRepository.save(existingVacation);
    }

    @Override
    public void deleteVacation(Long vacationId) {
        Vacation existingVacation = vacationRepository.findById(vacationId)
                .orElseThrow(() -> new VacationNotFoundException("Vacation not found"));

        vacationRepository.delete(existingVacation);
    }

    @Override
    public double calculateVacationDaysExcludingHolidays(LocalDate startDate, LocalDate endDate) {
        List<LocalDate> holidays = Arrays.asList(
                LocalDate.of(2023, 1, 1),
                LocalDate.of(2023, 2, 12),
                LocalDate.of(2023, 3, 1)
                // Add more holidays as needed
        );

        long totalDays = ChronoUnit.DAYS.between(startDate, endDate) + 1;

        long weekends = IntStream.range(0, (int) totalDays)
                .mapToObj(startDate::plusDays)
                .filter(date -> date.getDayOfWeek() == DayOfWeek.SATURDAY || date.getDayOfWeek() == DayOfWeek.SUNDAY)
                .count();

        long holidaysCount = holidays.stream()
                .filter(date -> !date.isBefore(startDate) && !date.isAfter(endDate))
                .count();

        long daysExcludingHolidays = totalDays - weekends - holidaysCount;

        return (double) daysExcludingHolidays;
    }

    @Override
    @Scheduled(cron = "0 0 0 1 1 ?")
    @Transactional
    public void VacationReset() {
        System.out.println("VACATION RESET");
//        em.createQuery("update Account set annualCnt = 15").executeUpdate();
    }
}
