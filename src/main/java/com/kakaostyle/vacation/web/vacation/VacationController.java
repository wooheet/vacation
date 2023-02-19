package com.kakaostyle.vacation.controller.vacation;

import com.kakaostyle.vacation.domain.dto.request.VacRequestDto;
import com.kakaostyle.vacation.domain.dto.response.VacResponseDto;
import com.kakaostyle.vacation.domain.entity.Vacation;
import com.kakaostyle.vacation.service.vacation.VacationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/vacations")
public class VacationController {

    private final VacationService vacationService;

    @GetMapping("/{id}")
    public ResponseEntity<Vacation> getVacation(@PathVariable Long id) {
        Vacation vacationDto = vacationService.getVacation(id);
        //TODO: mapping response dto
        return new ResponseEntity<>(vacationDto, HttpStatus.OK);
    }

//    @GetMapping
//    public ResponseEntity<List<VacResponseDto>> getAllVacations() {
//        List<VacResponseDto> vacationDtos = vacationService.getAllVacations();
//        return new ResponseEntity<>(vacationDtos, HttpStatus.OK);
//    }
//
//    @PostMapping
//    public ResponseEntity<VacResponseDto> applyVacation(@RequestBody VacRequestDto dto) {
//        VacResponseDto createdVacationDto = vacationService.applyVacation(dto);
//        return new ResponseEntity<>(createdVacationDto, HttpStatus.CREATED);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<VacResponseDto> updateVacation(@PathVariable Long id, @RequestBody VacRequestDto dto) {
//        VacResponseDto updatedVacationDto = vacationService.updateVacation(id, vacationDto);
//        return new ResponseEntity<>(updatedVacationDto, HttpStatus.OK);
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVacation(@PathVariable Long id) {
        vacationService.deleteVacation(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
