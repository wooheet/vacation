package com.kakaostyle.vacation.web;

import com.kakaostyle.vacation.domain.user.User;
import com.kakaostyle.vacation.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class HomeController {
    private final UserService userService;

    @GetMapping(value = "/")
    public ModelAndView home() {
        // TODO: 로그인시, 매년 특정한 날 reset 후 15일의 연차 부여

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("home");

        Map<String, Object> map = new HashMap<>();

        String currentUserName  = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userService.findByUsername(currentUserName);

        // TODO: user vacation list

        map.put("name", user.getUsername());
        map.put("date", LocalDateTime.now());

        modelAndView.addObject("data", map);
        return modelAndView;
    }
}
