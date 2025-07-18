package pro.sky.java.examinerservice.service;

import pro.sky.java.examinerservice.domain.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions(int amount);
}
