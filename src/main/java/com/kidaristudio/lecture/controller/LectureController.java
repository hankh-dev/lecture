package com.kidaristudio.lecture.controller;

import com.kidaristudio.lecture.domain.Lecture;
import com.kidaristudio.lecture.dto.LectureRequestDto;
import com.kidaristudio.lecture.service.LectureService;
import org.springframework.data.domain.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/lectures")
public class LectureController {
    private final LectureService lectureService;

    public LectureController(LectureService lectureService) {
        this.lectureService = lectureService;
    }

    @PostMapping
    public ResponseEntity<Lecture> createLecture(@RequestBody LectureRequestDto lectureRequestDto) {
        Lecture responseLecture = lectureService.createLecture(lectureRequestDto);
        return ResponseEntity.ok(responseLecture);
    }

    @GetMapping
    public ResponseEntity<Page<Lecture>> getAllLectures(@RequestParam(value = "page", defaultValue = "0") int page,
                                                        @RequestParam(value = "size", defaultValue = "10") int size,
                                                        @RequestParam(value = "sortBy", defaultValue = "id") String sortBy,
                                                        @RequestParam(value = "sortOrder", defaultValue = "desc") String sortOrder) {
        Sort.Direction direction = sortOrder.equalsIgnoreCase("asc") ? Sort.Direction.ASC : Sort.Direction.DESC;
        Pageable pageable = PageRequest.of(page, size, Sort.by(direction, sortBy));
        Page<Lecture> lectures = lectureService.getAllLectures(pageable);
        return ResponseEntity.ok(lectures);
    }


//
//    @GetMapping
//    public ResponseEntity<List<Lecture>> getAllLectures() {
//        List<Lecture> lectures = lectureService.getAllLectures();
//        return ResponseEntity.ok(lectures);
//    }
//

    @GetMapping("/{lectureId}")
    public ResponseEntity<Lecture> getLectureById(@PathVariable Integer lectureId) {
        System.out.println("fefefef");

        Lecture lecture = lectureService.getLectureById(lectureId);
        return ResponseEntity.ok(lecture);
    }

    // other methods for updating and deleting lectures
}