package com.kidaristudio.lecture.repository;

import com.kidaristudio.lecture.domain.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.LockModeType;

public interface LectureReservationRepository extends JpaRepository<Lecture, Integer> {

    @Lock(value = LockModeType.PESSIMISTIC_WRITE)
    @Query("select l from LectureReservation l where l.employeeId = :employeeId and l.lecture = :lectureId")
    Lecture findByEmployeeIdAndLectureIdWithPessimisticLock(Integer employeeId, Integer lectureId);
}
