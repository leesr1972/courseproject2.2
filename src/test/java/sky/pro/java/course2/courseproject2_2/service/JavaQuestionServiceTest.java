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
import static org.mockito.Mockito.*;
import static sky.pro.java.course2.courseproject2_2.constants.QuestionServiceTestConstants.*;

@ExtendWith(MockitoExtension.class)
class JavaQuestionServiceTest {

    @Mock
    private JavaQuestionRepository javaQuestionRepositoryMock;

    @InjectMocks
    private JavaQuestionService out;


    @Test
    public void shouldReturnAddedQuestionWhenAdd() {
        Question addedQuestion = new Question("Что такое тест?", "Это проверка кода.");
        when(javaQuestionRepositoryMock.add("Что такое тест?", "Это проверка кода.")).
                thenReturn(addedQuestion);

        assertEquals(addedQuestion, out.add("Что такое тест?", "Это проверка кода."));
    }

    @Test
    public void shouldReturnQUESTION_TESTWhenRemove() {
        when(javaQuestionRepositoryMock.remove("Что такое цикл?")).
                thenReturn(JAVA_QUESTION_TEST);
        assertEquals(JAVA_QUESTION_TEST, out.remove("Что такое цикл?"));
    }

    @Test
    public void shouldThrowExceptionWhenQuestionNotFouns() {
        when(javaQuestionRepositoryMock.remove("Такого вопроса нет.")).
                thenThrow(NotFoundException.class);
        assertThrows(NotFoundException.class, () -> out.remove("Такого вопроса нет."));
    }

    @Test
    public void shouldReturnQUESTOINS_TEST() {
        when(javaQuestionRepositoryMock.getAll()).thenReturn(JAVA_QUESTIONS_TEST);
        assertEquals(JAVA_QUESTIONS_TEST, out.getAll());
    }

    @Test
    public void checkNotNullWhenGetRandomQuestion() {
        when(javaQuestionRepositoryMock.getAll()).thenReturn(JAVA_QUESTIONS_TEST);
        assertNotNull(out.getRandomQuestion());
    }
}