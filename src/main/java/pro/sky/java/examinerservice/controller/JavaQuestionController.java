package pro.sky.java.examinerservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.examinerservice.domain.Question;
import pro.sky.java.examinerservice.service.QuestionService;

import java.util.Collection;

@RestController
@RequestMapping("/exam/java")
public class JavaQuestionController {
    QuestionService questionService;

    public JavaQuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/add")
    Question addQuestion(@RequestParam("question") String question,
                         @RequestParam("answer") String answer) {
        return questionService.add(question, answer);
    }

    @GetMapping
    Collection<Question> getQuestions() {
        return questionService.getAll();
    }

    @GetMapping("/remove")
    Question removeQuestion(@RequestParam("question") String question,
                            @RequestParam("answer") String answer) {
        return questionService.remove(new Question(question, answer));
    }
}
