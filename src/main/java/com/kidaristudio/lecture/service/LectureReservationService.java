package com.kidaristudio.lecture.service;

import com.kidaristudio.lecture.domain.LectureReservation;
import com.kidaristudio.lecture.dto.LectureReservationRequestDto;
import com.kidaristudio.lecture.repository.LectureReservationRepository;
import org.springframework.stereotype.Service;

@Service
public class LectureReservationService {
    private final LectureReservationRepository lectureReservationRepository;

    public LectureReservationService(LectureReservationRepository lectureReservationRepository) {
        this.lectureReservationRepository = lectureReservationRepository;
    }

//    public LectureReservation createLectureReservation(LectureReservationRequestDto lectureReservationDto) {
////        User user = userRepository.findById(lectureReservationDto.getUserId())
////                .orElseThrow(() -> new EntityNotFoundException("User not found"));
//
//        LectureReservation lectureReservation = new LectureReservation();
//
//        lectureReservation.setLectureName(lectureReservationDto.getLectureName());
//        lectureReservation.setStartTime(lectureReservationDto.getStartTime());
//        lectureReservation.setEndTime(lectureReservationDto.getEndTime());
//        lectureReservation.setSpeaker(lectureReservationDto.getSpeaker());
//        lectureReservation.setUser(user);
//
//        return lectureReservationRepository.save(lectureReservation);
//    }

    // other methods for retrieving, updating, and deleting reservations
}