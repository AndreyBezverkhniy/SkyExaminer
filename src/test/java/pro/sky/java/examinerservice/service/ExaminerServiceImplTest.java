package pro.sky.java.examinerservice.service;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;
import pro.sky.java.examinerservice.domain.Question;
import pro.sky.java.examinerservice.exception.UnavailableAmountRequestException;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {
    @InjectMocks
    ExaminerServiceImpl examinerServiceImpl;
    @Mock
    QuestionService questionService;

    final Question question1 = new Question("a?", "1");
    final Question question2 = new Question("b?", "2");
    final Question question3 = new Question("c?", "3");

    public void mockGetAll() {
        Collection<Question> threeQuestions = Set.of(question1, question2, question3);
        when(questionService.getAll()).thenReturn(threeQuestions);
    }

    public void mockGetRandomQuestion() {
        doAnswer(
                new Answer() {
                    int count = 0;

                    @Override
                    public Question answer(InvocationOnMock invocationOnMock) {
                        count = (count + 1) % 3;
                        return switch (count) {
                            case 0 -> question1;
                            case 1 -> question2;
                            case 3 -> question3;
                            default -> null;
                        };
                    }
                }
        ).when(questionService).getRandomQuestion();
    }

    @Test
    public void threeQuestions_whenGetQuestionsAmountZero_thenThrowsUnavailableAmountRequest() {
        mockGetAll();

        assertThrows(UnavailableAmountRequestException.class, () -> examinerServiceImpl.getQuestions(0));
    }

    @Test
    public void threeQuestions_whenGetQuestionsAmountMoreThanSize_thenThrowsUnavailableAmountRequest() {
        mockGetAll();

        assertThrows(UnavailableAmountRequestException.class, () -> examinerServiceImpl.getQuestions(4));
    }

    @Test
    public void threeQuestions_whenGetQuestionsAmountTwo_thenReturnsTwoOfThree() {
        mockGetAll();
        mockGetRandomQuestion();

        Collection<Question> result = examinerServiceImpl.getQuestions(2);

        Object resultToArray[] = result.stream().toArray();
        assertEquals(2, resultToArray.length);
        assertTrue(!Objects.equals(resultToArray[0], resultToArray[1]));
    }
}
