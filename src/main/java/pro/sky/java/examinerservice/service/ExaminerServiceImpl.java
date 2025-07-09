package pro.sky.java.examinerservice.service;

import org.springframework.stereotype.Service;
import pro.sky.java.examinerservice.domain.Question;

import java.util.Collection;
import java.util.List;

@Service
public class ExaminerServiceImpl implements ExaminerService{
    @Override
    public Collection<Question> getQuestions(int amount) {
        return null;
    }
}
