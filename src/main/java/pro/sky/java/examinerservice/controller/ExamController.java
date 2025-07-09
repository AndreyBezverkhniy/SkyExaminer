package pro.sky.java.examinerservice.controller;

import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.examinerservice.service.ExaminerService;

@RestController
public class ExamController {
    private ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }
}
