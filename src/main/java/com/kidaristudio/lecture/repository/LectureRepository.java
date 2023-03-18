package com.kidaristudio.lecture.repository;

import com.kidaristudio.lecture.domain.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.LockModeType;

public interface LectureRepository extends JpaRepository<Lecture, Integer> {

    @Lock(value = LockModeType.PESSIMISTIC_WRITE)
    @Query("select l from Lecture l where l.id = :id")
    Lecture findByIdWithPessimisticLock(Integer id);


    @Lock(value = LockModeType.OPTIMISTIC)
    @Query("select l from Lecture l where l.id = :id")
    Lecture findByIdWithOptimisticLock(Integer id);
}
