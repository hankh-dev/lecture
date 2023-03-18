package com.kidaristudio.lecture.service;

import com.kidaristudio.lecture.domain.Lecture;
import com.kidaristudio.lecture.dto.LectureRequestDto;
import com.kidaristudio.lecture.repository.LectureRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
class LectureServiceTest {

    @Autowired
    private LectureService lectureService;

    @Autowired
    private LectureRepository lectureRepository;

//    @BeforeEach
    public void before() {
//        lectureRepository.deleteAll();

        Lecture lecture1 = new Lecture(
                "강창진",
                "A Hall",
                40,
                "밀레니얼,청년투표의해법을묻다",
                LocalDateTime.of(2023, 4, 16, 14,0),
                LocalDateTime.of(2023, 4, 16, 16,0)
        );
        lectureRepository.saveAndFlush(lecture1);

        Lecture lecture2 = new Lecture(
                "이종범",
                "B Hall",
                30,
                "내가만화를그리는이유",
                LocalDateTime.of(2023, 4, 16, 13,0),
                LocalDateTime.of(2023, 4, 16, 15,0)
        );
        lectureRepository.saveAndFlush(lecture2);

        Lecture lecture3 = new Lecture(
                "김점옥",
                "B Hall",
                20,
                "당신의 선택이 쉬워지는 3가지 꿀팁!",
                LocalDateTime.of(2023, 4, 16, 16,0),
                LocalDateTime.of(2023, 4, 16, 19,0)
        );
        lectureRepository.saveAndFlush(lecture3);
    }

//    @AfterEach
    public void after() {
        lectureRepository.deleteAll();
    }

    @Test
    void none() {
    }

    @Test
    public void createLecture() {
        LectureRequestDto lectureRequestDto = new LectureRequestDto(
                "정은비,노도일",
                "A",
                35,
                "행복플러스멋진인생",
                LocalDateTime.of(2023, 4, 16, 16,0),
                LocalDateTime.of(2023, 4, 16, 19,0)
        );
        lectureService.createLecture(lectureRequestDto);
        Lecture actualLecture = lectureRepository.findById(4).orElseThrow();
        assertEquals("행복플러스멋진인생", actualLecture.getContent());
    }

    @Test
    void getAllLectures() {
        // when
        Sort.Direction direction = Sort.Direction.ASC;
        Pageable pageable = PageRequest.of(0, 2, Sort.by(direction, "speaker"));
        Page<Lecture> actualLectures = lectureService.getAllLectures(pageable);

        System.out.println("actualLectures:"+actualLectures);
        actualLectures.forEach(l->{
            System.out.println(l.toString());
        });

        // then
        assertThat(actualLectures).isNotNull();
        assertThat(actualLectures).hasSize(2);
    }



//    @Test
//    public void lecture_decrease() {
//        lectureService.decrease(1L, 1L);
//
//        Lecture lecture = lectureRepository.findById(1L).orElseThrow();
//
//        assertEquals(99, lecture.getQuantity());
//    }
//
//    @Test
//    public void 동시에_100명이_주문() throws InterruptedException {
//        int threadCount = 100;
//        ExecutorService executorService = Executors.newFixedThreadPool(16);
//        CountDownLatch latch = new CountDownLatch(threadCount);
//
//        for (int i = 0; i < threadCount; i++) {
//            executorService.submit(() -> {
//                try {
////                    lectureService.decrease(1L, 1L);
//                    pessimisticLockLectureService.decrease(1L, 1L);
//                } finally {
//                    latch.countDown();
//                }
//            });
//        }
//
//        latch.await();
//
//        Lecture lecture = lectureRepository.findById(1L).orElseThrow();
//
//        // 100 - (100 * 1) = 0
//        assertEquals(0, lecture.getQuantity());
//    }
}