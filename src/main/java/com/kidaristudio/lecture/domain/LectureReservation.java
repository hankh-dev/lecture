package com.kidaristudio.lecture.domain;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class LectureReservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // 강연ID
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lecture_id")
    private Lecture lecture;

    // 사번
    @Column(length = 5)
    private String employeeId;

    // 등록일시
    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdDt;

    // 최종수정일시
    @LastModifiedDate
    private LocalDateTime lastModifiedDt;


    public LectureReservation() {
    }


}
