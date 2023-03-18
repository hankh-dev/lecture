package com.kidaristudio.lecture.dto;

import javax.persistence.Column;
import java.time.LocalDateTime;

public class LectureReservationRequestDto {

    // 강연ID
    private Integer lectureId;

    // 사번
    private String employeeId;


    public Integer getLectureId() {
        return lectureId;
    }

    public String getEmployeeId() {
        return employeeId;
    }
}
