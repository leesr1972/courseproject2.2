package sky.pro.java.course2.courseproject2_2.data;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sky.pro.java.course2.courseproject2_2.exceptions.NotFoundException;

import static org.junit.jupiter.api.Assertions.*;
import static sky.pro.java.course2.courseproject2_2.constants.QuestionServiceTestConstants.*;

class JavaQuestionRepositoryTest {
    private final JavaQuestionRepository out = new JavaQuestionRepository();

    @BeforeEach
    public void setUp() {
        out.add("Что такое цикл?", "Это когда много раз.");
        out.add("Что такое массив?", "Это хранилище.");
        out.add("Что такое мок?", "Это заглушка.");
        out.add("Что такое метод?", "Это подпрограмма.");
        out.add("Что такое рекурсия?", "Это когда сам себя.");
    }

    @Test
    public void shouldReturnAddedQuestionWhenAdd() {
        Question addedQuestion = new Question("Что такое тест?", "Это проверка кода.");
        assertEquals(addedQuestion, out.add("Что такое тест?", "Это проверка кода."));
    }

    @Test
    public void shouldReturnQUESTION_TESTWhenRemove() {
        assertEquals(JAVA_QUESTION_TEST, out.remove("Что такое цикл?"));
    }

    @Test
    public void shouldThrowExceptionWhenQuestionNotFouns() {
        assertThrows(NotFoundException.class, () -> out.remove("Такого вопроса нет."));
    }

    @Test
    public void shouldReturnQUESTOINS_TEST() {
        assertEquals(JAVA_QUESTIONS_TEST, out.getAll());
    }
}