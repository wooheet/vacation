package com.kakaostyle.vacation.service.user;

import com.kakaostyle.vacation.domain.user.User;
import com.kakaostyle.vacation.domain.user.UserRepository;
import com.kakaostyle.vacation.exception.UserNotFoundException;
import com.kakaostyle.vacation.service.vacation.VacationService;
import com.kakaostyle.vacation.web.dto.request.JoinRequestDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final VacationService vacationService;

    public boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }


    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findByUsername(String username) {
        return (User) userRepository.findByUsername(username).orElseThrow(() ->
                new UsernameNotFoundException("사용자를 찾을 수 없습니다."));
    }

    public User findById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User not found"));
    }

    @Override
    public Long save(JoinRequestDto joinRequestDto) {
        User user = joinRequestDto.toEntity();
        return userRepository.save(user).getId();
    }
}
