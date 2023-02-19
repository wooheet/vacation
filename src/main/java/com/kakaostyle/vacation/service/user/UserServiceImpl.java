package com.kakaostyle.vacation.service.user;

import com.kakaostyle.vacation.domain.dto.request.VacRequestDto;
import com.kakaostyle.vacation.domain.entity.User;
import com.kakaostyle.vacation.domain.entity.Vacation;
import com.kakaostyle.vacation.domain.repository.UserRepository;
import com.kakaostyle.vacation.domain.type.VacationStatus;
import com.kakaostyle.vacation.domain.type.VacationType;
import com.kakaostyle.vacation.exception.UserNotFoundException;
import com.kakaostyle.vacation.service.vacation.VacationService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final VacationService vacationService;

    @Override
    public User getUser(Long userId) {
        return userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("User not found"));
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }


    @Override
    public Vacation applyVacation(Long userId, VacRequestDto dto) {
        User user = getUser(userId);

        //TODO set dto builder
        Vacation vacation = Vacation.builder()
                .vacationType(VacationType.ANNUAL_DAY)
                .status(VacationStatus.APPROVED)
                .vacDays(5.0)
                .startDate(LocalDate.now())
                .endDate(LocalDate.now().plusDays(5))
                .comment("Enjoy your vacation!")
                .build();

        return vacationService.applyVacation(user, vacation);
    }

    @Override
    public Vacation cancelVacation(Long userId, Long vacationId) {
        return null;
    }
}
