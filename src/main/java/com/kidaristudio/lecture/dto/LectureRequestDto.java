package com.kidaristudio.lecture.dto;

import javax.persistence.Column;
import java.time.LocalDateTime;

public class LectureRequestDto {

    // 강연자
    private String speaker;

    // 강연장
    private String lectureHall;

    // 모집인원
    private Integer numberOfRecruits;

    // 강연내용
    private String content;

    // 강연시작일시
    private LocalDateTime startDt;

    // 강연종료일시
    private LocalDateTime endDt;

    public String getSpeaker() {
        return speaker;
    }

    public String getLectureHall() {
        return lectureHall;
    }

    public Integer getNumberOfRecruits() {
        return numberOfRecruits;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getStartDt() {
        return startDt;
    }

    public LocalDateTime getEndDt() {
        return endDt;
    }

    public LectureRequestDto(String speaker, String lectureHall, Integer numberOfRecruits, String content, LocalDateTime startDt, LocalDateTime endDt) {
        this.speaker = speaker;
        this.lectureHall = lectureHall;
        this.numberOfRecruits = numberOfRecruits;
        this.content = content;
        this.startDt = startDt;
        this.endDt = endDt;
    }
}
