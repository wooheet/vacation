package com.kakaostyle.vacation.domain.vacation;


import com.kakaostyle.vacation.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VacationRepository extends JpaRepository<Vacation, Long> {
    List<Vacation> findByUserId(Long userId);
    List<Vacation> findByUser(User user);
}
