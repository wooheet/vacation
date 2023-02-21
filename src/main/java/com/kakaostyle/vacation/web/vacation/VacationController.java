package com.kakaostyle.vacation.web.vacation;

import com.kakaostyle.vacation.domain.user.User;
import com.kakaostyle.vacation.domain.vacation.Vacation;
import com.kakaostyle.vacation.service.user.UserService;
import com.kakaostyle.vacation.service.vacation.VacationService;
import com.kakaostyle.vacation.web.dto.request.VacRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/vacation")
public class VacationController {

    private final VacationService vacationService;
    private final UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<Vacation> getVacation(@PathVariable Long id) {
        Vacation vacationDto = vacationService.getVacation(id);
        //TODO: mapping response dto
        return new ResponseEntity<>(vacationDto, HttpStatus.OK);
    }

    @GetMapping("/request")
    public ModelAndView request() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("vacation_request");

        String currentUserName  = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userService.findByUsername(currentUserName);
        Map<String, Object> map = new HashMap<>();
        map.put("count", user.getAvailableVacDays());
        modelAndView.addObject("data", map);

        return modelAndView;
    }

    @GetMapping("/detail")
    public ModelAndView detail() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("vacation_detail");
        return modelAndView;
    }
    @PostMapping("/request")
    public ModelAndView requestVacation(@RequestBody VacRequestDto vacRequestDto) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("vacation_request");

        String currentUserName  = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userService.findByUsername(currentUserName);

        vacationService.requestVacation(user, vacRequestDto);

        Map<String, Object> map = new HashMap<>();
        map.put("count", user.getAvailableVacDays());

        modelAndView.addObject("data", map);
        return modelAndView;
    }

//    @GetMapping
//    public ResponseEntity<List<VacResponseDto>> getAllVacations() {
//        List<VacResponseDto> vacationDtos = vacationService.getAllVacations();
//        return new ResponseEntity<>(vacationDtos, HttpStatus.OK);
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> cancelVacation(@PathVariable Long id) {
        // TODO: 아직 시작하지 않았는지 체크
        vacationService.deleteVacation(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
