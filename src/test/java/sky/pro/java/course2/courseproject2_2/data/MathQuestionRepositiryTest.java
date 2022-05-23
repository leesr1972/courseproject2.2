package sky.pro.java.course2.courseproject2_2.data;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sky.pro.java.course2.courseproject2_2.exceptions.NotFoundException;

import static org.junit.jupiter.api.Assertions.*;
import static sky.pro.java.course2.courseproject2_2.constants.QuestionServiceTestConstants.*;

class MathQuestionRepositiryTest {
    private final MathQuestionRepositiry out = new MathQuestionRepositiry();

    @BeforeEach
    public void setUp() {
        out.add("5 + 7 = ", "13.");
        out.add("25 - 20 = ", "5.");
        out.add("3 * 8 = ", "24.");
        out.add("36 / 6 = ", "6.");
        out.add("7 / 0 = ", "На ноль делить нельзя.");
    }

    @Test
    public void shouldReturnAddedQuestionWhenAdd() {
        Question addedQuestion = new Question("4 + 4 = ", "8.");
        assertEquals(addedQuestion, out.add("4 + 4 = ", "8."));
    }

    @Test
    public void shouldReturnQUESTION_TESTWhenRemove() {
        assertEquals(MATH_QUESTION_TEST, out.remove("7 / 0 = "));
    }

    @Test
    public void shouldThrowExceptionWhenQuestionNotFouns() {
        assertThrows(NotFoundException.class, () -> out.remove("Такого вопроса нет."));
    }

    @Test
    public void shouldReturnQUESTOINS_TEST() {
        assertEquals(MATH_QUESTIONS_TEST, out.getAll());
    }
}