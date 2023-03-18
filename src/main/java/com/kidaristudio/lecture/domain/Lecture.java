package com.kidaristudio.lecture.domain;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Lecture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // 강연자
    @Column(length = 100)
    private String speaker;

    // 강연장
    @Column(length = 100)
    private String lectureHall;

    // 모집인원
    private Integer numberOfRecruits;

    // 강연내용
    @Column(length = 1000)
    private String content;

    // 강연시작일시
    private LocalDateTime startDt;

    // 강연종료일시
    private LocalDateTime endDt;

    // 등록일시
    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdDt;
    
    // 최종수정일시
    @LastModifiedDate
    private LocalDateTime lastModifiedDt;


    public Lecture() {
    }

    public Lecture(String speaker, String lectureHall, Integer numberOfRecruits, String lectureContent, LocalDateTime startDt, LocalDateTime endDt) {
        this.speaker = speaker;
        this.lectureHall = lectureHall;
        this.numberOfRecruits = numberOfRecruits;
        this.content = lectureContent;
        this.startDt = startDt;
        this.endDt = endDt;
    }


    public Integer getId() {
        return id;
    }

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

    public LocalDateTime getCreatedDt() {
        return createdDt;
    }

    public LocalDateTime getLastModifiedDt() {
        return lastModifiedDt;
    }


    public void setSpeaker(String speaker) {
        this.speaker = speaker;
    }

    public void setLectureHall(String lectureHall) {
        this.lectureHall = lectureHall;
    }

    public void setNumberOfRecruits(Integer numberOfRecruits) {
        this.numberOfRecruits = numberOfRecruits;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setStartDt(LocalDateTime startDt) {
        this.startDt = startDt;
    }

    public void setEndDt(LocalDateTime endDt) {
        this.endDt = endDt;
    }

}
