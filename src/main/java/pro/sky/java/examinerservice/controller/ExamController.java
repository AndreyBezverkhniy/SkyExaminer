package pro.sky.java.examinerservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pro.sky.java.examinerservice.domain.Question;
import pro.sky.java.examinerservice.exception.UnavailableAmountRequestException;
import pro.sky.java.examinerservice.service.ExaminerService;

import java.util.Collection;

@RestController
@RequestMapping("/exam/get")
public class ExamController {
    private ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    @ExceptionHandler(UnavailableAmountRequestException.class)
    public ResponseEntity<String> handleException(UnavailableAmountRequestException e) {
        return ResponseEntity.badRequest().body("Amount can be only from 1 to actual amount of questions");
    }

    @GetMapping
    Collection<Question> getQuestions(@RequestParam("amount") int amount) {
        return examinerService.getQuestions(amount);
    }
}
