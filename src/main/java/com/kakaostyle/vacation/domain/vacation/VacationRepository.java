package com.kakaostyle.vacation.domain.repository;


import com.kakaostyle.vacation.domain.entity.User;
import com.kakaostyle.vacation.domain.entity.Vacation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VacationRepository extends JpaRepository<Vacation, Long> {
    Optional<List<Vacation>> findByUserId(Long userId);
    List<Vacation> findByUser(User user);
}
