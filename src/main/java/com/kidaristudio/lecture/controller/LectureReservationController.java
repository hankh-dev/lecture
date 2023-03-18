package com.kidaristudio.lecture.controller;

import com.kidaristudio.lecture.domain.LectureReservation;
import com.kidaristudio.lecture.dto.LectureReservationRequestDto;
import com.kidaristudio.lecture.service.LectureReservationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/lectures")
public class LectureReservationController {
    private final LectureReservationService lectureReservationService;

    public LectureReservationController(LectureReservationService lectureReservationService) {
        this.lectureReservationService = lectureReservationService;
    }

//    @PostMapping
//    public ResponseEntity<LectureReservation> createLectureReservation(@RequestBody LectureReservationRequestDto lectureReservationRequestDto) {
//        LectureReservation lectureReservation = lectureReservationService.createLectureReservation(lectureReservationRequestDto);
//        return ResponseEntity.ok(lectureReservation);
//    }


    // other methods for retrieving, updating, and deleting reservations
}
