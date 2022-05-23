package sky.pro.java.course2.courseproject2_2.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import sky.pro.java.course2.courseproject2_2.data.JavaQuestionRepository;
import sky.pro.java.course2.courseproject2_2.data.Question;
import sky.pro.java.course2.courseproject2_2.exceptions.NotFoundException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static sky.pro.java.course2.courseproject2_2.constants.QuestionServiceTestConstants.*;

@ExtendWith(MockitoExtension.class)
class MathQuestionServiceTest {

    @Mock
    private JavaQuestionRepository mathQuestionRepositoryMock;

    @InjectMocks
    private JavaQuestionService out;


    @Test
    public void shouldReturnAddedQuestionWhenAdd() {
        Question addedQuestion = new Question("4 + 4 = ", "8.");
        when(mathQuestionRepositoryMock.add("4 + 4 = ", "8.")).
                thenReturn(addedQuestion);

        assertEquals(addedQuestion, out.add("4 + 4 = ", "8."));
    }

    @Test
    public void shouldReturnQUESTION_TESTWhenRemove() {
        when(mathQuestionRepositoryMock.remove("7 / 0 = ")).
                thenReturn(MATH_QUESTION_TEST);
        assertEquals(MATH_QUESTION_TEST, out.remove("7 / 0 = "));
    }

    @Test
    public void shouldThrowExceptionWhenQuestionNotFouns() {
        when(mathQuestionRepositoryMock.remove("Такого вопроса нет.")).
                thenThrow(NotFoundException.class);
        assertThrows(NotFoundException.class, () -> out.remove("Такого вопроса нет."));
    }

    @Test
    public void shouldReturnQUESTOINS_TEST() {
        when(mathQuestionRepositoryMock.getAll()).thenReturn(MATH_QUESTIONS_TEST);
        assertEquals(MATH_QUESTIONS_TEST, out.getAll());
    }

    @Test
    public void checkNotNullWhenGetRandomQuestion() {
        when(mathQuestionRepositoryMock.getAll()).thenReturn(MATH_QUESTIONS_TEST);
        assertNotNull(out.getRandomQuestion());
    }
}