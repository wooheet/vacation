package com.kakaostyle.vacation.service.user;

import com.kakaostyle.vacation.domain.dto.request.VacRequestDto;
import com.kakaostyle.vacation.domain.entity.User;
import com.kakaostyle.vacation.domain.entity.Vacation;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    User getUser(Long userId);

    User createUser(User user);


    Vacation applyVacation(Long userId, VacRequestDto dto);

    Vacation cancelVacation(Long userId, Long vacationId);
}
