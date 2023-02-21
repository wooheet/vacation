package com.kakaostyle.vacation.service.user;

import com.kakaostyle.vacation.domain.user.User;
import com.kakaostyle.vacation.web.dto.request.JoinRequestDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    List<User> findAll();

    User findById(Long userId);
    User findByUsername(String username);
    boolean existsByUsername(String username);

    Long save(JoinRequestDto joinRequestDto);
}
