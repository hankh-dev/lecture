package com.kidaristudio.lecture.service;

import com.kidaristudio.lecture.domain.Lecture;
import com.kidaristudio.lecture.dto.LectureRequestDto;
import com.kidaristudio.lecture.repository.LectureRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class LectureService {

    private LectureRepository lectureRepository;

    public LectureService(LectureRepository lectureRepository) {
        this.lectureRepository = lectureRepository;
    }

    public Lecture createLecture(LectureRequestDto lectureRequestDto) {
        Lecture lecture = new Lecture(lectureRequestDto.getSpeaker(), lectureRequestDto.getLectureHall(),lectureRequestDto.getNumberOfRecruits(), lectureRequestDto.getContent(), lectureRequestDto.getStartDt(), lectureRequestDto.getEndDt());
        return lectureRepository.save(lecture);
    }

//    public List<Lecture> getAllLectures() {
//        return lectureRepository.findAll();
//    }

    public Page<Lecture> getAllLectures(Pageable pageable) {
        return lectureRepository.findAll(pageable);
    }

    public Lecture getLectureById(Integer lectureId) {
        return lectureRepository.findById(lectureId)
                .orElseThrow(() -> new EntityNotFoundException("Lecture not found"));
    }

}
