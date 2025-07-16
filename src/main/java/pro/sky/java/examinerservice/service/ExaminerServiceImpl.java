package pro.sky.java.examinerservice.service;

import org.springframework.stereotype.Service;
import pro.sky.java.examinerservice.domain.Question;
import pro.sky.java.examinerservice.exception.UnavailableAmountRequestException;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService{
    QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        if(amount>questionService.getAll().size()||amount<=0){
            throw new UnavailableAmountRequestException();
        }
        Set<Question> questionList=new HashSet<Question>();
        while(questionList.size()<amount){
            questionList.add(questionService.getRandomQuestion());
        }
        return questionList;
    }
}
