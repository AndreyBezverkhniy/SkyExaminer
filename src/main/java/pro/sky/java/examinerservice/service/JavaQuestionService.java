package pro.sky.java.examinerservice.service;

import org.springframework.stereotype.Service;
import pro.sky.java.examinerservice.domain.Question;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService{
    private Set<Question> questions;
    Random random;

    public JavaQuestionService() {
        this.questions=new HashSet<Question>();
        random=new Random();
    }

    @Override
    public Question add(String question, String answer) {
        Question questionAnswer=new Question(question,answer);
        return add(questionAnswer);
    }

    @Override
    public Question add(Question question) {
        questions.add(question);
        if(!questions.add(question)){
            return null;
        }
        return questions.stream().filter(question::equals).findFirst().get();
    }

    @Override
    public Question remove(Question question) {
        if(questions.remove(question)){
            return question;
        }
        return null;
    }

    @Override
    public Collection<Question> getAll() {
        return questions;
    }

    @Override
    public Question getRandomQuestion() {
        int index=random.nextInt(questions.size());
        return questions.stream().skip(index).findFirst().get();
    }
}
