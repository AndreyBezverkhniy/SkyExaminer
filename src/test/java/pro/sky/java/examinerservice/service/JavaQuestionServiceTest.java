package pro.sky.java.examinerservice.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pro.sky.java.examinerservice.domain.Question;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class JavaQuestionServiceTest {
    JavaQuestionService javaQuestionService;

    @BeforeEach
    public void beforeEachTest() {
        javaQuestionService = new JavaQuestionService();
    }

    @Test
    public void noQuestions_whenGetAll_ThenReturnsEmptyCollection() {
        Collection<Question> result = javaQuestionService.getAll();

        assertTrue(result.isEmpty());
    }

    @Test
    public void noQuestions_whenAddTwoQuestions_theGetAllReturnsExactTwoQuestions() {
        String questionText1 = "a?";
        String answerText1 = "1";
        String questionText2 = "b?";
        String answerText2 = "2";
        javaQuestionService.add(questionText1, answerText1);
        javaQuestionService.add(questionText2, answerText2);

        Collection<Question> result = javaQuestionService.getAll();
        assertEquals(2, result.size());
        Question question1 = new Question(questionText1, answerText1);
        Question question2 = new Question(questionText2, answerText2);
        assertTrue(result.contains(question1));
        assertTrue(result.contains(question2));
    }

    @Test
    public void twoQuestions_whenRemoveExisting_thenGetAllReturnsOnlyOtherOne(){
        Question question1=new Question("a?","1");
        Question question2=new Question("b?","2");
        javaQuestionService.add(question1);
        javaQuestionService.add(question2);

        Question question=new Question("a?","1");
        javaQuestionService.remove(question);

        Collection<Question> result=javaQuestionService.getAll();
        assertEquals(1,result.size());
        assertTrue(result.contains(question2));
    }

    @Test
    public void twoQuestions_whenRemoveNotExisting_thenGetAllReturnsTheSameTwoQuestions(){
        Question question1=new Question("a?","1");
        Question question2=new Question("b?","2");
        javaQuestionService.add(question1);
        javaQuestionService.add(question2);

        Question question=new Question("c?","3");
        javaQuestionService.remove(question);

        Collection<Question> result=javaQuestionService.getAll();
        assertEquals(2,result.size());
        assertTrue(result.contains(question1));
        assertTrue(result.contains(question2));
    }

    @Test
    public void twoQuestions_whenGetRandomQuestion_thenReturnsOneOfTheseTwo(){
        Question question1=new Question("a?","1");
        Question question2=new Question("b?","2");
        javaQuestionService.add(question1);
        javaQuestionService.add(question2);

        Question question=javaQuestionService.getRandomQuestion();

        assertTrue(question1.equals(question)||question2.equals(question));
    }
}
