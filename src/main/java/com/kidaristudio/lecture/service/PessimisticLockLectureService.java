package com.kidaristudio.lecture.service;

import com.kidaristudio.lecture.domain.Lecture;
import com.kidaristudio.lecture.repository.LectureRepository;
import org.springframework.stereotype.Service;

@Service
public class PessimisticLockLectureService {

    private LectureRepository lectureRepository;

    public PessimisticLockLectureService(LectureRepository lectureRepository) {
        this.lectureRepository = lectureRepository;
    }

    Lecture createLecture(Lecture lecture) {
        return lectureRepository.save(lecture);
    }


//    @Transactional
//    public Long decrease(Long id, Long quantity) {
//        Lecture lecture = lectureRepository.findByIdWithPessimisticLock(id);
//        lecture.decrease(quantity);
//        lectureRepository.saveAndFlush(lecture);
//
//        return lecture.getQuantity();
//    }
}
