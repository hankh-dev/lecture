package com.kidaristudio.lecture.controller;

import com.kidaristudio.lecture.service.LectureService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation;
import org.springframework.restdocs.operation.preprocess.Preprocessors;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureRestDocs
//@WebMvcTest(LectureController.class)
class LectureControllerTest {

    @Autowired
    private MockMvc mockMvc;

//    @MockBean // LectureController 의존하는 빈을 모킹
//    private LectureService lectureService;

    @Autowired
    private LectureService lectureService;

    @Test
    @DisplayName("강연 등록")
    void createLecture() throws Exception {
        String createCommandJson = "{\n" +
                "      \"speaker\": \"정은비,노도일\",\n" +
                "      \"lectureHall\": \"A\",\n" +
                "      \"numberOfRecruits\": 35,\n" +
                "      \"content\": \"행복플러스멋진인생\",\n" +
                "      \"startDt\": \"2023-04-16T16:00:00\",\n" +
                "      \"endDt\": \"2023-04-16T19:00:00\"\n" +
                "    }";
        mockMvc.perform(post("/lectures")
                .contentType(MediaType.APPLICATION_JSON)
                .content(createCommandJson))
                .andDo(print())
                .andDo(MockMvcRestDocumentation.document("lectures/createLecture",
                        Preprocessors.preprocessRequest(prettyPrint()),
                        Preprocessors.preprocessResponse(prettyPrint())))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.id").value(4))
        ;
    }


    @Test
    @DisplayName("강연 목록 조회")
    void getAllLectures() throws Exception {
        mockMvc.perform(get("/lectures"))
                .andDo(print())
                .andDo(MockMvcRestDocumentation.document("lectures/getAllLectures",
                        Preprocessors.preprocessRequest(prettyPrint()),
                        Preprocessors.preprocessResponse(prettyPrint())))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content", hasSize(4)))
        ;
    }


    @DisplayName("강연 상세 조회")
    @Test
    void getLectureById() throws Exception {
        mockMvc.perform(get("/lectures/1"))
                .andDo(print())
                .andDo(MockMvcRestDocumentation.document("lectures/getLectureById",
                        Preprocessors.preprocessRequest(prettyPrint()),
                        Preprocessors.preprocessResponse(prettyPrint())))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.speaker").value("강창진"))
        ;
    }

}